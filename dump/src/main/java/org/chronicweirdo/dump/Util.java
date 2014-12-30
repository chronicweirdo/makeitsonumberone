package org.chronicweirdo.dump;

import java.io.File;

/**
 * Created by scacoveanu on 12/30/2014.
 */
public class Util {

    public static String getServerPath(File file) {
        return "/" + file.getPath();
    }
}
