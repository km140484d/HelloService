package com.mirjana.android.helloservice.activity.bill;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.*;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.bean.*;

import java.util.List;

public class BillAdapter extends RecyclerView.Adapter<BillAdapter.ViewHolder> {

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
            mRelativeBill.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mRelativeBill.setVisibility(View.GONE);
                }
            });
            mLinearBill = itemView.findViewById(R.id.linearLayoutBillItem);
        }
    }

    private List<Racun> racuni;
    private Context mContext;

    public BillAdapter(List<Racun> racuni, Context context) {
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
        Racun racun = racuni.get(position);
        holder.mTextMonth.setText(racun.getIdOp().getMesec());
        holder.mTextYear.setText(racun.getIdOp().getGodina() + "");
        holder.mTextPublishingPlace.setText(racun.getMestoIzdavanja());
        holder.mTextTotalAmount.setText(racun.getUkupanIznos() + "");
        if (position % 2 == 1)
            holder.mLinearBill.setBackgroundColor(
                    mContext.getResources().getColor(R.color.colorPrimary));
    }

    @Override
    public int getItemCount() {
        return racuni.size();
    }


}
