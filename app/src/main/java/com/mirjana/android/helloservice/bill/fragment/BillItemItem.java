package com.mirjana.android.helloservice.bill.fragment;

import com.mirjana.android.helloservice.bean.StavkaRacuna;

public class BillItemItem {

    private StavkaRacuna mStavkaRacuna;
    private int mColor;
    private String mSerialNumber;

    public BillItemItem(StavkaRacuna stavkaRacuna, int color, String serialNumber) {
        mStavkaRacuna = stavkaRacuna;
        mColor = color;
        mSerialNumber = serialNumber;
    }

    public StavkaRacuna getStavkaRacuna() {
        return mStavkaRacuna;
    }

    public void setStavkaRacuna(StavkaRacuna stavkaRacuna) {
        mStavkaRacuna = stavkaRacuna;
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
    }

    public String getSerialNumber() {
        return mSerialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        mSerialNumber = serialNumber;
    }
}
