package com.agicent.mvvmdemo.model;

public class NotificationContentResponse {

    private String title;
    private String  detail;
    private String   type;
    private String    item_id;
    private String    picture;
    private String   sent_on;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getItem_id() {
        return item_id;
    }

    public void setItem_id(String item_id) {
        this.item_id = item_id;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSent_on() {
        return sent_on;
    }

    public void setSent_on(String sent_on) {
        this.sent_on = sent_on;
    }

    public NotificationContentResponse(String title, String detail, String type, String item_id, String picture, String sent_on) {
        this.title = title;
        this.detail = detail;
        this.type = type;
        this.item_id = item_id;
        this.picture = picture;
        this.sent_on = sent_on;
    }
}
