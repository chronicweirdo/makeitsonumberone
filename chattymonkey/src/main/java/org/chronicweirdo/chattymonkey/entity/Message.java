package org.chronicweirdo.chattymonkey.entity;

import java.util.List;

/**
 * Created by Silviu on 8/26/14.
 */
public class Message {
    private String text;
    private Person from;
    private List<Person> viewers;
    private long time;
    private Conversation conversation;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Person getFrom() {
        return from;
    }

    public void setFrom(Person from) {
        this.from = from;
    }

    public List<Person> getViewers() {
        return viewers;
    }

    public void setViewers(List<Person> viewers) {
        this.viewers = viewers;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
