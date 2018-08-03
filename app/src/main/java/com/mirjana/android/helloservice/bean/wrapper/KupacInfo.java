package com.mirjana.android.helloservice.bean.wrapper;

import com.google.gson.annotations.SerializedName;
import com.mirjana.android.helloservice.bean.Korisnik;
import com.mirjana.android.helloservice.bean.Kupac;

import java.io.Serializable;

public class KupacInfo implements Serializable {

    @SerializedName("error")
    private String error;
    @SerializedName("message")
    private String message;
    @SerializedName("object")
    private Kupac object;

    public void setError(String error) {
        this.error = error;
    }
    public String getError() {
        return error;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void setObject(Kupac object) {
        this.object = object;
    }
    public Kupac getObject() {
        return object;
    }
}
