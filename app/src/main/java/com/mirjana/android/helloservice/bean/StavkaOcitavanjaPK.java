package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class StavkaOcitavanjaPK implements Serializable {
    @SerializedName("idOcitavanja")
    private BigDecimal idOcitavanja;
    @SerializedName("idStavkeOc")
    private BigDecimal idStavkeOc;

    public BigDecimal getIdOcitavanja ()
    {
        return idOcitavanja;
    }

    public void setIdOcitavanja (BigDecimal idOcitavanja)
    {
        this.idOcitavanja = idOcitavanja;
    }

    public BigDecimal getIdStavkeOc ()
    {
        return idStavkeOc;
    }

    public void setIdStavkeOc (BigDecimal idStavkeOc)
    {
        this.idStavkeOc = idStavkeOc;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [idOcitavanja = "+idOcitavanja+", idStavkeOc = "+idStavkeOc+"]";
    }
}
