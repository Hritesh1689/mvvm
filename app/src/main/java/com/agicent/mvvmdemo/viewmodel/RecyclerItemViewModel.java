package com.agicent.mvvmdemo.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.agicent.mvvmdemo.Activity.ItemDetailActivity;
import com.agicent.mvvmdemo.Activity.MainActivity;
import com.agicent.mvvmdemo.model.CategoryResponse;
import com.agicent.mvvmdemo.model.ItemResponse;
import com.agicent.mvvmdemo.utils.AndroidUtils;
import com.bumptech.glide.Glide;

public class RecyclerItemViewModel extends BaseObservable {
    private ItemResponse itemResponse;
    private MainActivity context;


    @Bindable
    public String getDesignCode() {
        return itemResponse.getDesign_number();
    }

    @Bindable
    public String getItemname() {
        return itemResponse.getItem_name();
    }

    @Bindable
    public String getCategoryname() {
        return itemResponse.getCategory_name();
    }

    @Bindable
    public String getBrandname() {
        return itemResponse.getBrand_name();
    }

    @Bindable
    public String getMinprice() {
        return itemResponse.getMin_item_price();
    }

    @Bindable
    public String getMaxprice() {
        return "~"+itemResponse.getMax_item_price();
    }



    public RecyclerItemViewModel(ItemResponse itemResponse, Context context) {
        this.itemResponse = itemResponse;
        this.context=(MainActivity) context;
    }

    @Bindable
    public String getImageUrl() {
        return itemResponse.getItem_image();
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }

    public void onItemClick(Integer index) {

        AndroidUtils.SelectedItem=itemResponse.getItem_id();
        context.startActivity(new Intent(context, ItemDetailActivity.class));


    }

}
