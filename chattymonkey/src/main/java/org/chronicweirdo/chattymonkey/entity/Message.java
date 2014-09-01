package org.chronicweirdo.chattymonkey.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Silviu on 8/26/14.
 *
 * More on hibernate annotations: http://docs.jboss.org/hibernate/stable/annotations/reference/en/html_single/
 */
@Entity
public class Message {
    private Long id;
    private String text;
    private Person author;
    // removing viewers, since all people in a conversation can see the message
    private long time;
    private Conversation conversation;

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name="increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @OneToOne
    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @ManyToOne
    public Conversation getConversation() {
        return conversation;
    }

    public void setConversation(Conversation conversation) {
        this.conversation = conversation;
    }
}
