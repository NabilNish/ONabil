package com.onabil.viewmodel;

import android.content.Context;
import android.databinding.ObservableBoolean;
import android.support.v7.app.AlertDialog;

import com.onabil.CharityAdapter;
import com.onabil.R;
import com.onabil.api.ApiClient;
import com.onabil.api.ApiInterface;
import com.onabil.helper.DialogHelper;
import com.onabil.model.Charity;
import com.onabil.model.response.CharityResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by NABIL on 29-01-2018.
 */

public class CharityActivityViewModel extends Observable {

    public static ObservableBoolean isCharityLoading = new ObservableBoolean(true);
    private List<Charity> charityList;

    private Context context;
    private CharityAdapter adapter;

    public CharityActivityViewModel(Context context, CharityAdapter adapter) {
        this.context = context;
        this.adapter = adapter;
        this.charityList = new ArrayList<>();
    }

    public void start() {
        ApiInterface apiInterface =
                ApiClient.getClientApp().create(ApiInterface.class);

        Call<CharityResponse> charityResponseCall = apiInterface.getCharity();
        charityResponseCall.enqueue(new Callback<CharityResponse>() {
            @Override
            public void onResponse(Call<CharityResponse> call, Response<CharityResponse> response) {
                if (response.isSuccessful()) {
                    onSuccess(response.body());
                } else
                    onError(response.message());
            }

            @Override
            public void onFailure(Call<CharityResponse> call, Throwable t) {
                onError(t.toString());
            }
        });
    }

    private void onError(String error) {
        isCharityLoading.set(false);
        DialogHelper.show(context, context.getString(R.string.sorry));
    }

    private void onSuccess(CharityResponse charityResponse) {
        isCharityLoading.set(false);
        adapter.setCharity(charityResponse.getCharityList());

    }
}

