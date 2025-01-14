package com.jpa.utils;

import java.util.UUID;

public class Helper {

    public static String generateRandomUserId(){
        return UUID.randomUUID().toString();
    }
}
