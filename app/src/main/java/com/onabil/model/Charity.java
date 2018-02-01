package com.onabil.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by NABIL on 29-01-2018.
 */

public class Charity {
    private String id;
    private String name;
    @SerializedName("logo_url")
    private String logoUrl;

    public Charity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
