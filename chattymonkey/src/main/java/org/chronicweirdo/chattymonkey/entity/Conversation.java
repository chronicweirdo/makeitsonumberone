package org.chronicweirdo.chattymonkey.entity;

import java.util.List;

/**
 * Created by Silviu on 8/26/14.
 *
 * A user will create a conversation and add participants to it.
 */
public class Conversation {
    private Person creator;
    private List<Person> participants;
    private long time;
    private String title;
    private List<Message> messages;

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public List<Person> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Person> participants) {
        this.participants = participants;
    }

    public Person getCreator() {
        return creator;
    }

    public void setCreator(Person creator) {
        this.creator = creator;
    }
}
