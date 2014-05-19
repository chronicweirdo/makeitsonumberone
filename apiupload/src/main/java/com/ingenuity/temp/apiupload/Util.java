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
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(text);
            fw.close();
        } catch (IOException e) {
            log.error(e, e);
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    log.error(e, e);
                }
            }
        }

    }
}
