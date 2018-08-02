package com.mirjana.android.helloservice.retrofit;

import com.mirjana.android.helloservice.bean.*;

import java.math.BigDecimal;

import retrofit2.*;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Api {

    @FormUrlEncoded
    @POST("logovanje")
    Call<Korisnik> login(
            @Field("user") String user,
            @Field("pass") String pass
    );

    @GET("vratiKupcaZaEdBb")
    Call<Kupac> registracijaBrojila(
            @Field("edBroj") String edBroj,
            @Field("brojBrojila") BigDecimal brojBrojila
    );

}
