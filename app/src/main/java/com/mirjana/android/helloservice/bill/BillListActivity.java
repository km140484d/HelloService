package com.mirjana.android.helloservice.bill;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.*;
import android.widget.Toast;

import com.jjoe64.graphview.*;
import com.jjoe64.graphview.helper.StaticLabelsFormatter;
import com.jjoe64.graphview.series.*;
import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.consumer.*;
import com.mirjana.android.helloservice.bean.*;
import com.mirjana.android.helloservice.retrofit.*;

import java.util.*;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillListActivity extends AppCompatActivity {

    public static final String racunInfoKey = "RACUN_INFO";

    private RecyclerView mRecycler;
    private BillRecyclerAdapter mAdapter;
    private GraphView mGraph;

    private Potrosac mPotrosac;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bills);
        mPotrosac = (Potrosac)getIntent().getSerializableExtra(ConsumersActivity.potrosacGetBills);
        mRecycler = findViewById(R.id.recyclerViewBills);
        mRecycler.setHasFixedSize(true);
        mRecycler.setLayoutManager(new LinearLayoutManager(this));

        mGraph = findViewById(R.id.lineGraphBills);

        Call<List<Racun>> bills = RetrofitClient.getInstance().getApi().racuniPotrosaca(mPotrosac.getIdPotrosaca());
        bills.enqueue(new Callback<List<Racun>>() {
            @Override
            public void onResponse(Call<List<Racun>> call, Response<List<Racun>> response) {
                List<Racun> racuni = response.body();
                if (racuni != null){
                    mAdapter = new BillRecyclerAdapter(racuni, getApplicationContext());
                    mRecycler.setAdapter(mAdapter);

                    DataPoint[] points = new DataPoint [racuni.size()];
                    String[] labels = new String[racuni.size()];
                    for(int i = 0; i < racuni.size(); i++) {
                        Racun racun = racuni.get(i);
                        points[i] = new DataPoint(i, racun.getUkupanIznos().longValue());
                        labels[i] = racun.getIdOp().getMesec().substring(0,3);
                    }
                    LineGraphSeries<DataPoint> series = new LineGraphSeries<>(points);
                    mGraph.addSeries(series);

                    StaticLabelsFormatter staticLabelsFormatter = new StaticLabelsFormatter(mGraph);
                    staticLabelsFormatter.setHorizontalLabels(labels);
                    mGraph.getGridLabelRenderer().setLabelFormatter(staticLabelsFormatter);
                }
            }

            @Override
            public void onFailure(Call<List<Racun>> call, Throwable t) {
                Toast.makeText(getBaseContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });



    }
}
