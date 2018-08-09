package com.mirjana.android.helloservice.retrofit;

import com.mirjana.android.helloservice.bean.*;
import com.mirjana.android.helloservice.bean.wrapper.*;

import java.math.BigDecimal;
import java.util.*;

import retrofit2.*;
import retrofit2.http.*;

public interface Api {

    @FormUrlEncoded
    @POST("logovanje")
    Call<KorisnikInfo> findUser(
            @Field("user") String user,
            @Field("pass") String pass
    );

    @GET("vratiKupcaZaEdBb")
    Call<KupacInfo> registracijaBrojila(
            @Query("edBroj") String edBroj,
            @Query("brojBrojila") BigDecimal brojBrojila
    );

    @POST("registracija")
    Call<Korisnik> registracijaKorisnika(@Body Korisnik korisnik);

    @GET("/vratiPotrosaceZaKupca")
    Call<List<Potrosac>> potrosaciKupca(@Query("idKupca") BigDecimal kupac);

    @GET("/vratiRacuneZaPotrosaca")
    Call<List<Racun>> racuniPotrosaca(@Query("idPotrosaca") BigDecimal potrosac);

    @GET("/vratiStavkeOcitavanja")
    Call<List<StavkaOcitavanja>> stavkeOcitavanja(@Query("idOcitavanja") BigDecimal ocitavanje);

    @GET("/vratiSveTarife")
    Call<List<Tarifa>> sveTarife();

    @GET("/vratiStavkeRacuna")
    Call<List<StavkaRacuna>> stavkeRacuna(@Query("idRacuna") BigDecimal racun);

}
