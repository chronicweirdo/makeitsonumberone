package com.ingenuity.temp.apiupload;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by scacoveanu on 4/18/2014.
 */
public class DatasetReader {

    public static List<List<String>> getTable(String path) {
        List<List<String>> data = new ArrayList<List<String>>();
        try {
            BufferedReader r = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));



            String line = r.readLine();
            while (line != null) {
                String[] tokens = line.split("\t");
                data.add(Arrays.asList(tokens));
                line = r.readLine();
            }

            r.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
