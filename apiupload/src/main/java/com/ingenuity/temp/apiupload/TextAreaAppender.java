package com.ingenuity.temp.apiupload;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by scacoveanu on 4/29/2014.
 */
public class TextAreaAppender extends AppenderSkeleton {

    public static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";
    public static final String NEW_LINE = "\n";
    private JTextArea textArea;
    private DateFormat dateFormat;
    private boolean fullLog;

    public TextAreaAppender(JTextArea textArea) {
        this(textArea, false);
    }
    public TextAreaAppender(JTextArea textArea, boolean fullLog) {
        this.textArea = textArea;
        this.fullLog = fullLog;
        dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        Logger.getRootLogger().addAppender(this);
    }

    @Override
    protected void append(LoggingEvent loggingEvent) {
        StringBuilder builder = new StringBuilder();
        if (fullLog) {
            builder.append(dateFormat.format(new Date(loggingEvent.getTimeStamp()))).append(" ");
            builder.append(loggingEvent.getLevel()).append(" ");
            builder.append("[").append(loggingEvent.getThreadName()).append("] ");
            builder.append(loggingEvent.getLocationInformation().fullInfo).append(" - ");
        }
        builder.append(loggingEvent.getMessage()).append(NEW_LINE);
        textArea.append(builder.toString());
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
