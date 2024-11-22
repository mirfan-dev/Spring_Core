package com.core.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Sms implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Sms notification sent");
    }
}
