package org.chronicweirdo.chattymonkey.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Silviu on 8/26/14.
 *
 * A user will create a conversation and add participants to it.
 */
@Entity
public class Conversation {
    private Long id;
    private Person author;
    private List<Person> participants;
    private long time;
    private String title;
    private List<Message> messages;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    // one conversation to many messages
    // each conversation has many messages, each message has one conversation
    @OneToMany(cascade = {CascadeType.ALL})
    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    // many conversations to many users
    // each conversation has many participants and each participant has many conversations
    @ManyToMany//(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    public List<Person> getParticipants() {
        return participants;
    }

    public void setParticipants(List<Person> participants) {
        this.participants = participants;
    }

    // author *-1 conversation
    // each conversation has an author, but an author has more conversations
    @ManyToOne
    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person creator) {
        this.author = creator;
    }
}
