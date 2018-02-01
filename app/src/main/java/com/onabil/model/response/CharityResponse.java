package com.onabil.model.response;

import com.google.gson.annotations.SerializedName;
import com.onabil.model.Charity;

import java.util.List;

/**
 * Created by NABIL on 29-01-2018.
 */

public class CharityResponse {
    @SerializedName("data")
    protected List<Charity> charityList;

    public CharityResponse() {
    }

    public List<Charity> getCharityList() {
        return charityList;
    }

    public void setCharityList(List<Charity> charityList) {
        this.charityList = charityList;
    }
}
