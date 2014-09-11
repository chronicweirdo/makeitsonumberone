package com.ingenuity.temp.apiupload;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by scacoveanu on 4/29/2014.
 */
public class TextAreaAppender extends AppenderSkeleton {

    private static final String DATE_FORMAT_PATTERN = "yyyy-MM-dd HH:mm:ss,SSS";
    private static final String NEW_LINE = "\n";
    private static final Color COLOR_INFO = Color.black;
    private static final Color COLOR_ERROR = Color.red;
    private static final Color COLOR_WARN = Color.orange;
    private static final Color COLOR_DEBUG = Color.gray;
    private static final Color COLOR_FATAL = Color.red;
    private static final Color COLOR_TRACE = Color.lightGray;
    private JTextPane textPane;
    private DateFormat dateFormat;
    private boolean fullLog;

    public TextAreaAppender(JTextPane textPane) {
        this(textPane, false);
    }
    public TextAreaAppender(JTextPane textPane, boolean fullLog) {
        this.textPane = textPane;
        this.fullLog = fullLog;
        dateFormat = new SimpleDateFormat(DATE_FORMAT_PATTERN);
        Font font = new Font("Monospaced", Font.PLAIN, 14);
        this.textPane.setFont(font);
        Logger.getRootLogger().addAppender(this);
    }

    @Override
    protected void append(final LoggingEvent loggingEvent) {
        StringBuilder builder = new StringBuilder();
        if (fullLog) {
            builder.append(dateFormat.format(new Date(loggingEvent.getTimeStamp()))).append(" ");
            builder.append(loggingEvent.getLevel()).append(" ");
            builder.append("[").append(loggingEvent.getThreadName()).append("] ");
            builder.append(loggingEvent.getLocationInformation().fullInfo).append(" - ");
        }
        builder.append(loggingEvent.getMessage()).append(NEW_LINE);
        if (loggingEvent.getThrowableInformation() != null) {
            for (String line: loggingEvent.getThrowableStrRep()) {
                builder.append(line).append('\n');
            }
        }
        final String logMessage = builder.toString();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                append(logMessage, loggingEvent.getLevel());
            }
        });
    }

    private void append(String logMessage, Level logLevel) {
        Color color = COLOR_INFO;
        if (logLevel == Level.ERROR) {
            color = COLOR_ERROR;
        } else if (logLevel == Level.WARN) {
            color = COLOR_WARN;
        } else if (logLevel == Level.DEBUG) {
            color = COLOR_DEBUG;
        } else if (logLevel == Level.FATAL) {
            color = COLOR_FATAL;
        } else if (logLevel == Level.TRACE) {
            color = COLOR_TRACE;
        }
        append(logMessage, color);
    }

    private void append(String message, Color color) {
        StyleContext styleContext = StyleContext.getDefaultStyleContext();
        AttributeSet attributeSet = styleContext.addAttribute(SimpleAttributeSet.EMPTY,
                StyleConstants.Foreground, color);

        int length = textPane.getDocument().getLength();
        textPane.setCaretPosition(length);
        textPane.setCharacterAttributes(attributeSet, false);
        try {
            textPane.getStyledDocument().insertString(length, message, attributeSet);
        } catch (BadLocationException e) {
            // bad luck
        }
    }

    @Override
    public void close() {

    }

    @Override
    public boolean requiresLayout() {
        return false;
    }
}
