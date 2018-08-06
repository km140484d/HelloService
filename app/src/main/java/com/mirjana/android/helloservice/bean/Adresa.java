
package com.mirjana.android.helloservice.bean;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Adresa implements Serializable{

    @SerializedName("idAdrese")
    private Integer idAdrese;
    @SerializedName("broj")
    private String broj;
    @SerializedName("grad")
    private String grad;
    @SerializedName("opstina")
    private String opstina;
    @SerializedName("ulica")
    private String ulica;

    //@JsonIgnore
//    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public Integer getIdAdrese() {
        return idAdrese;
    }

    public void setIdAdrese(Integer idAdrese) {
        this.idAdrese = idAdrese;
    }

    public String getBroj() {
        return broj;
    }

    public void setBroj(String broj) {
        this.broj = broj;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getOpstina() {
        return opstina;
    }

    public void setOpstina(String opstina) {
        this.opstina = opstina;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public String description(){
        return ulica + " " + broj + "\n" + opstina + ", " + grad;

    }

//    //@JsonAnyGetter
//    public Map<String, Object> getAdditionalProperties() {
//        return this.additionalProperties;
//    }
//
//    //@JsonAnySetter
//    public void setAdditionalProperty(String name, Object value) {
//        this.additionalProperties.put(name, value);
//    }

}
