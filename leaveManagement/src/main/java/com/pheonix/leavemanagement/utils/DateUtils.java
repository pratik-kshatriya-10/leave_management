package com.pheonix.leavemanagement.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateUtils {
    private static final String DATE_FORMATTER_YYYY_MM_HH = "yyyy-MM-dd";
    private DateUtils(){}

    public static long now(){
        return Instant.now().toEpochMilli();
    }

    public static long convertDateIntoLongStartOfDay(String date) {
        LocalDate fromDate = LocalDate.parse(date);
        return fromDate.atStartOfDay(ZoneId.systemDefault())
                .toInstant().toEpochMilli();
    }

    public static long convertDateIntoLongEndOfDay(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return localDate
                .atTime(23, 59, 59, 999_000_000)
                .atZone(ZoneId.systemDefault())
                .toInstant()
                .toEpochMilli();
    }


    public static String convertDateInString(long date){
        return Instant.ofEpochMilli(date)
                .atZone(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern(DATE_FORMATTER_YYYY_MM_HH));
    }

}
