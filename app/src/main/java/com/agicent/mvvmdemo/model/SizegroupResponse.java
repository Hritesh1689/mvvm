package com.agicent.mvvmdemo.model;

public class SizegroupResponse {

    private String size_group;
    private String item_price;
    private String item_price_after_discount;
    private String is_active;
    private String quantity_in_box;

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

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    public String getQuantity_in_box() {
        return quantity_in_box;
    }

    public void setQuantity_in_box(String quantity_in_box) {
        this.quantity_in_box = quantity_in_box;
    }

    public SizegroupResponse(String size_group, String item_price,
                             String item_price_after_discount, String is_active, String quantity_in_box) {
        this.size_group = size_group;
        this.item_price = item_price;
        this.item_price_after_discount = item_price_after_discount;
        this.is_active = is_active;
        this.quantity_in_box = quantity_in_box;
    }
}
