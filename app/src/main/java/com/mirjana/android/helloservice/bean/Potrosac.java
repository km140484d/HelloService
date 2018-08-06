package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;

public class Potrosac implements Serializable{
    @SerializedName("idPotrosaca")
    private Integer idPotrosaca;
    @SerializedName("edBroj")
    private String edBroj;
    @SerializedName("kategorijaPotrosnje")
    private String kategorijaPotrosnje;
    @SerializedName("odobrenaSnaga")
    private BigDecimal odobrenaSnaga;
    @SerializedName("vrstaSnabdevanja")
    private String vrstaSnabdevanja;
    @SerializedName("idAdreseMm")
    private Adresa adresaMm;
    @SerializedName("idKupca")
    private Kupac kupac;

    public String getVrstaSnabdevanja ()
    {
        return vrstaSnabdevanja;
    }

    public void setVrstaSnabdevanja (String vrstaSnabdevanja)
    {
        this.vrstaSnabdevanja = vrstaSnabdevanja;
    }

    public String getKategorijaPotrosnje ()
    {
        return kategorijaPotrosnje;
    }

    public void setKategorijaPotrosnje (String kategorijaPotrosnje)
    {
        this.kategorijaPotrosnje = kategorijaPotrosnje;
    }

    public Integer getIdPotrosaca ()
    {
        return idPotrosaca;
    }

    public void setIdPotrosaca (Integer idPotrosaca)
    {
        this.idPotrosaca = idPotrosaca;
    }

    public BigDecimal getOdobrenaSnaga ()
    {
        return odobrenaSnaga;
    }

    public void setOdobrenaSnaga (BigDecimal odobrenaSnaga)
    {
        this.odobrenaSnaga = odobrenaSnaga;
    }

    public String getEdBroj ()
    {
        return edBroj;
    }

    public void setEdBroj (String edBroj)
    {
        this.edBroj = edBroj;
    }

    public Adresa getAdresa ()
    {
        return adresaMm;
    }

    public void setIdAdreseMm (Adresa adreseMm)
    {
        this.adresaMm = adreseMm;
    }

    public Kupac getKupac ()
    {
        return kupac;
    }

    public void setIdKupca (Kupac kupac)
    {
        this.kupac = kupac;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [vrstaSnabdevanja = "+vrstaSnabdevanja+", kategorijaPotrosnje = "+kategorijaPotrosnje+", idPotrosaca = "+idPotrosaca+", odobrenaSnaga = "+odobrenaSnaga+", edBroj = "+edBroj+", idAdreseMm = "+ adresaMm+", idKupca = "+kupac+"]";
    }
}
