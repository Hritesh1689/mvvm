package com.agicent.mvvmdemo.model;

public class ItemResponse {

     private  String item_id;
    private  String    design_number;
    private  String   item_name;
    private  String    item_image;
    private  String    category_name;
    private  String    brand_name;

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

    public String getItem_image() {
        return item_image;
    }

    public void setItem_image(String item_image) {
        this.item_image = item_image;
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

    public String getMin_item_price() {
        return min_item_price;
    }

    public void setMin_item_price(String min_item_price) {
        this.min_item_price = min_item_price;
    }

    public String getMax_item_price() {
        return max_item_price;
    }

    public void setMax_item_price(String max_item_price) {
        this.max_item_price = max_item_price;
    }

    private  String    min_item_price;

    public ItemResponse() {
    }

    public ItemResponse(String item_id, String design_number, String item_name, String item_image, String category_name, String brand_name, String min_item_price, String max_item_price) {
        this.item_id = item_id;
        this.design_number = design_number;
        this.item_name = item_name;
        this.item_image = item_image;
        this.category_name = category_name;
        this.brand_name = brand_name;
        this.min_item_price = min_item_price;
        this.max_item_price = max_item_price;
    }

    private  String   max_item_price;
}
