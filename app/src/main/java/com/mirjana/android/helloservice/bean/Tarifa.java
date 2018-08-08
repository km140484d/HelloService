package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class Tarifa implements Serializable{
    @SerializedName("idTarife")
    private BigDecimal idTarife;
    @SerializedName("cena")
    private BigDecimal cena;
    @SerializedName("tip")
    private String tip;
    @SerializedName("zona")
    private String zona;

    public BigDecimal getIdTarife ()
    {
        return idTarife;
    }

    public void setIdTarife (BigDecimal idTarife)
    {
        this.idTarife = idTarife;
    }

    public BigDecimal getCena ()
    {
        return cena;
    }

    public void setCena (BigDecimal cena) {
        this.cena = cena;
    }

    public String getTip ()
    {
        return tip;
    }

    public void setTip (String tip)
    {
        this.tip = tip;
    }

    public String getZona ()
    {
        return zona;
    }

    public void setZona (String zona)
    {
        this.zona = zona;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [zona = "+zona+", tip = "+tip+", cena = "+cena+", idTarife = "+idTarife+"]";
    }
}
