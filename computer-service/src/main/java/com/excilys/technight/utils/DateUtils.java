package com.excilys.technight.utils;

import java.time.format.DateTimeFormatter;

/**
 * Created by pgm on 09/01/17.
 */
public class DateUtils {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public static DateTimeFormatter getDateFormatter() {
        return formatter;
    }
}

