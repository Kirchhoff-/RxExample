package com.example.kirchhoff.rxexample.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.observables.SyncOnSubscribe;

/**
 * @author Kirchhoff-
 */

public class RestUtils {

    public static <T> T createService(final Class<T> clazz, String endpoint) {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.MICROSECONDS).build();

        return new Retrofit.Builder()
                .baseUrl(endpoint)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build()
                .create(clazz);
    }

    public static <T> Observable<T> convertObjectsStream(ResponseBody responseBody, Class<T> clazz) {

        Type type = TypeToken.get(clazz).getType();
        Gson gson = new GsonBuilder().create();

        return Observable.create(SyncOnSubscribe.<JsonReader, T>createStateful(
                () -> {

                    try {
                        JsonReader reader = gson.newJsonReader(responseBody.charStream());
                        reader.beginObject();

                        while (reader.hasNext()) {
                            if (reader.nextName().equals("features")) {
                                reader.beginArray();
                                return reader;
                            }
                            reader.skipValue();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return null;
                },
                (reader, observer) -> {
                    if (reader == null) {
                        observer.onCompleted();
                        return null;
                    }

                    try {
                        if (reader.hasNext()) {
                            T t = gson.fromJson(reader, type);
                            observer.onNext(t);
                        } else {
                            observer.onCompleted();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        observer.onError(e);
                    }

                    return reader;
                }
                , Util::closeQuietly
        ));
    }
}
