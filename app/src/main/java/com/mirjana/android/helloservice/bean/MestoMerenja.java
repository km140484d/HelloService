package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

class MestoMerenja implements Serializable{
    @SerializedName("idMm")
    private BigDecimal idMm;
    @SerializedName("brBrojila")
    private BigDecimal brBrojila;
    @SerializedName("idAdreseMm")
    private Adresa idAdreseMm;
    @SerializedName("idObracunskeSnage")
    private ObracunskaSnaga idObracunskeSnage;
    @SerializedName("idPotrosaca")
    private Potrosac idPotrosaca;


    public BigDecimal getIdMm ()
    {
        return idMm;
    }

    public void setIdMm (BigDecimal idMm)
    {
        this.idMm = idMm;
    }

    public BigDecimal getBrBrojila ()
    {
        return brBrojila;
    }

    public void setBrBrojila (BigDecimal brBrojila)
    {
        this.brBrojila = brBrojila;
    }


    public Adresa getIdAdreseMm ()
    {
        return idAdreseMm;
    }

    public void setIdAdreseMm (Adresa idAdreseMm)
    {
        this.idAdreseMm = idAdreseMm;
    }

    public ObracunskaSnaga getIdObracunskeSnage ()
    {
        return idObracunskeSnage;
    }

    public void setIdObracunskeSnage (ObracunskaSnaga idObracunskeSnage)
    {
        this.idObracunskeSnage = idObracunskeSnage;
    }

    public Potrosac getIdPotrosaca ()
    {
        return idPotrosaca;
    }

    public void setIdPotrosaca (Potrosac idPotrosaca)
    {
        this.idPotrosaca = idPotrosaca;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [idMm = "+idMm+", idPotrosaca = "+idPotrosaca+", brBrojila = "+brBrojila+", idObracunskeSnage = "+idObracunskeSnage+", idAdreseMm = "+idAdreseMm+"]";
    }

}
