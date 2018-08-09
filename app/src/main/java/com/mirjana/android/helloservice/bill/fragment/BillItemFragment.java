package com.mirjana.android.helloservice.bill.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.Toast;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.bean.*;
import com.mirjana.android.helloservice.bill.*;
import com.mirjana.android.helloservice.retrofit.*;

import java.util.*;

import retrofit2.*;

public class BillItemFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private BillItemRecyclerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bill_items, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerViewBillItems);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Call<List<StavkaRacuna>> items = RetrofitClient.getInstance().getApi().
                stavkeRacuna(((Racun)getActivity().getIntent().
                getSerializableExtra(BillListActivity.racunInfoKey)).getIdRacuna());
        items.enqueue(new Callback<List<StavkaRacuna>>() {
            @Override
            public void onResponse(Call<List<StavkaRacuna>> call, Response<List<StavkaRacuna>> response) {
                List<StavkaRacuna> stavke = response.body();
                if (stavke != null){
                    List<BillItemItem> billItems = new ArrayList<>();
                    for(int i = 0; i < stavke.size(); i++){
                        String numeration = (i+1) + "";
                        switch (i){
                            case 16: numeration = "A";
                                break;
                            case 17: numeration = "B";
                                break;
                            case 18: numeration = "C";
                                break;
                        }
                        billItems.add(new BillItemItem(stavke.get(i), 0,numeration));

                    }
                    mAdapter = new BillItemRecyclerAdapter(billItems, getContext());
                    mRecyclerView.setAdapter(mAdapter);
                }
            }

            @Override
            public void onFailure(Call<List<StavkaRacuna>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }
}
