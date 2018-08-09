package com.mirjana.android.helloservice.bill;

import com.mirjana.android.helloservice.bean.Racun;

public class BillListItem {

    private Racun racun;
    private int color;

    public BillListItem(Racun racun, int color) {
        this.racun = racun;
        this.color = color;
    }

    public Racun getRacun() {
        return racun;
    }

    public void setRacun(Racun racun) {
        this.racun = racun;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
