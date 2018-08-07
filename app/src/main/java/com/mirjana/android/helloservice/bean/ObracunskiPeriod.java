package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

class ObracunskiPeriod implements Serializable {
    @SerializedName("idOp")
    private BigDecimal idOp;
    @SerializedName("brojDana")
    private Integer brojDana;
    @SerializedName("datumOd")
    private Date datumOd;
    @SerializedName("datumDo")
    private Date datumDo;
    @SerializedName("godina")
    private Integer godina;
    @SerializedName("mesec")
    private String mesec;
    @SerializedName("nazivPerioda")
    private String nazivPerioda;

    public BigDecimal getIdOp() {
        return idOp;
    }

    public void setIdOp(BigDecimal idOp) {
        this.idOp = idOp;
    }

    public Integer getBrojDana() {
        return brojDana;
    }

    public void setBrojDana(Integer brojDana) {
        this.brojDana = brojDana;
    }

    public Date getDatumOd() {
        return datumOd;
    }

    public void setDatumOd(Date datumOd) {
        this.datumOd = datumOd;
    }

    public Date getDatumDo() {
        return datumDo;
    }

    public void setDatumDo(Date datumDo) {
        this.datumDo = datumDo;
    }

    public Integer getGodina() {
        return godina;
    }

    public void setGodina(Integer godina) {
        this.godina = godina;
    }

    public String getMesec() {
        return mesec;
    }

    public void setMesec(String mesec) {
        this.mesec = mesec;
    }

    public String getNazivPerioda() {
        return nazivPerioda;
    }

    public void setNazivPerioda(String nazivPerioda) {
        this.nazivPerioda = nazivPerioda;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [brojDana = "+brojDana+", datumOd = "+datumOd+", datumDo = "+datumDo+", idOp = "+idOp+", mesec = "+mesec+", nazivPerioda = "+nazivPerioda+", godina = "+godina+"]";
    }

}
