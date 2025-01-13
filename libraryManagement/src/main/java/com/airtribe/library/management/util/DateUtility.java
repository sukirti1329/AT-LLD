package com.airtribe.library.management.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtility {

    public static String convertCurrentDateToString(){
        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");  // Customize the format as needed
        return currentDate.format(formatter);

    }
}
