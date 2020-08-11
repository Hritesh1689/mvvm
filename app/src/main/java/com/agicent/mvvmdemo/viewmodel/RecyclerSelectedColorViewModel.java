package com.agicent.mvvmdemo.viewmodel;

import android.content.Context;
import android.graphics.Color;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.agicent.mvvmdemo.Activity.ItemDetailActivity;
import com.agicent.mvvmdemo.model.ColorQuantityResponse;

public class RecyclerSelectedColorViewModel extends BaseObservable {

    private String colorQuantity,imageUrl;
    private ColorQuantityResponse colorQuantityResponse;
    private ItemDetailActivity context;

    public RecyclerSelectedColorViewModel(ColorQuantityResponse colorQuantityResponse, Context context) {
        this.colorQuantityResponse=colorQuantityResponse;
        this.context=(ItemDetailActivity)context;

    }


    @Bindable
    public String getColorQuantity() {
        return colorQuantityResponse.getQuantity();
    }
    @Bindable
    public String getImageUrl() {
        return colorQuantityResponse.getItem_color();
    }

    @BindingAdapter({"imageUrl"})
    public static void paintBackground(ConstraintLayout layout,String imageUrl){
        layout.setBackgroundColor(Color.parseColor(imageUrl));
    }
}
