package com.mirjana.android.helloservice.bill;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.bean.*;

import java.util.List;

public class BillListRecyclerAdapter extends RecyclerView.Adapter<BillListRecyclerAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextMonth;
        public TextView mTextYear;
        public TextView mTextPublishingPlace;
        public TextView mTextTotalAmount;

        private RelativeLayout mRelativeBill;
        public LinearLayout mLinearBill;

        public ViewHolder(View itemView) {
            super(itemView);

            mTextMonth = itemView.findViewById(R.id.textViewMonthBillItem);
            mTextYear = itemView.findViewById(R.id.textViewYearBillItem);
            mTextPublishingPlace = itemView.findViewById(R.id.textViewPublishingPlaceBillItem);
            mTextTotalAmount = itemView.findViewById(R.id.textViewTotalAmountBillItem);

            mRelativeBill = itemView.findViewById(R.id.relativeLayoutBillList);
            mLinearBill = itemView.findViewById(R.id.linearLayoutBillItem);
        }
    }

    private List<BillListItem> racuni;
    private Context mContext;

    public BillListRecyclerAdapter(List<BillListItem> racuni, Context context) {
        this.racuni = racuni;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.list_item_bill, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Racun racun = racuni.get(position).getRacun();
        ObracunskiPeriod op = racun.getIdOp();
        holder.mTextMonth.setText(op.getMesec());
        holder.mTextYear.setText(op.getGodina() + "");
        holder.mTextPublishingPlace.setText(racun.getMestoIzdavanja());
        holder.mTextTotalAmount.setText(racun.getUkupanIznos() + "");
        holder.mLinearBill.setBackgroundColor(racuni.get(position).getColor());
        if (!holder.mRelativeBill.hasOnClickListeners())
            holder.mRelativeBill.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, BillActivity.class);
                    intent.putExtra(BillListActivity.racunInfoKey, racun);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);

                }
            });
    }

    @Override
    public int getItemCount() {
        return racuni.size();
    }


}
