package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Blob;
import java.util.Date;

public class Racun implements Serializable {
    @SerializedName("idRacuna")
    private BigDecimal idRacuna;
    @SerializedName("datumIzdavanja")
    private Date datumIzdavanja;
    @SerializedName("datumPrometa")
    private Date datumPrometa;
    @SerializedName("mestoIzdavanja")
    private String mestoIzdavanja;
    @SerializedName("pozivNaBroj")
    private String pozivNaBroj;
    @SerializedName("racunPdf")
    private Blob racunPdf;
    @SerializedName("ukupanIznos")
    private BigDecimal ukupanIznos;
    @SerializedName("idOp")
    private ObracunskiPeriod idOp;
    @SerializedName("idOcitavanja")
    private Ocitavanje idOcitavanja;
    @SerializedName("idPotrosaca")
    private Potrosac idPotrosaca;


    public BigDecimal getIdRacuna ()
    {
        return idRacuna;
    }

    public void setIdRacuna (BigDecimal idRacuna)
    {
        this.idRacuna = idRacuna;
    }

    public Date getDatumIzdavanja ()
    {
        return datumIzdavanja;
    }

    public void setDatumIzdavanja (Date datumIzdavanja)
    {
        this.datumIzdavanja = datumIzdavanja;
    }

    public Date getDatumPrometa ()
    {
        return datumPrometa;
    }

    public void setDatumPrometa (Date datumPrometa)
    {
        this.datumPrometa = datumPrometa;
    }

    public String getMestoIzdavanja ()
    {
        return mestoIzdavanja;
    }

    public void setMestoIzdavanja (String mestoIzdavanja)
    {
        this.mestoIzdavanja = mestoIzdavanja;
    }

    public String getPozivNaBroj ()
    {
        return pozivNaBroj;
    }

    public void setPozivNaBroj (String pozivNaBroj) {
        this.pozivNaBroj = pozivNaBroj;
    }

    public Blob getRacunPdf() {
        return racunPdf;
    }

    public void setRacunPdf(Blob racunPdf) {
        this.racunPdf = racunPdf;
    }

    public BigDecimal getUkupanIznos ()
    {
        return ukupanIznos;
    }

    public void setUkupanIznos (BigDecimal ukupanIznos)
    {
        this.ukupanIznos = ukupanIznos;
    }

    public ObracunskiPeriod getIdOp ()
    {
        return idOp;
    }

    public void setIdOp (ObracunskiPeriod idOp)
    {
        this.idOp = idOp;
    }

    public Potrosac getIdPotrosaca ()
    {
        return idPotrosaca;
    }

    public void setIdPotrosaca (Potrosac idPotrosaca)
    {
        this.idPotrosaca = idPotrosaca;
    }

    public Ocitavanje getIdOcitavanja ()
    {
        return idOcitavanja;
    }

    public void setIdOcitavanja (Ocitavanje idOcitavanja)
    {
        this.idOcitavanja = idOcitavanja;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [datumPrometa = "+datumPrometa+", idOcitavanja = "+idOcitavanja+", pozivNaBroj = "+pozivNaBroj+", idRacuna = "+idRacuna+", idPotrosaca = "+idPotrosaca+", idOp = "+idOp+", ukupanIznos = "+ukupanIznos+", mestoIzdavanja = "+mestoIzdavanja+", datumIzdavanja = "+datumIzdavanja+"]";
    }
}
