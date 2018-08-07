package com.mirjana.android.helloservice.activity.consumer;

import com.mirjana.android.helloservice.bean.*;

public class ConsumerListItem {

    private Potrosac potrosac;
    private boolean first = true;

    public ConsumerListItem(Potrosac potrosac) {
        this.potrosac = potrosac;
    }

    public Potrosac getPotrosac() {
        return potrosac;
    }

    public void setPotrosac(Potrosac potrosac) {
        this.potrosac = potrosac;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }
}

