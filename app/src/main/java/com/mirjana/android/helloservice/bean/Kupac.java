
package com.mirjana.android.helloservice.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Kupac implements Serializable{
    @SerializedName("idKupca")
    private Integer idKupca;
    @SerializedName("jmbg")
    private String jmbg;
    @SerializedName("maticniBroj")
    private String maticniBroj;
    @SerializedName("naplatniBroj")
    private String naplatniBroj;
    @SerializedName("naziv")
    private String naziv;
    @SerializedName("pib")
    private Integer pib;
    @SerializedName("prosireniNaziv")
    private String prosireniNaziv;
    @SerializedName("tip")
    private String tip;
    @SerializedName("idAdreseSr")
    private Adresa adresa;
    //@JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getIdKupca() {
        return idKupca;
    }

    public void setIdKupca(Integer idKupca) {
        this.idKupca = idKupca;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getMaticniBroj() {
        return maticniBroj;
    }

    public void setMaticniBroj(String maticniBroj) {
        this.maticniBroj = maticniBroj;
    }

    public String getNaplatniBroj() {
        return naplatniBroj;
    }

    public void setNaplatniBroj(String naplatniBroj) {
        this.naplatniBroj = naplatniBroj;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Integer getPib() {
        return pib;
    }

    public void setPib(Integer pib) {
        this.pib = pib;
    }

    public String getProsireniNaziv() {
        return prosireniNaziv;
    }

    public void setProsireniNaziv(String prosireniNaziv) {
        this.prosireniNaziv = prosireniNaziv;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public Adresa getAdresa() {
        return adresa;
    }

    public void setAdresa(Adresa adresa) {
        this.adresa = adresa;
    }

//    //@JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    //@JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}
