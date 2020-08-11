package com.agicent.mvvmdemo.model;

public class ColorQuantityResponse {

    private String quantity;
    private String color_name;
    private String item_color;

    public ColorQuantityResponse(String quantity, String color_name, String item_color) {
        this.quantity = quantity;
        this.color_name = color_name;
        this.item_color = item_color;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public String getItem_color() {
        return item_color;
    }

    public void setItem_color(String item_color) {
        this.item_color = item_color;
    }
}
