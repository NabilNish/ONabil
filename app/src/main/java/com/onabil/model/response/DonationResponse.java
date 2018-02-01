package com.onabil.model.response;

/**
 * Created by NABIL on 31-01-2018.
 */

public class DonationResponse {
    private boolean success;
    private String error_code;
    private String error_message;

    public DonationResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getError_code() {
        return error_code;
    }

    public void setError_code(String error_code) {
        this.error_code = error_code;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
}
