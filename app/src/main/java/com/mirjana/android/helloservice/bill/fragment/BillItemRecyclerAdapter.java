package com.mirjana.android.helloservice.bill.fragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.bean.StavkaRacuna;

import java.util.List;

public class BillItemRecyclerAdapter extends RecyclerView.Adapter<BillItemRecyclerAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextNumeration;
        public TextView mTextDescription;
        public TextView mTextPrice;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextNumeration = itemView.findViewById(R.id.textViewBillItemNumeration);
            mTextDescription = itemView.findViewById(R.id.textViewBillItemDescription);
            mTextPrice = itemView.findViewById(R.id.textViewBillItemPrice);
        }
    }

    private List<BillItemItem> mStavke;
    private Context mContext;

    public BillItemRecyclerAdapter(List<BillItemItem> stavke, Context context) {
        mStavke = stavke;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.
                from(parent.getContext()).inflate(R.layout.fragment_bill_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BillItemItem stavka = mStavke.get(position);
        holder.mTextNumeration.setText(stavka.getSerialNumber() + "");
        holder.mTextDescription.setText(stavka.getStavkaRacuna().getIdTipa().getNaziv());
        holder.mTextPrice.setText(stavka.getStavkaRacuna().getIznos() + "");
    }

    @Override
    public int getItemCount() {
        return mStavke.size();
    }


}
