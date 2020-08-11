package com.agicent.mvvmdemo.model;

import java.util.ArrayList;

public class CartItemSizeGroupResponse {

    private String cart_id;
    private String size_group;
    private String item_price;
    private String item_price_after_discount;
    private String quantity_in_box;
    private String total_quantity;
    private String sub_total;
    private ArrayList<ColorQuantityResponse> color_quantity;

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getSize_group() {
        return size_group;
    }

    public void setSize_group(String size_group) {
        this.size_group = size_group;
    }

    public String getItem_price() {
        return item_price;
    }

    public void setItem_price(String item_price) {
        this.item_price = item_price;
    }

    public String getItem_price_after_discount() {
        return item_price_after_discount;
    }

    public void setItem_price_after_discount(String item_price_after_discount) {
        this.item_price_after_discount = item_price_after_discount;
    }

    public String getQuantity_in_box() {
        return quantity_in_box;
    }

    public void setQuantity_in_box(String quantity_in_box) {
        this.quantity_in_box = quantity_in_box;
    }

    public String getTotal_quantity() {
        return total_quantity;
    }

    public void setTotal_quantity(String total_quantity) {
        this.total_quantity = total_quantity;
    }

    public String getSub_total() {
        return sub_total;
    }

    public void setSub_total(String sub_total) {
        this.sub_total = sub_total;
    }

    public ArrayList<ColorQuantityResponse> getColor_quantity() {
        return color_quantity;
    }

    public void setColor_quantity(ArrayList<ColorQuantityResponse> color_quantity) {
        this.color_quantity = color_quantity;
    }

    public CartItemSizeGroupResponse(String cart_id, String size_group, String item_price, String item_price_after_discount,
                                     String quantity_in_box, String total_quantity, String sub_total,
                                     ArrayList<ColorQuantityResponse> color_quantity) {
        this.cart_id = cart_id;
        this.size_group = size_group;
        this.item_price = item_price;
        this.item_price_after_discount = item_price_after_discount;
        this.quantity_in_box = quantity_in_box;
        this.total_quantity = total_quantity;
        this.sub_total = sub_total;
        this.color_quantity = color_quantity;
    }
}
