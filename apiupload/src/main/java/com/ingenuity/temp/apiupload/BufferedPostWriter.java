package com.ingenuity.temp.apiupload;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by scacoveanu on 9/12/2014.
 */
public class BufferedPostWriter {

    private static final Logger log = Logger.getLogger(BufferedPostWriter.class);

    private long bufferSize = 1024 * 1024;

    private OutputStreamWriter writer;
    private StringBuilder buffer = new StringBuilder();

    public BufferedPostWriter(OutputStreamWriter writer) {
        this.writer = writer;
    }

    public void setBufferSize(long bufferSize) {
        this.bufferSize = bufferSize;
    }

    public void append(String data) throws IOException {
        buffer.append(data);
        if (buffer.length() > bufferSize) {
            flush();
        }
    }

    private void flushInternal() throws IOException {
        log.info("flushing buffer of size " + buffer.length() + " (" + (buffer.length() / (1024 * 1024)) + "MB)");
        writer.append(buffer.toString());
        writer.flush();
    }

    public void flush() {
        try {
            flushInternal();
        } catch (IOException e) {
            log.error(e, e);
        }
        buffer = new StringBuilder();
    }
}
