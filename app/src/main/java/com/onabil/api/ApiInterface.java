package com.onabil.api;

import com.onabil.model.response.CharityResponse;
import com.onabil.model.response.DonationResponse;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by NABIL on 29-01-2018.
 */

public interface ApiInterface {

    @GET("charities")
    Call<CharityResponse> getCharity();

    @POST("donations")
    @FormUrlEncoded
    Call<DonationResponse> postDonationDetails(@FieldMap Map<String, String> params);

}
