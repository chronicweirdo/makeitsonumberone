package com.ingenuity.temp.apiupload;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpMethodBase;
import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

/**
 * Created by scacoveanu on 4/23/2014.
 */
public class Util {

    private static final Logger log = Logger.getLogger(Util.class);

    public static String getResponseBody(HttpMethodBase m) {
        InputStream stream = null;
        try {
            stream = m.getResponseBodyAsStream();
            for (Header header: m.getResponseHeaders()) {
                System.out.println(header.getName() + " : " + header.getValue());
            }
        } catch (IOException e) {
            log.error(e);
        }
        StringWriter writer = new StringWriter();
        try {
            IOUtils.copy(stream, writer);
        } catch (IOException e) {
            log.error(e);
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                log.error(e);
            }
        }
        return writer.toString();
    }

    public static void writeToFile(String text, String file) {
        if (text == null) return;
        log.info("writing to file: " + file);
        FileWriter fileWriter = openFileWriter(file, false);
        writeToFileWriter(text, fileWriter);
        closeFileWriter(fileWriter);
    }

    public static void appendToFile(String text, String file) {
        if (text == null) return;
        log.info("appending to file: " + file);
        FileWriter fileWriter = openFileWriter(file, true);
        appendToFileWriter(text, fileWriter);
        closeFileWriter(fileWriter);
    }

    private static void writeToFileWriter(String text, FileWriter fileWriter) {
        try {
            fileWriter.write(text);
        } catch (IOException e) {
            log.error(e, e);
        }
    }

    private static void appendToFileWriter(String text, FileWriter fileWriter) {
        try {
            fileWriter.append(text);
        } catch (IOException e) {
            log.error(e, e);
        }
    }

    private static FileWriter openFileWriter(String file, boolean append) {
        try {
            FileWriter fileWriter = new FileWriter(file, append);
            return fileWriter;
        } catch (IOException e) {
            log.error(e, e);
            return null;
        }
    }

    private static void closeFileWriter(FileWriter fileWriter) {
        try {
            fileWriter.close();
        } catch (IOException e) {
            log.error(e, e);
        }
    }


}
