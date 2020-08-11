package com.agicent.mvvmdemo.model;

import java.util.ArrayList;

public class ItemDetailsbyIdResponse {

    private String item_id;
    private String design_number;
    private String item_name;
    private String category_name;
    private String fabric;
    private String fit;
    private String brand_name;
    private String short_description;
    private String full_description;
    private String gst_percentage;
    private String min_item_price;
    private String active_discount_in_percent;
    private String min_item_price_after_discount;
    private ArrayList<ItemPicResponseById> item_images;
    private ArrayList<ColorsbyId> item_colors;
    private ArrayList<SizegroupResponse> item_size_groups;
    private ArrayList<CartItemSizeGroupResponse> cart_items_size_group_color_quatity;

    public ItemDetailsbyIdResponse(String item_id, String design_number, String item_name,
                                   String category_name, String fabric, String fit, String brand_name,
                                   String short_description, String full_description, String gst_percentage,
                                   String min_item_price, String active_discount_in_percent, String min_item_price_after_discount,
                                   ArrayList<ItemPicResponseById> item_images, ArrayList<ColorsbyId> item_colors,
                                   ArrayList<SizegroupResponse> item_size_groups, ArrayList<CartItemSizeGroupResponse> cart_items_size_group_color_quatity) {
        this.item_id = item_id;
        this.design_number = design_number;
        this.item_name = item_name;
        this.category_name = category_name;
        this.fabric = fabric;
        this.fit = fit;
        this.brand_name = brand_name;
        this.short_description = short_description;
        this.full_description = full_description;
        this.gst_percentage = gst_percentage;
        this.min_item_price = min_item_price;
        this.active_discount_in_percent = active_discount_in_percent;
        this.min_item_price_after_discount = min_item_price_after_discount;
        this.item_images = item_images;
        this.item_colors = item_colors;
        this.item_size_groups = item_size_groups;
        this.cart_items_size_group_color_quatity = cart_items_size_group_color_quatity;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getDesign_number() {
        return design_number;
    }

    public void setDesign_number(String design_number) {
        this.design_number = design_number;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    public String getGst_percentage() {
        return gst_percentage;
    }

    public void setGst_percentage(String gst_percentage) {
        this.gst_percentage = gst_percentage;
    }

    public String getMin_item_price() {
        return min_item_price;
    }

    public void setMin_item_price(String min_item_price) {
        this.min_item_price = min_item_price;
    }

    public String getActive_discount_in_percent() {
        return active_discount_in_percent;
    }

    public void setActive_discount_in_percent(String active_discount_in_percent) {
        this.active_discount_in_percent = active_discount_in_percent;
    }

    public String getMin_item_price_after_discount() {
        return min_item_price_after_discount;
    }

    public void setMin_item_price_after_discount(String min_item_price_after_discount) {
        this.min_item_price_after_discount = min_item_price_after_discount;
    }

    public ArrayList<ItemPicResponseById> getItem_images() {
        return item_images;
    }

    public void setItem_images(ArrayList<ItemPicResponseById> item_images) {
        this.item_images = item_images;
    }

    public ArrayList<ColorsbyId> getItem_colors() {
        return item_colors;
    }

    public void setItem_colors(ArrayList<ColorsbyId> item_colors) {
        this.item_colors = item_colors;
    }

    public ArrayList<SizegroupResponse> getItem_size_groups() {
        return item_size_groups;
    }

    public void setItem_size_groups(ArrayList<SizegroupResponse> item_size_groups) {
        this.item_size_groups = item_size_groups;
    }

    public ArrayList<CartItemSizeGroupResponse> getCart_items_size_group_color_quatity() {
        return cart_items_size_group_color_quatity;
    }

    public void setCart_items_size_group_color_quatity(ArrayList<CartItemSizeGroupResponse> cart_items_size_group_color_quatity) {
        this.cart_items_size_group_color_quatity = cart_items_size_group_color_quatity;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

}
