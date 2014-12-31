package org.chronicweirdo.dump;

import java.io.File;
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
}
