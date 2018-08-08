package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class StavkaRacunaPK implements Serializable{
    @SerializedName("idRacuna")
    private BigDecimal idRacuna;
    @SerializedName("idStavkeRacuna")
    private BigDecimal idStavkeRacuna;

    public BigDecimal getIdRacuna ()
    {
        return idRacuna;
    }

    public void setIdRacuna (BigDecimal idRacuna)
    {
        this.idRacuna = idRacuna;
    }

    public BigDecimal getIdStavkeRacuna ()
    {
        return idStavkeRacuna;
    }

    public void setIdStavkeRacuna (BigDecimal idStavkeRacuna)
    {
        this.idStavkeRacuna = idStavkeRacuna;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [idRacuna = "+idRacuna+", idStavkeRacuna = "+idStavkeRacuna+"]";
    }

}
