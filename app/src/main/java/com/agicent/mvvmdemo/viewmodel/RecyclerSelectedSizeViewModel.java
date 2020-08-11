package com.agicent.mvvmdemo.viewmodel;

import android.content.Context;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.agicent.mvvmdemo.Activity.ItemDetailActivity;
import com.agicent.mvvmdemo.Adapter.SelectedColorAdapter;
import com.agicent.mvvmdemo.model.CartItemSizeGroupResponse;
import com.agicent.mvvmdemo.model.ColorQuantityResponse;

import java.util.ArrayList;

public class RecyclerSelectedSizeViewModel extends BaseObservable {

    private String priceAfterDiscount,priceBeforeDiscount,sizegroup,totalQuantity,subtotal;
    private SelectedColorAdapter selectedColorAdapter;
    private CartItemSizeGroupResponse cartItemSizeGroupResponse;
private ItemDetailActivity context;

    public RecyclerSelectedSizeViewModel(CartItemSizeGroupResponse cartItemSizeGroupResponse, Context context) {
              this.cartItemSizeGroupResponse=cartItemSizeGroupResponse;
              this.context=(ItemDetailActivity)context;
              selectedColorAdapter=new SelectedColorAdapter();
    }

    @Bindable
    public ArrayList<ColorQuantityResponse> getColorQuantityList() {
        return cartItemSizeGroupResponse.getColor_quantity();
    }

    private ArrayList<ColorQuantityResponse> colorQuantityList;

    @Bindable
    public SelectedColorAdapter getSelectedColorAdapter() {
        return selectedColorAdapter;
    }

    @BindingAdapter({"selectedColorAdapter","colorQuantityList"})
    public static void bind(RecyclerView recyclerView, SelectedColorAdapter selectedColorAdapter, ArrayList<ColorQuantityResponse> colorQuantityList){
        recyclerView.setAdapter(selectedColorAdapter);
        selectedColorAdapter.update(colorQuantityList);
    }

    @Bindable
    public String getPriceAfterDiscount() {
        return cartItemSizeGroupResponse.getItem_price_after_discount();
    }
    @Bindable
    public String getPriceBeforeDiscount() {
        return cartItemSizeGroupResponse.getItem_price();
    }
    @Bindable
    public String getSizegroup() {
        return cartItemSizeGroupResponse.getSize_group();
    }
    @Bindable
    public String getTotalQuantity() {
        return cartItemSizeGroupResponse.getTotal_quantity();
    }
    @Bindable
    public String getSubtotal() {
        return cartItemSizeGroupResponse.getSub_total();
    }
}
