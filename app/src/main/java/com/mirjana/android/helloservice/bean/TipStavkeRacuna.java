package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class TipStavkeRacuna implements Serializable{
    @SerializedName("idTipaStavkeRacuna")
    private BigDecimal idTipaStavkeRacuna;
    @SerializedName("naziv")
    private String naziv;


    public BigDecimal getIdTipaStavkeRacuna ()
    {
        return idTipaStavkeRacuna;
    }

    public void setIdTipaStavkeRacuna (BigDecimal idTipaStavkeRacuna)
    {
        this.idTipaStavkeRacuna = idTipaStavkeRacuna;
    }

    public String getNaziv ()
    {
        return naziv;
    }

    public void setNaziv (String naziv)
    {
        this.naziv = naziv;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [naziv = "+naziv+", idTipaStavkeRacuna = "+idTipaStavkeRacuna+"]";
    }

}
