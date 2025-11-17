package com.pheonix.leavemanagement.utils;

import java.util.Date;

public class DateUtils {
    private DateUtils(){}

    public static long now(){
        return new Date().getTime();
    }
}
