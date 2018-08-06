package com.mirjana.android.helloservice.activity;

import com.mirjana.android.helloservice.bean.*;

public class ConsumerListItem {

    private Potrosac potrosac;
    private boolean expand = false;

    public ConsumerListItem(Potrosac potrosac) {
        this.potrosac = potrosac;
    }

    public Potrosac getPotrosac() {
        return potrosac;
    }

    public void setPotrosac(Potrosac potrosac) {
        this.potrosac = potrosac;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }
}

