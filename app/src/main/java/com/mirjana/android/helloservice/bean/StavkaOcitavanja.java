package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class StavkaOcitavanja implements Serializable {
    @SerializedName("stavkaOcitavanjaPK")
    private StavkaOcitavanjaPK stavkaOcitavanjaPK;
    @SerializedName("utroseno")
    private BigDecimal utroseno;
    @SerializedName("ocitavanje")
    private Ocitavanje ocitavanje;
    @SerializedName("idTarife")
    private Tarifa idTarife;


    public StavkaOcitavanjaPK getStavkaOcitavanjaPK ()
    {
        return stavkaOcitavanjaPK;
    }

    public void setStavkaOcitavanjaPK (StavkaOcitavanjaPK stavkaOcitavanjaPK)
    {
        this.stavkaOcitavanjaPK = stavkaOcitavanjaPK;
    }

    public BigDecimal getUtroseno ()
    {
        return utroseno;
    }

    public void setUtroseno (BigDecimal utroseno)
    {
        this.utroseno = utroseno;
    }

    public Ocitavanje getOcitavanje ()
    {
        return ocitavanje;
    }

    public void setOcitavanje (Ocitavanje ocitavanje)
    {
        this.ocitavanje = ocitavanje;
    }

    public Tarifa getIdTarife ()
    {
        return idTarife;
    }

    public void setIdTarife (Tarifa idTarife)
    {
        this.idTarife = idTarife;
    }


    @Override
    public String toString()
    {
        return "ClassPojo [utroseno = "+utroseno+", ocitavanje = "+ocitavanje+", idTarife = "+idTarife+", stavkaOcitavanjaPK = "+stavkaOcitavanjaPK+"]";
    }

}
