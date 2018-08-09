package com.mirjana.android.helloservice.main;

import android.content.*;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;

import com.mirjana.android.helloservice.*;
import com.mirjana.android.helloservice.consumer.ConsumersActivity;
import com.mirjana.android.helloservice.bean.*;

public class InfoActivity extends AppCompatActivity {

    public static final String kupacGetConsumers = "POTROSACI_ZA_KUPCA";

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

    private ImageButton mConsumersButton;
    private Kupac kupac;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        kupac = (Kupac)getIntent().getSerializableExtra(MainActivity.kupacInfoKey);
        initInfoActivity(kupac);
        mConsumersButton = findViewById(R.id.buttonViewConsumers);
        mConsumersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoActivity.this, ConsumersActivity.class);
                intent.putExtra(kupacGetConsumers, kupac);
                startActivity(intent);
            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu_item_buyer:
                return true;
            case R.id.menu_item_consumers:
                intent = new Intent(InfoActivity.this, ConsumersActivity.class);
                intent.putExtra(kupacGetConsumers, kupac);
                startActivity(intent);
                return true;
            case R.id.menu_item_logout:
                intent = new Intent(InfoActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if(Build.VERSION.SDK_INT > 11) {
            invalidateOptionsMenu();
            menu.findItem(R.id.menu_item_bills).setVisible(false);
            menu.findItem(R.id.menu_item_buyer).setVisible(false);
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
