package com.agicent.mvvmdemo.model;

public class CategoryResponse {

     private String category_id;
    private String  category_name;
    private String  category_pic;


    public String getCategory_id() {
        return category_id;
    }

    public CategoryResponse() {
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public CategoryResponse(String category_id, String category_name, String category_pic) {
        this.category_id = category_id;
        this.category_name = category_name;
        this.category_pic = category_pic;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_pic() {
        return category_pic;
    }

    public void setCategory_pic(String category_pic) {
        this.category_pic = category_pic;
    }


}
