package org.chronicweirdo.chattymonkey.dao;

import org.chronicweirdo.chattymonkey.entity.Conversation;
import org.chronicweirdo.chattymonkey.entity.Person;

import java.util.List;

/**
 * Created by scacoveanu on 8/29/2014.
 */
public interface ConversationDAO {

    List<Conversation> getConversations(Person person);
}
