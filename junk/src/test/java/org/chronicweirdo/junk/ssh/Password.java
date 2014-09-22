package org.chronicweirdo.junk.ssh;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by scacoveanu on 9/22/2014.
 */
public class Password {

    private static final String PATH = System.getProperty("user.home") + "\\sshpass";

    public static String get() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(PATH)));
            String password = reader.readLine();
            reader.close();
            return password;
        } catch (Exception e) {
            System.out.println(e);
        }
        return "";
    }
}
