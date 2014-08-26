package org.chronicweirdo.chattymonkey.service;

import org.chronicweirdo.chattymonkey.entity.Conversation;
import org.chronicweirdo.chattymonkey.entity.Message;
import org.chronicweirdo.chattymonkey.entity.Person;

import java.util.List;

/**
 * Created by Silviu on 8/26/14.
 */
public class ChatService {

    public List<Conversation> getConversations(Person user) {
        return null;
    }

    public Conversation createConversation(Person user, String title) {
        return null;
    }

    public Conversation add(Conversation conversation, List<Person> participants) {
        return null;
    }

    public Message message(Person user, Conversation conversation, String text) {
        return null;
    }

    public List<Message> getNew(Person user, Conversation conversation) {
        return null;
    }
}
