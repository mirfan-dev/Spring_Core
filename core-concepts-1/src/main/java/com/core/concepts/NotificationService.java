package com.core.concepts;

public class NotificationService {

    Notification notification;

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }

    public void sendNotification(){
        notification.notifyUser();
    }
}
