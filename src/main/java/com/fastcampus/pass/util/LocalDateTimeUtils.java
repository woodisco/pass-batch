package com.fastcampus.pass.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtils {

    public static final DateTimeFormatter YYYY_MM_DD_HH_MM = DateTimeFormatter.ofPattern("yyyy-mm-dd HH:mm");
    public static final DateTimeFormatter YYYY_MM_DD = DateTimeFormatter.ofPattern("yyyymmdd");

    public static String format(final LocalDateTime localDateTime) {
        return localDateTime.format(YYYY_MM_DD_HH_MM);
    }

    public static String format(final LocalDateTime localDateTime, DateTimeFormatter formatter) {
        return localDateTime.format(formatter);
    }
}