package org.chronicweirdo.dump;

import org.chronicweirdo.dump.service.FileNameParser;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by scacoveanu on 12/30/2014.
 */
public class Util {

    public static String getServerPath(File file) {
        return "/" + file.getName();
    }

    public static Map map(Object ... data) {
        Map result = new HashMap<>();
        for (int i = 0; i < data.length; i+=2) {
            if (data.length > i+1) {
                result.put(data[i], data[i+1]);
            } else {
                result.put(data[i], null);
            }
        }
        return result;
    }

    public static String getString(Calendar calendar) {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        StringBuilder builder = new StringBuilder();
        builder.append(Integer.toString(year));
        if (month < 10) {
            builder.append("0");
        }
        builder.append(Integer.toString(month));
        if (day < 10) {
            builder.append("0");
        }
        builder.append(Integer.toString(day));
        if (hour < 10) {
            builder.append("0");
        }
        builder.append(Integer.toString(hour));
        if (minute < 10) {
            builder.append("0");
        }
        builder.append(Integer.toString(minute));
        return builder.toString();
    }

    public static Date getDate(String date) {
        if (date.length() != 12) return null;
        return getDate(date.substring(0, 4), date.substring(4, 6), date.substring(6, 8), date.substring(8, 10), date.substring(10));
    }
    public static Date getDate(String year, String month, String day, String hour, String minute) {
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.set(Calendar.YEAR, Integer.parseInt(year));
        } catch (NumberFormatException e) {
            // nothing
        }
        try {
            calendar.set(Calendar.MONTH, Integer.parseInt(month) - 1);
        } catch (NumberFormatException e) {
            // nothing
        }
        try {
            calendar.set(Calendar.DAY_OF_MONTH, Integer.parseInt(day));
        } catch (NumberFormatException e) {
            // nothing
        }
        try {
            calendar.set(Calendar.HOUR_OF_DAY, Integer.parseInt(hour));
        } catch (NumberFormatException e) {
            // nothing
        }
        try {
            calendar.set(Calendar.MINUTE, Integer.parseInt(minute));
        } catch (NumberFormatException e) {
            // nothing
        }
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        return calendar.getTime();
    }
}
