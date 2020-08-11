package com.agicent.mvvmdemo.model;

import java.util.ArrayList;

public class AllItemResponse {

    private ArrayList<ItemResponse>  items;
    private boolean next_page;

    public ArrayList<ItemResponse> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemResponse> items) {
        this.items = items;
    }

    public boolean isNext_page() {
        return next_page;
    }

    public void setNext_page(boolean next_page) {
        this.next_page = next_page;
    }

    public AllItemResponse(ArrayList<ItemResponse> items, boolean next_page) {
        this.items = items;
        this.next_page = next_page;
    }
}
