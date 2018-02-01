package com.onabil.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.view.View;
import android.widget.Toast;

import com.onabil.R;
import com.onabil.SuccessActivity;
import com.onabil.api.ApiClient;
import com.onabil.api.ApiInterface;
import com.onabil.helper.DialogHelper;
import com.onabil.helper.UtilLog;
import com.onabil.model.response.DonationResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by NABIL on 31-01-2018.
 */

public class DonationActivityViewModel {
    private ArrayList<String> listOfPattern = new ArrayList<String>();
    public ObservableField<String> cardNo = new ObservableField<>();
    public ObservableField<String> amt = new ObservableField<>();
    public ObservableBoolean isDonationLoading = new ObservableBoolean(false);

    Context context;

    public DonationActivityViewModel(Context context) {
        this.context = context;
        //credit card validation
        String ptVisa = "^4[0-9]{6,}$";
        listOfPattern.add(ptVisa);
        String ptMasterCard = "^5[1-5][0-9]{5,}$";
        listOfPattern.add(ptMasterCard);
        String ptAmeExp = "^3[47][0-9]{5,}$";
        listOfPattern.add(ptAmeExp);
        String ptDinClb = "^3(?:0[0-5]|[68][0-9])[0-9]{4,}$";
        listOfPattern.add(ptDinClb);
        String ptDiscover = "^6(?:011|5[0-9]{2})[0-9]{3,}$";
        listOfPattern.add(ptDiscover);
        String ptJcb = "^(?:2131|1800|35[0-9]{3})[0-9]{3,}$";
        listOfPattern.add(ptJcb);
    }

    public void onSubmit(View view) {
        if (cardNo.get() != null && amt.get() != null) {
            isDonationLoading.set(true);

            //card validation is not checked as of now
            for (String card : listOfPattern) {
                if (cardNo.get().matches(card)) {
                    UtilLog.d("card:", "is valid");
                }
            }

            ApiInterface apiInterface =
                    ApiClient.getClientApp().create(ApiInterface.class);


            //Here the json data is add to a hash map with key data
            Map<String, String> params = new HashMap<String, String>();
            params.put("name", "John Doe");
            params.put("token", "tokn_test_deadbeef");
            params.put("amount", amt.get());

            Call<DonationResponse> productResponseCall = apiInterface.postDonationDetails(params);
            productResponseCall.enqueue(new Callback<DonationResponse>() {
                @Override
                public void onResponse(Call<DonationResponse> call, Response<DonationResponse> response) {

                    if (response.isSuccessful()) {
                        onSuccess(response.body());
                    } else
                        onError(response.message());
                }

                @Override
                public void onFailure(Call<DonationResponse> call, Throwable t) {
                    onError(t.toString());
                }
            });

        } else {
            Toast.makeText(context, "Please fill all fields!", Toast.LENGTH_SHORT).show();
        }
    }

    private void onError(String error) {
        isDonationLoading.set(false);
        DialogHelper.show(context, context.getString(R.string.sorry));
    }

    private void onSuccess(DonationResponse donationResponse) {
        isDonationLoading.set(false);
        Toast.makeText(context, "Val: " + donationResponse.isSuccess(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(context, SuccessActivity.class);
        context.startActivity(intent);
        ((Activity) context).finish();
    }
}
