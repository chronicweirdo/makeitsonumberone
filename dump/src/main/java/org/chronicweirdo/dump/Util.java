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
