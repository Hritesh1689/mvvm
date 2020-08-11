package com.agicent.mvvmdemo.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.agicent.mvvmdemo.Activity.ItemDetailActivity;
import com.agicent.mvvmdemo.model.SizegroupResponse;

public class RecyclerSizegroupViewModel extends BaseObservable {

    private String size;
    private String priceBeforeDiscount,priceAfterDiscount;
    private SizegroupResponse sizegroupResponse;
    private ItemDetailActivity context;

    public RecyclerSizegroupViewModel(SizegroupResponse sizegroupResponse, Context context) {
        this.sizegroupResponse=sizegroupResponse;
        this.context=(ItemDetailActivity) context;

    }

    @Bindable
    public String getPriceBeforeDiscount() {
        return sizegroupResponse.getItem_price();
    }

    @Bindable
    public String getPriceAfterDiscount() {
        return sizegroupResponse.getItem_price_after_discount();
    }

    @Bindable
    public String getSize() {
        return sizegroupResponse.getSize_group();
    }
}
