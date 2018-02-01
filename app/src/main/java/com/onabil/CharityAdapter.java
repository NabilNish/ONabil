package com.onabil;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.onabil.databinding.CharityAdapterBinding;
import com.onabil.model.Charity;
import com.onabil.viewmodel.CharityAdapterViewModel;

import java.util.Collections;
import java.util.List;

/**
 * Created by NABIL on 29-01-2018.
 */

public class CharityAdapter extends RecyclerView.Adapter<CharityAdapter.ViewHolder> {

    private Context context;
    private List<Charity> charityList;
    private CharityAdapterBinding charityAdapterBinding;

    public CharityAdapter(Context context) {
        this.context = context;
        this.charityList = Collections.emptyList();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        charityAdapterBinding =
                DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.charity_adapter,
                        parent, false);
        return new ViewHolder(charityAdapterBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(charityList.get(position));
    }

    @Override
    public int getItemCount() {
        return charityList.size();
    }

    public void setCharity(List<Charity> charityList) {
        this.charityList = charityList;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        CharityAdapterBinding mItemBinding;

        public ViewHolder(CharityAdapterBinding itemBinding) {
            super(itemBinding.charityItem);
            this.mItemBinding = itemBinding;
        }

        void bind(Charity charity) {
            if (mItemBinding.getCharityAdapterViewModel() == null) {
                mItemBinding.setCharityAdapterViewModel(
                        new CharityAdapterViewModel(charity, itemView.getContext()));
            } else {
                mItemBinding.getCharityAdapterViewModel().setCharity(charity);
            }
        }
    }
}
