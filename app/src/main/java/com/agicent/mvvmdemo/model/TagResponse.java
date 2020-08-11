package com.agicent.mvvmdemo.model;

import java.util.ArrayList;

public class TagResponse {

    ArrayList<String> tags;

    public TagResponse(ArrayList<String> tags) {
        this.tags = tags;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
