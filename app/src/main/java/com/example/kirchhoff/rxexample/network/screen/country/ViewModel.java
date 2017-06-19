package com.example.kirchhoff.rxexample.network.screen.country;

import android.databinding.BaseObservable;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.CallSuper;
import android.support.annotation.Nullable;

import com.example.kirchhoff.rxexample.network.rest.CountryApi;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Kirchhoff-
 */

public class ViewModel extends BaseObservable {


    protected Retrofit retrofit = new Retrofit.Builder()
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(CountryApi.SERVICE_ENDPOINT)
            .build();

    protected ViewModel(@Nullable SavedState savedInstanceState) {

    }

    @CallSuper
    public void onStart() {

    }

    public SavedState getInstanceState() {
        return new SavedState(this);
    }

    @CallSuper
    public void onStop() {

    }

    public static class SavedState implements Parcelable {

        public static Creator<SavedState> CREATOR = new Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };

        protected SavedState(ViewModel viewModel) {

        }

        public SavedState(Parcel in) {

        }

        @Override
        public int describeContents() {
            return 0;
        }

        @CallSuper
        @Override
        public void writeToParcel(Parcel dest, int flags) {

        }
    }
}
