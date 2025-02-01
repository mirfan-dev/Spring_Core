package com.jpa.utils;

public class AppConstant {

    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_GUEST = "GUEST";

    public static String getRoleAdmin() {
        return "ROLE_" + ROLE_ADMIN;
    }

    public static String getRoleGuest() {
        return "ROLE_" + ROLE_GUEST;
    }
}
