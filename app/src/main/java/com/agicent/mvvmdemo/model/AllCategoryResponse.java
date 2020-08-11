package com.agicent.mvvmdemo.model;

import java.util.ArrayList;

public class AllCategoryResponse {

    private ArrayList<CategoryResponse> categories;

    public ArrayList<CategoryResponse> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<CategoryResponse> categories) {
        this.categories = categories;
    }

    public AllCategoryResponse(ArrayList<CategoryResponse> categories) {
        this.categories = categories;
    }
}
