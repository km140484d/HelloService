package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

class ObracunskaSnaga implements Serializable{
    @SerializedName("idObracunskeSnage")
    private BigDecimal idObracunskeSnage;
    @SerializedName("utroseno")
    private BigDecimal utroseno;
    @SerializedName("cenaPoJedinici")
    private BigDecimal cenaPoJedinici;

    public BigDecimal getIdObracunskeSnage ()
    {
        return idObracunskeSnage;
    }

    public void setIdObracunskeSnage (BigDecimal idObracunskeSnage)
    {
        this.idObracunskeSnage = idObracunskeSnage;
    }

    public BigDecimal getUtroseno ()
    {
        return utroseno;
    }

    public void setUtroseno (BigDecimal utroseno)
    {
        this.utroseno = utroseno;
    }

    public BigDecimal getCenaPoJedinici ()
    {
        return cenaPoJedinici;
    }

    public void setCenaPoJedinici (BigDecimal cenaPoJedinici)
    {
        this.cenaPoJedinici = cenaPoJedinici;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [cenaPoJedinici = "+cenaPoJedinici+", utroseno = "+utroseno+", idObracunskeSnage = "+idObracunskeSnage+"]";
    }

}
