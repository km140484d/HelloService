package com.mirjana.android.helloservice.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.*;

import com.mirjana.android.helloservice.*;
import com.mirjana.android.helloservice.bean.*;

public class InfoActivity extends AppCompatActivity {

    private TextView nameText;
    private TextView fullNameText;
    private TextView socialText;
    private TextView wireTransferText;
    private TextView streetNumberText;
    private TextView countyCityText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Kupac kupac = (Kupac)getIntent().getSerializableExtra(MainActivity.kupacKey);
        initInfoActivity(kupac);
    }

    public void initInfoActivity(Kupac kupac){
        if (kupac.getTip().equals("F")) {
            setContentView(R.layout.activity_person_info);
            nameText = findViewById(R.id.textViewPersonName);
            socialText = findViewById(R.id.textViewPersonSocialNumber);
            wireTransferText = findViewById(R.id.textViewPersonWireNumber);
            streetNumberText = findViewById(R.id.textViewPersonStreetNumber);
            countyCityText = findViewById(R.id.textViewPersonCity);

            socialText.setText(kupac.getJmbg());
        }
        else {
            setContentView(R.layout.activity_company_info);
            nameText = findViewById(R.id.textViewEnterpriseName);
            fullNameText = findViewById(R.id.textViewEnterpriseFullName);
            socialText = findViewById(R.id.textViewEnterpriseSocialNumber);
            wireTransferText = findViewById(R.id.textViewEnterpriseWireNumber);
            streetNumberText = findViewById(R.id.textViewEnterpriseStreetNumber);
            countyCityText = findViewById(R.id.textViewEnterpriseCity);

            socialText.setText(kupac.getMaticniBroj());
            fullNameText.setText(kupac.getProsireniNaziv());
        }
        nameText.setText(kupac.getNaziv());
        wireTransferText.setText(kupac.getNaplatniBroj());
        streetNumberText.setText(kupac.getAdresa().getUlica() + " " + kupac.getAdresa().getBroj());
        countyCityText.setText(kupac.getAdresa().getOpstina() + ", " + kupac.getAdresa().getGrad());
    }
}
