package com.mirjana.android.helloservice.activity;

public class ConsumerListItem {

    private String EDNumber;
    private String Address;

    public ConsumerListItem(String EDNumber, String Address) {
        this.EDNumber = EDNumber;
        this.Address = Address;
    }

    public String getEDNumber() {
        return EDNumber;
    }

    public void setEDNumber(String EDNumber) {
        this.EDNumber = EDNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
