package com.onabil.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.onabil.DonationActivity;
import com.onabil.R;
import com.onabil.model.Charity;
import com.squareup.picasso.Picasso;

/**
 * Created by NABIL on 29-01-2018.
 */

public class CharityAdapterViewModel extends BaseObservable {

    Charity charity;
    Context context;

    public CharityAdapterViewModel(Charity charity, Context context) {
        this.charity = charity;
        this.context = context;
    }

    @Bindable
    public String getCharityTitle() {
        return charity.getName();
    }


    public String getImageUrl() {
        return charity.getLogoUrl();
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .fit()
                .placeholder(R.drawable.placeholder)
                .into(view);
    }

    public void onClickCharity(View view) {
        Intent intent = new Intent(context, DonationActivity.class);
        context.startActivity(intent);
    }

    public void setCharity(Charity charity) {
        this.charity = charity;
        notifyChange();
    }


}


