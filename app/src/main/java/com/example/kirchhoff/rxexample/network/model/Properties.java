package com.example.kirchhoff.rxexample.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * @author Kirchhoff-
 */

public class Properties {

    @SerializedName("MAPBLKLOT")
    @Expose
    public String MAPBLKLOT;
    @SerializedName("BLKLOT")
    @Expose
    public String BLKLOT;
    @SerializedName("BLOCK_NUM")
    @Expose
    public String BLOCKNUM;
    @SerializedName("LOT_NUM")
    @Expose
    public String LOTNUM;
    @SerializedName("FROM_ST")
    @Expose
    public String FROMST;
    @SerializedName("TO_ST")
    @Expose
    public String TOST;
    @SerializedName("STREET")
    @Expose
    public String STREET;
    @SerializedName("ST_TYPE")
    @Expose
    public Object STTYPE;
    @SerializedName("ODD_EVEN")
    @Expose
    public String ODDEVEN;
}
