package com.mirjana.android.helloservice.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;


import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.bean.*;
import com.mirjana.android.helloservice.retrofit.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConsumersActivity extends AppCompatActivity {

    public static final String potrosacGetBills = "POTROSAC_RACUNI";

    private RecyclerView recycler;
    private ConsumerAdapter adapter;

    private List<ConsumerListItem> consumerItems = new ArrayList<>();

    private Kupac kupac;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumers);
        kupac = (Kupac)getIntent().getSerializableExtra(InfoActivity.kupacGetConsumers);

        recycler = findViewById(R.id.recyclerViewConsumers);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        Call<List<Potrosac>> consumers = RetrofitClient.getInstance().getApi().
                potrosaciKupca(BigDecimal.valueOf(kupac.getIdKupca()));

        consumers.enqueue(new Callback<List<Potrosac>>() {
            @Override
            public void onResponse(Call<List<Potrosac>> call, Response<List<Potrosac>> response) {
                List<Potrosac> potrosaci = response.body();
                if (potrosaci != null){
                    System.out.println("Broj potrosaca: " + potrosaci.size());
                    System.out.println(potrosaci.get(0).getEdBroj());
                    if (potrosaci.get(0).getAdresa() == null)
                        System.out.println(potrosaci.get(0).toString());
                    //Toast.makeText(getBaseContext(), "Broj potrosaca: " + potrosaci.size(), Toast.LENGTH_LONG).show();
                    for(Potrosac p: potrosaci)
                        consumerItems.add(new ConsumerListItem(p));

                    adapter = new ConsumerAdapter(consumerItems, getApplicationContext());
                    recycler.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Potrosac>> call, Throwable t) {
                Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



    }
}
