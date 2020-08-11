package com.agicent.mvvmdemo.model;

public class ColorsbyId {

    private String item_color;
    private String color_name;

    public String getItem_color() {
        return item_color;
    }

    public void setItem_color(String item_color) {
        this.item_color = item_color;
    }

    public String getColor_name() {
        return color_name;
    }

    public void setColor_name(String color_name) {
        this.color_name = color_name;
    }

    public ColorsbyId() {
    }

    public ColorsbyId(String item_color, String color_name) {
        this.item_color = item_color;
        this.color_name = color_name;
    }
}
