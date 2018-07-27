
package com.mirjana.android.helloservice.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.annotations.SerializedName;

public class Korisnik implements Serializable{

    @SerializedName("idKorisnika")
    private Integer idKorisnika;
    @SerializedName("korisnickoIme")
    private String korisnickoIme;
    @SerializedName("lozinka")
    private String lozinka;
    @SerializedName("idKupca")
    private Kupac kupac;
    //@JsonIgnore
    //private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getIdKorisnika() {
        return idKorisnika;
    }

    public void setIdKorisnika(Integer idKorisnika) {
        this.idKorisnika = idKorisnika;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    //@JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }

    //@JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}
