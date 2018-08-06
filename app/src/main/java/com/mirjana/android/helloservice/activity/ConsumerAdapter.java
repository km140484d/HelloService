package com.mirjana.android.helloservice.activity;

import android.content.*;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.*;

import com.mirjana.android.helloservice.R;

import java.util.*;

public class ConsumerAdapter extends RecyclerView.Adapter<ConsumerAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextEDNumber;
        public TextView mTextAddress;



        public ViewHolder(View itemView) {
            super(itemView);
            mTextEDNumber = itemView.findViewById(R.id.textViewEDNumberConsumerItem);
            mTextAddress = itemView.findViewById(R.id.textViewAddressConsumerItem);
        }
    }

    private List<ConsumerListItem> consumers;
    private Context context;

    public ConsumerAdapter(List<ConsumerListItem> consumers, Context context) {
        this.consumers = consumers;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item_consumer, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ConsumerListItem item = consumers.get(position);
        holder.mTextEDNumber.setText(item.getPotrosac().getEdBroj());
        holder.mTextAddress.setText(item.getPotrosac().getAdresa().description());
    }

    @Override
    public int getItemCount() {
        return consumers.size();
    }
}
