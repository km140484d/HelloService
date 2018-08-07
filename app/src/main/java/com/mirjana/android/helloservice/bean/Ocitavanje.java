package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

class Ocitavanje implements Serializable{
    @SerializedName("idOcitavanja")
    private BigDecimal idOcitavanja;
    @SerializedName("novoMt")
    private BigDecimal novoMt;
    @SerializedName("novoVt")
    private BigDecimal novoVt;
    @SerializedName("prethodnoMt")
    private BigDecimal prethodnoMt;
    @SerializedName("prethodnoVt")
    private BigDecimal prethodnoVt;
    @SerializedName("idMm")
    private MestoMerenja idMm;

    public BigDecimal getIdOcitavanja ()
    {
        return idOcitavanja;
    }

    public void setIdOcitavanja (BigDecimal idOcitavanja)
    {
        this.idOcitavanja = idOcitavanja;
    }


    public BigDecimal getNovoMt ()
    {
        return novoMt;
    }

    public void setNovoMt (BigDecimal novoMt)
    {
        this.novoMt = novoMt;
    }

    public BigDecimal getNovoVt ()
    {
        return novoVt;
    }

    public void setNovoVt (BigDecimal novoVt)
    {
        this.novoVt = novoVt;
    }

    public BigDecimal getPrethodnoMt ()
    {
        return prethodnoMt;
    }

    public void setPrethodnoMt (BigDecimal prethodnoMt)
    {
        this.prethodnoMt = prethodnoMt;
    }

    public BigDecimal getPrethodnoVt ()
    {
        return prethodnoVt;
    }

    public void setPrethodnoVt (BigDecimal prethodnoVt)
    {
        this.prethodnoVt = prethodnoVt;
    }

    public MestoMerenja getIdMm ()
    {
        return idMm;
    }

    public void setIdMm (MestoMerenja idMm)
    {
        this.idMm = idMm;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [novoVt = "+novoVt+", idOcitavanja = "+idOcitavanja+", prethodnoVt = "+prethodnoVt+", novoMt = "+novoMt+", idMm = "+idMm+", prethodnoMt = "+prethodnoMt+"]";
    }

}
