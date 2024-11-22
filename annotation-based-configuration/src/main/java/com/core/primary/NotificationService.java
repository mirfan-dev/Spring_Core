package com.core.primary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("service")
public class NotificationService {

    @Autowired
    Notification notification;

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public Notification getNotification() {
        return notification;
    }

    public void notification(){
        notification.notifyUser();
    }
}
