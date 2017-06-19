package com.example.kirchhoff.rxexample.network.rest;

import com.example.kirchhoff.rxexample.network.model.country.CountryData;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * @author Kirchhoff-
 */

public interface CountryApi {
    String SERVICE_ENDPOINT = "https://restcountries.eu/";

    @GET("rest/v1/callingcode/{ccc}")
    Observable<List<CountryData>> getRestCountriesCallingCode(@Path("ccc") String ccc);
}
