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
import com.mirjana.android.helloservice.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillRecyclerAdapter extends RecyclerView.Adapter<BillRecyclerAdapter.ViewHolder> {

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

    private List<Racun> racuni;
    private Context mContext;

    public BillRecyclerAdapter(List<Racun> racuni, Context context) {
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
        final Racun racun = racuni.get(position);
        holder.mTextMonth.setText(racun.getIdOp().getMesec());
        holder.mTextYear.setText(racun.getIdOp().getGodina() + "");
        holder.mTextPublishingPlace.setText(racun.getMestoIzdavanja());
        holder.mTextTotalAmount.setText(racun.getUkupanIznos() + "");
        if (position % 2 == 1)
            holder.mLinearBill.setBackgroundColor(
                    mContext.getResources().getColor(R.color.colorPrimary));
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
