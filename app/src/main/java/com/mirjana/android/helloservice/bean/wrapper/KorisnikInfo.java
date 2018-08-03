package com.mirjana.android.helloservice.bean.wrapper;

import com.google.gson.annotations.SerializedName;
import com.mirjana.android.helloservice.bean.Korisnik;

import java.io.Serializable;

public class KorisnikInfo implements Serializable{
    @SerializedName("error")
    private String error;
    @SerializedName("message")
    private String message;
    @SerializedName("object")
    private Korisnik object;

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

    public void setObject(Korisnik object) {
        this.object = object;
    }
    public Korisnik getObject() {
        return object;
    }

}
