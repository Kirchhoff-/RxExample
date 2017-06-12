package com.example.kirchhoff.rxexample.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Kirchhoff-
 */

public class Feature {

    @SerializedName("type")
    @Expose
    public String type;
    @SerializedName("properties")
    @Expose
    public Properties properties;
    @SerializedName("geometry")
    @Expose
    public Geometry geometry;
}
