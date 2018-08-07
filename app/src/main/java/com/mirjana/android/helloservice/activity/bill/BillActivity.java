package com.mirjana.android.helloservice.activity.bill;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.widget.Toast;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.activity.consumer.*;
import com.mirjana.android.helloservice.bean.*;
import com.mirjana.android.helloservice.retrofit.*;

import java.util.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillActivity extends AppCompatActivity {

    private RecyclerView mRecycler;
    private BillAdapter mAdapter;

    private Potrosac mPotrosac;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);
        mPotrosac = (Potrosac)getIntent().getSerializableExtra(ConsumersActivity.potrosacGetBills);
        mRecycler = findViewById(R.id.recyclerViewBills);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        Call<List<Racun>> bills = RetrofitClient.getInstance().getApi().racuniPotrosaca(mPotrosac.getIdPotrosaca());
        bills.enqueue(new Callback<List<Racun>>() {
            @Override
            public void onResponse(Call<List<Racun>> call, Response<List<Racun>> response) {
                List<Racun> racuni = response.body();
                if (racuni != null){
                    mAdapter = new BillAdapter(racuni, getApplicationContext());
                    mRecycler.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<Racun>> call, Throwable t) {
                Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

    }
}
