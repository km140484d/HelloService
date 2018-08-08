package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class StavkaRacuna implements Serializable {
    @SerializedName("stavkaRacunaPK")
    private StavkaRacunaPK stavkaRacunaPK;
    @SerializedName("iznos")
    private BigDecimal iznos;
    @SerializedName("racun")
    private Racun racun;
    @SerializedName("idTipa")
    private TipStavkeRacuna idTipa;


    public StavkaRacunaPK getStavkaRacunaPK ()
    {
        return stavkaRacunaPK;
    }

    public void setStavkaRacunaPK (StavkaRacunaPK stavkaRacunaPK)
    {
        this.stavkaRacunaPK = stavkaRacunaPK;
    }

    public BigDecimal getIznos ()
    {
        return iznos;
    }

    public void setIznos (BigDecimal iznos)
    {
        this.iznos = iznos;
    }

    public Racun getRacun ()
    {
        return racun;
    }

    public void setRacun (Racun racun)
    {
        this.racun = racun;
    }

    public TipStavkeRacuna getIdTipa ()
    {
        return idTipa;
    }

    public void setIdTipa (TipStavkeRacuna idTipa)
    {
        this.idTipa = idTipa;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [idTipa = "+idTipa+", iznos = "+iznos+", stavkaRacunaPK = "+stavkaRacunaPK+", racun = "+racun+"]";
    }
}
