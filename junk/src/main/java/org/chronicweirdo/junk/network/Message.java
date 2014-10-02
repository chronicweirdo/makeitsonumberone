package org.chronicweirdo.junk.network;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Created by scacoveanu on 10/2/2014.
 */
public class Message implements Serializable {

    public enum Type { COMMAND, OBJECT, TEXT, RECEIVED, ERROR }

    private Type type;

    private String text;

    private byte[] data;

    public Message(Type type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Message{" +
                "type=" + type +
                ", text='" + text + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
