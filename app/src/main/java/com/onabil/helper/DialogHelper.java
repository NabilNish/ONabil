package com.onabil.helper;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.onabil.R;

/**
 * Created by NABIL on 01-02-2018.
 */

public class DialogHelper {
    public static void show(final Context context, String msg) {
        AlertDialog alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle(context.getString(R.string.app_name));
        alertDialog.setMessage(msg);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        ((Activity) context).finish();
                    }
                });
        alertDialog.show();
    }
}
