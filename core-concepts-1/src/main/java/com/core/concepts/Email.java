package com.core.concepts;

public class Email implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Email notification sent");
    }
}
