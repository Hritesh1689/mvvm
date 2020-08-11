package com.agicent.mvvmdemo.model;

import java.util.ArrayList;

public class NotificationResponse {

    private ArrayList<NotificationContentResponse>  notifications;

    public ArrayList<NotificationContentResponse> getNotifications() {
        return notifications;
    }

    public void setNotifications(ArrayList<NotificationContentResponse> notifications) {
        this.notifications = notifications;
    }

    public NotificationResponse(ArrayList<NotificationContentResponse> notifications) {
        this.notifications = notifications;
    }
}
