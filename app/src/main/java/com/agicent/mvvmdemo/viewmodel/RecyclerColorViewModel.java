package com.agicent.mvvmdemo.viewmodel;

import android.content.Context;
import android.graphics.Color;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.agicent.mvvmdemo.Activity.ItemDetailActivity;
import com.agicent.mvvmdemo.model.ColorsbyId;

public class RecyclerColorViewModel extends BaseObservable {

    private String imageUrl;
    private ColorsbyId colorsbyId;
    private ItemDetailActivity context;


    @Bindable
    public String getImageUrl() {
        return colorsbyId.getItem_color();
    }

    @BindingAdapter({"imageUrl"})
    public static void loadBackground(ConstraintLayout layout,String imageUrl){
        layout.setBackgroundColor(Color.parseColor(imageUrl));
    }


    public RecyclerColorViewModel(ColorsbyId colorsbyId, Context context){
        this.colorsbyId=colorsbyId;
        this.context=(ItemDetailActivity)context;

    }
}
