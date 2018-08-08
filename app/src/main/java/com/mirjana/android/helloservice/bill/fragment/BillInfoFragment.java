package com.mirjana.android.helloservice.bill.fragment;

import android.content.Intent;
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
import com.mirjana.android.helloservice.bill.*;
import com.mirjana.android.helloservice.bean.*;
import com.mirjana.android.helloservice.retrofit.RetrofitClient;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillInfoFragment extends Fragment {

    private static final String H_TARIFF = "Visa tarifa";
    private static final String L_TARIFF = "Niza tarifa";

    private static final String R_ZONE = "Crvena";
    private static final String B_ZONE = "Plava";
    private static final String G_ZONE = "Zelena";

    private static final int GREEN = 0;
    private static final int BLUE = 1;
    private static final int RED = 2;

    //basic info
    private TextView mTextBillingPeriod;
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

    //zones
    private TextView mTextGreenLow;
    private TextView mTextGreenHigh;
    private TextView mTextGreenUnit;
    private TextView mTextGreenTotal;

    private TextView mTextBlueLow;
    private TextView mTextBlueHigh;
    private TextView mTextBlueUnit;
    private TextView mTextBlueTotal;

    private TextView mTextRedLow;
    private TextView mTextRedHigh;
    private TextView mTextRedUnit;
    private TextView mTextRedTotal;

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
            mTextBillingPeriod.setText(op.getNazivPerioda() + " - " + op.getBrojDana());
        mTextPublishingDate = view.findViewById(R.id.textViewBillPublishingDate);
            mTextPublishingDate.setText(new SimpleDateFormat("MM/dd/yyyy").format(racun.getDatumIzdavanja()) + "");
        mTextPublishingPlace = view.findViewById(R.id.textViewBillPublishingPlace);
            mTextPublishingPlace.setText(racun.getMestoIzdavanja());
        mTextTrafficExcise = view.findViewById(R.id.textViewBillTrafficExciseDate);
            mTextTrafficExcise.setText(new SimpleDateFormat("MM/dd/yyyy").format(racun.getDatumPrometa()) + "");

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


        mTextGreenLow = view.findViewById(R.id.textViewGreenLow);
        mTextGreenHigh = view.findViewById(R.id.textViewGreenHigh);
        mTextGreenUnit = view.findViewById(R.id.textViewGreenUnit);
        mTextGreenTotal = view.findViewById(R.id.textViewGreenTotal);

        mTextBlueLow = view.findViewById(R.id.textViewBlueLow);
        mTextBlueHigh = view.findViewById(R.id.textViewBlueHigh);
        mTextBlueUnit = view.findViewById(R.id.textViewBlueUnit);
        mTextBlueTotal = view.findViewById(R.id.textViewBlueTotal);

        mTextRedLow = view.findViewById(R.id.textViewRedLow);
        mTextRedHigh = view.findViewById(R.id.textViewRedHigh);
        mTextRedUnit = view.findViewById(R.id.textViewRedUnit);
        mTextRedTotal = view.findViewById(R.id.textViewRedTotal);

        Call<List<StavkaOcitavanja>> measureItems = RetrofitClient.getInstance().
                getApi().stavkeOcitavanja(racun.getIdOcitavanja().getIdOcitavanja());
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
        measureItems.enqueue(new Callback<List<StavkaOcitavanja>>() {
            @Override
            public void onResponse(Call<List<StavkaOcitavanja>> call, Response<List<StavkaOcitavanja>> response) {
                System.out.println("LALALA");
                List<StavkaOcitavanja> stavkeOcitavanja = response.body();
                if (stavkeOcitavanja != null) {
                    List<BigDecimal> highUnits = new ArrayList<>();
                    List<BigDecimal> lowUnits = new ArrayList<>();
                    List<BigDecimal> total = new ArrayList<>();
                    for(int i =0; i <= RED; i++) {
                        total.add(BigDecimal.ZERO);
                        highUnits.add(BigDecimal.ZERO);
                        lowUnits.add(BigDecimal.ZERO);
                    }
                    for (StavkaOcitavanja s : stavkeOcitavanja) {
                        Tarifa t = s.getIdTarife();
                        switch (t.getZona()) {
                            case G_ZONE:
                                if (t.getTip().equals(H_TARIFF)) {
                                    mTextGreenHigh.setText(s.getUtroseno() + "");
                                    highUnits.add(GREEN, t.getCena());
                                } else {
                                    mTextGreenLow.setText(s.getUtroseno() + "");
                                    lowUnits.add(GREEN, t.getCena());
                                }
                                total.set(GREEN, total.get(GREEN).add(t.getCena().multiply(s.getUtroseno())));
                                break;
                            case B_ZONE:
                                if (t.getTip().equals(H_TARIFF)) {
                                    mTextBlueHigh.setText(s.getUtroseno() + "");
                                    highUnits.add(BLUE, t.getCena());
                                } else {
                                    mTextBlueLow.setText(s.getUtroseno() + "");
                                    lowUnits.add(BLUE, t.getCena());
                                }
                                total.set(BLUE, total.get(BLUE).add(t.getCena().multiply(s.getUtroseno())));
                                break;
                            case R_ZONE:
                                if (t.getTip().equals(H_TARIFF)) {
                                    mTextRedHigh.setText(s.getUtroseno() + "");
                                    highUnits.add(RED, t.getCena());
                                } else {
                                    mTextRedLow.setText(s.getUtroseno() + "");
                                    lowUnits.add(RED, t.getCena());
                                }
                                total.set(RED, total.get(RED).add(t.getCena().multiply(s.getUtroseno())));
                                break;
                        }
                    }
                    mTextGreenUnit.setText(lowUnits.get(GREEN) + "/" + highUnits.get(GREEN));
                    mTextBlueUnit.setText(lowUnits.get(BLUE) + "/" + highUnits.get(BLUE));
                    mTextRedUnit.setText(lowUnits.get(RED) + "/" + highUnits.get(RED));

                    mTextGreenTotal.setText(total.get(GREEN) + "");
                    mTextBlueTotal.setText(total.get(BLUE) + "");
                    mTextRedTotal.setText(total.get(RED) + "");
                }
            }

            @Override
            public void onFailure(Call<List<StavkaOcitavanja>> call, Throwable t) {
                Toast.makeText(getContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });


    }
}
