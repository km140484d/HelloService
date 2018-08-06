package com.mirjana.android.helloservice.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import com.mirjana.android.helloservice.R;
import java.util.ArrayList;
import java.util.List;

public class ConsumersActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private ConsumerAdapter adapter;

    private List<ConsumerListItem> consumers;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consumers);

        recycler = findViewById(R.id.recyclerViewConsumers);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        consumers = new ArrayList<>();
        for(int i = 0; i < 10; i++)
            consumers.add(new ConsumerListItem(i + " ", i + " "));

        adapter = new ConsumerAdapter(consumers, this);
        recycler.setAdapter(adapter);

    }
}
