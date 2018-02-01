package com.onabil.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by NABIL on 29-01-2018.
 */

public class ApiClient {

    private static final String BASE_URL = "https://virtserver.swaggerhub.com/chakritw/tamboon-api/1.0.0/";
    private static Retrofit retrofitApp = null;

    public static Retrofit getClientApp() {

        if (retrofitApp == null) {
            retrofitApp = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitApp;
    }

}
