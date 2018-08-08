package com.mirjana.android.helloservice.activity.bill.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.*;
import android.widget.*;

import com.jjoe64.graphview.*;
import com.jjoe64.graphview.series.*;
import com.jjoe64.graphview.series.DataPoint;
import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.activity.bill.*;
import com.mirjana.android.helloservice.bean.*;

import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class BillInfoFragment extends Fragment {

    //basic info
    private TextView mTextBillingPeriod;
    private TextView mTextDayNumber;
    private TextView mTextPublishingDate;
    private TextView mTextPublishingPlace;
    private TextView mTextTrafficExcise;

    //graph
    private GraphView mGraphConsumption;

    //tariff
    private TextView mTextLowPrevTariff;
    private TextView mTextHighPrevTariff;
    private TextView mTextLowNewTariff;
    private TextView mTextHighNewTariff;
    private TextView mTextLowConsumption;
    private TextView mTextHighConsumption;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bill_info, container, false);
        Racun racun = (Racun)getActivity().getIntent().getSerializableExtra(BillListActivity.racunInfoKey);
        initViews(view, racun);
        return view;
    }

    private void initViews(View view, Racun racun) {
        ObracunskiPeriod op = racun.getIdOp();
        mTextBillingPeriod = view.findViewById(R.id.textViewBillBillingPeriod);
            mTextBillingPeriod.setText(new SimpleDateFormat("MM.dd.yyyy.").format(op.getDatumOd())
                    + "-" + new SimpleDateFormat("MM.dd.yyyy.").format(op.getDatumDo()));
        mTextDayNumber = view.findViewById(R.id.textViewBillDayNumber);
            mTextDayNumber.setText(op.getBrojDana() + "");
        mTextPublishingDate = view.findViewById(R.id.textViewBillPublishingDate);
            mTextPublishingDate.setText(new SimpleDateFormat("MM.dd.yyyy.").format(racun.getDatumIzdavanja()) + "");
        mTextPublishingPlace = view.findViewById(R.id.textViewBillPublishingPlace);
            mTextPublishingPlace.setText(racun.getMestoIzdavanja());
        mTextTrafficExcise = view.findViewById(R.id.textViewBillTrafficExciseDate);
            mTextTrafficExcise.setText(new SimpleDateFormat("MM.dd.yyyy.").format(racun.getDatumPrometa()) + "");

        mGraphConsumption = view.findViewById(R.id.barGraphViewTariff);

        DataPoint[] firstSeries = new DataPoint [2];
        DataPoint[] secondSeries = new DataPoint [2];

        Ocitavanje ocitavanje = racun.getIdOcitavanja();
        firstSeries[0] = new DataPoint(1, ocitavanje.getPrethodnoMt().longValue());
        firstSeries[1] = new DataPoint(3, ocitavanje.getPrethodnoVt().longValue());
        BarGraphSeries<DataPoint> series1 = new BarGraphSeries<>(firstSeries);
        series1.setDataWidth(2.0);
        series1.setColor(getResources().getColor(R.color.colorPrimaryDark));
        mGraphConsumption.addSeries(series1);

        secondSeries[0] = new DataPoint(1, ocitavanje.getNovoMt().longValue());
        secondSeries[1] = new DataPoint(3, ocitavanje.getNovoVt().longValue());
        BarGraphSeries<DataPoint> series2 = new BarGraphSeries<>(secondSeries);
        series2.setColor(getResources().getColor(R.color.colorAccent));
        series2.setAnimated(true);
        mGraphConsumption.addSeries(series2);

        mTextLowPrevTariff = view.findViewById(R.id.textViewLowPrevTariff);
            mTextLowPrevTariff.setText(ocitavanje.getPrethodnoMt() + "");
        mTextHighPrevTariff = view.findViewById(R.id.textViewHighPrevTariff);
            mTextHighPrevTariff.setText(ocitavanje.getPrethodnoVt() + "");
        mTextLowNewTariff = view.findViewById(R.id.textViewLowNewTariff);
            mTextLowNewTariff.setText(ocitavanje.getNovoMt() + "");
        mTextHighNewTariff = view.findViewById(R.id.textViewHighNewTariff);
            mTextHighNewTariff.setText(ocitavanje.getNovoVt() + "");

        MathContext math = new MathContext(2);
        mTextLowConsumption = view.findViewById(R.id.textViewLowTariffConsumption);
            mTextLowConsumption.setText((new DecimalFormat("#0.##").format(ocitavanje.getNovoMt().subtract(
                    ocitavanje.getPrethodnoMt(), math)) + ""));
        mTextHighConsumption = view.findViewById(R.id.textViewHighTariffConsumption);
            mTextHighConsumption.setText((new DecimalFormat("#0.##").format(ocitavanje.getNovoVt().subtract(
                    ocitavanje.getPrethodnoVt(), math)) + ""));
    }
}
