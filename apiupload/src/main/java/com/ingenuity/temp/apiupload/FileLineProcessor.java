package com.ingenuity.temp.apiupload;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by scacoveanu on 9/10/2014.
 */
public abstract class FileLineProcessor {

    private static final Logger log = Logger.getLogger(DatasetReader.class);

    public void process(String path) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));

            String line = reader.readLine();
            while(line != null) {
                processLine(line);
                line = reader.readLine();
            }

            reader.close();
        } catch (FileNotFoundException e) {
            log.error(e, e);
        } catch (IOException e) {
            log.error(e, e);
        }
    }

    public abstract void processLine(String line);
}
