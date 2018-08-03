package com.mirjana.android.helloservice.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.*;

import com.mirjana.android.helloservice.*;
import com.mirjana.android.helloservice.bean.*;

public class InfoActivity extends AppCompatActivity {

    private TextView nameText;
    private TextView nameTextInfo;
    private TextView fullNameText;
    private TextView fullNameTextInfo;
    private TextView socialText;
    private TextView socialTextInfo;
    private TextView wireTransferText;
    private TextView streetNumberText;
    private TextView countyCityText;
    private ImageView imageInfo;
    private TextView infoText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Kupac kupac = (Kupac)getIntent().getSerializableExtra(MainActivity.kupacInfoKey);
        initInfoActivity(kupac);
    }

    public void initInfoActivity(Kupac kupac){
        setContentView(R.layout.activity_info);

        nameText = findViewById(R.id.textViewName);
        nameTextInfo = findViewById(R.id.textViewNameInfo);
        fullNameText = findViewById(R.id.textViewFullName);
        fullNameTextInfo = findViewById(R.id.textViewFullNameInfo);
        socialText = findViewById(R.id.textViewSocialNumber);
        socialTextInfo = findViewById(R.id.textViewSocialInfo);
        wireTransferText = findViewById(R.id.textViewWireNumber);
        streetNumberText = findViewById(R.id.textViewStreetNumber);
        countyCityText = findViewById(R.id.textViewCity);
        imageInfo = findViewById(R.id.imageViewInfo);
        infoText = findViewById(R.id.textViewInfo);

        nameText.setText(kupac.getNaziv());
        fullNameText.setText(kupac.getProsireniNaziv());
        socialText.setText(kupac.getMaticniBroj());
        wireTransferText.setText(kupac.getNaplatniBroj());
        streetNumberText.setText(getString(R.string.street_number,
                kupac.getAdresa().getUlica(), kupac.getAdresa().getBroj()));
        countyCityText.setText(getString(R.string.county_city,
                kupac.getAdresa().getOpstina(), kupac.getAdresa().getGrad()));
        if (kupac.getTip().equals("F")) {
            nameTextInfo.setText(R.string.person_name);
            socialText.setText(kupac.getJmbg());
            socialTextInfo.setText(R.string.social_security);
            fullNameText.setVisibility(View.GONE);
            fullNameTextInfo.setVisibility(View.GONE);
            imageInfo.setImageResource(R.drawable.user64);
            infoText.setText(R.string.person);
        }

    }
}
