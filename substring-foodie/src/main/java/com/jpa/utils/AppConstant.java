package com.jpa.utils;

public class AppConstant {

    public static final String ROLE_ADMIN="ADMIN";
    public static final String ROLE_GUEST="GUEST";

    public static String getAdminRole(){
        return "ROLE_" +ROLE_ADMIN;
    }

    public static String getGuestRole(){
        return "ROLE_" +ROLE_GUEST;
    }
}
