package com.mirjana.android.helloservice.retrofit.deserializer;

import com.google.gson.*;
import com.mirjana.android.helloservice.bean.*;

import java.lang.reflect.Type;

public class AdresaDeserializer implements JsonDeserializer<Adresa>{
    @Override
    public Adresa deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        System.out.println("1111111111111111");
        JsonElement address = json.getAsJsonObject().get("idAdreseMm");
        if (address == null){
            System.out.println("2222222222222222");
            address = json.getAsJsonObject().get("idAdreseSr");
            if (address == null)
                System.out.println("33333333333333333");
        }
        return new Gson().fromJson(address, Adresa.class);
    }
}
