package com.mirjana.android.helloservice.activity.consumer;

import android.content.*;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.*;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.activity.bill.BillListActivity;
import com.mirjana.android.helloservice.bean.Potrosac;

import java.util.*;

public class ConsumerAdapter extends RecyclerView.Adapter<ConsumerAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView mTextEDNumber;
        public TextView mTextAddress;

        public TextView mTextConsumerCategory;
        public TextView mTextPowerApproved;
        public TextView mTextPowerSupplyType;
        public ImageButton mButtonBill;

        public RelativeLayout mRelativeMoreInfo;
        public CardView mCardConsumer;

        public ViewHolder(View itemView) {
            super(itemView);
            mTextEDNumber = itemView.findViewById(R.id.textViewEDNumberConsumerItem);
            mTextAddress = itemView.findViewById(R.id.textViewAddressConsumerItem);

            mRelativeMoreInfo = itemView.findViewById(R.id.relativeLayoutConsumerList);
            mRelativeMoreInfo.setVisibility(View.GONE);

            mCardConsumer = itemView.findViewById(R.id.cardViewConsumer);
            mCardConsumer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mRelativeMoreInfo.getVisibility() == View.GONE)
                        mRelativeMoreInfo.setVisibility(View.VISIBLE);
                    else
                        mRelativeMoreInfo.setVisibility(View.GONE);
                }
            });

            mTextConsumerCategory = itemView.findViewById(R.id.textViewConsumerCategory);
            mTextPowerApproved = itemView.findViewById(R.id.textViewPowerApproved);
            mTextPowerSupplyType = itemView.findViewById(R.id.textViewPowerSupplyType);
            mButtonBill = itemView.findViewById(R.id.imageButtonConsumerBill);

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
        final Potrosac potrosac = item.getPotrosac();
        holder.mTextEDNumber.setText(potrosac.getEdBroj());
        holder.mTextAddress.setText(potrosac.getAdresa().description());

        holder.mTextConsumerCategory.setText(context.getString(R.string.tabbed_argument,
                potrosac.getKategorijaPotrosnje()));
        holder.mTextPowerApproved.setText(context.getString(R.string.tabbed_argument,
                potrosac.getOdobrenaSnaga()));
        holder.mTextPowerSupplyType.setText(context.getString(R.string.tabbed_argument,
                potrosac.getVrstaSnabdevanja()));
        if (item.isFirst()){
            item.setFirst(false);
            holder.mButtonBill.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent  = new Intent(context, BillListActivity.class);
                    intent.putExtra(ConsumersActivity.potrosacGetBills, potrosac);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return consumers.size();
    }
}
