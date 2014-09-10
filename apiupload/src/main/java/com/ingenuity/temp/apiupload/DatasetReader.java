package com.ingenuity.temp.apiupload;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by scacoveanu on 4/18/2014.
 */
public class DatasetReader {

    private static final Logger log = Logger.getLogger(DatasetReader.class);

    public static List<List<String>> getTable(String path) {
        log.info("reading file " + path);
        List<List<String>> data = new ArrayList<List<String>>();
        try {
            File file = new File(path);
            log.info("file size in bytes: " + file.length());
            log.info("file size in MB: " + (file.length() / 1000d / 1000d));
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));



            String line = reader.readLine();
            while (line != null) {
                data.add(tokenizeLine(line));
                line = reader.readLine();
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        log.info("read " + data.size() + " lines (including header)");
        return data;
    }

    public static List<String> tokenizeLine(String line) {
        return Arrays.asList(line.split("\t"));
    }

    public static List<String> getHeader(String path) {
        log.info("reading file header " + path);
        List<String> header = new ArrayList<String>();
        
        return header;
    }

}