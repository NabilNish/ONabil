package com.onabil;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.onabil.databinding.CharityActivityBinding;
import com.onabil.viewmodel.CharityActivityViewModel;

public class CharityActivity extends AppCompatActivity {
    CharityActivityBinding binding;
    CharityActivityViewModel charityViewModel;
    CharityAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.charity_activity);
        adapter = new CharityAdapter(CharityActivity.this);
        charityViewModel = new CharityActivityViewModel(this, adapter);
        binding.setCharityViewModel(charityViewModel);

        charityViewModel.start();

        setupListView(binding.rvCharity);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private void setupListView(RecyclerView listView) {
        listView.setLayoutManager(new LinearLayoutManager(CharityActivity.this));
        listView.setAdapter(adapter);
    }

}
