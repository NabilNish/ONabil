package com.onabil;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.onabil.databinding.DonationActivityBinding;
import com.onabil.viewmodel.DonationActivityViewModel;

public class DonationActivity extends AppCompatActivity {
    DonationActivityBinding binding;
    DonationActivityViewModel donationActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.donation_activity);
        donationActivityViewModel = new DonationActivityViewModel(this);
        binding.setDonationViewModel(donationActivityViewModel);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}
