package com.pheonix.leavemanagement.utils;


public class UUID {

    private UUID() {
    }

    public static String random(){
        String uuid = java.util.UUID.randomUUID().toString();
        return uuid.replace("-", "");
    }
}
