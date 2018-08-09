package com.mirjana.android.helloservice.bill;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.*;
import android.widget.*;

import com.mirjana.android.helloservice.R;
import com.mirjana.android.helloservice.bill.fragment.*;
import com.mirjana.android.helloservice.bean.*;
import com.mirjana.android.helloservice.consumer.ConsumersActivity;
import com.mirjana.android.helloservice.main.InfoActivity;
import com.mirjana.android.helloservice.main.MainActivity;
import com.mirjana.android.helloservice.main.fragment.MainStatePagerAdapter;
import com.mirjana.android.helloservice.retrofit.RetrofitClient;

import java.net.ResponseCache;
import java.text.SimpleDateFormat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillActivity extends AppCompatActivity {

    private TextView mTextBillHeading;
    private TextView mTextBillPeriod;
    private TextView mTextBillPrice;

    private ImageButton mButtonAttachment;

    private ViewPager mPager;
    private MainStatePagerAdapter mAdapter;

    private Racun racun;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_info);

        racun = (Racun)getIntent().getSerializableExtra(BillListActivity.racunInfoKey);
        ObracunskiPeriod op = racun.getIdOp();

        mTextBillHeading = findViewById(R.id.textViewBillHeading);
            mTextBillHeading.setText(op.getMesec() + ", " + op.getGodina());
        mTextBillPeriod = findViewById(R.id.textViewBillHeadingDatePeriod);
            mTextBillPeriod.setText("(" + new SimpleDateFormat("MM/dd/yyyy").format(op.getDatumOd())
                    + "-" + new SimpleDateFormat("MM/dd/yyyy").format(op.getDatumDo()) + ")");
        mTextBillPrice = findViewById(R.id.textViewBillHeadingPrice);
            mTextBillPrice.setText(getString(R.string.dinars, racun.getUkupanIznos() + ""));

        mButtonAttachment = findViewById(R.id.imageButtonAttachment);
//        mButtonAttachment.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Call<Response<byte[]>> response = RetrofitClient.getInstance().getApi().racunPdf(racun.getIdRacuna());
//                response.enqueue(new Callback<Response<byte[]>>() {
//                    @Override
//                    public void onResponse(Call<Response<byte[]>> call, Response<Response<byte[]>> response) {
//                        Toast.makeText(getApplicationContext(), R.string.loading_pdf, Toast.LENGTH_LONG).show();
//                    }
//
//                    @Override
//                    public void onFailure(Call<Response<byte[]>> call, Throwable t) {
//                        Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
//                    }
//                });
//            }
//        });

        mPager = findViewById(R.id.viewPagerBillFragments);
        mAdapter = new MainStatePagerAdapter(getSupportFragmentManager());
        mAdapter.addFragment(new BillInfoFragment());
        mAdapter.addFragment(new BillItemFragment());
        mPager.setAdapter(mAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()) {
            case R.id.menu_item_buyer:
                intent = new Intent(BillActivity.this, InfoActivity.class);
                intent.putExtra(MainActivity.kupacInfoKey, racun.getIdPotrosaca().getKupac());
                startActivity(intent);
                finish();
                return true;
            case R.id.menu_item_consumers:
                intent = new Intent(BillActivity.this, ConsumersActivity.class);
                intent.putExtra(InfoActivity.kupacGetConsumers, racun.getIdPotrosaca().getKupac());
                startActivity(intent);
                finish();
                return true;
            case R.id.menu_item_bills:
                intent = new Intent(BillActivity.this, BillListActivity.class);
                intent.putExtra(ConsumersActivity.potrosacGetBills, racun.getIdPotrosaca());
                startActivity(intent);
                finish();
                return true;
            case R.id.menu_item_logout:
                intent = new Intent(BillActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
