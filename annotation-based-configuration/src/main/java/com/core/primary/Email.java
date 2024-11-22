package com.core.primary;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class Email implements Notification{
    @Override
    public void notifyUser() {
        System.out.println("Email notification sent");
    }
}
