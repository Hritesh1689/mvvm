package com.agicent.mvvmdemo.model;

public class CollectionResponse {

    private String collection_id;
    private String collection_name;
    private String collection_pic;

    public CollectionResponse(String collection_id, String collection_name, String collection_pic, String is_active) {
        this.collection_id = collection_id;
        this.collection_name = collection_name;
        this.collection_pic = collection_pic;
        this.is_active = is_active;
    }

    public String getCollection_id() {
        return collection_id;
    }

    public void setCollection_id(String collection_id) {
        this.collection_id = collection_id;
    }

    public String getCollection_name() {
        return collection_name;
    }

    public void setCollection_name(String collection_name) {
        this.collection_name = collection_name;
    }

    public String getCollection_pic() {
        return collection_pic;
    }

    public void setCollection_pic(String collection_pic) {
        this.collection_pic = collection_pic;
    }

    public String getIs_active() {
        return is_active;
    }

    public void setIs_active(String is_active) {
        this.is_active = is_active;
    }

    private String is_active;
}
