package com.example.kirchhoff.rxexample.network.rest;


import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Streaming;
import rx.Observable;

/**
 * @author Kirchhoff-
 */

public interface HugeJsonApi {

    String SERVICE_ENDPOINT = "https://raw.githubusercontent.com";

    @Streaming
    @GET("/zemirco/sf-city-lots-json/master/citylots.json")
    Observable<ResponseBody> get();
}
