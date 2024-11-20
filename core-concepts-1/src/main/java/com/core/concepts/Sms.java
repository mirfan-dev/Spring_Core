package com.core.concepts;

public class Sms implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sms notification sent");
    }
}
