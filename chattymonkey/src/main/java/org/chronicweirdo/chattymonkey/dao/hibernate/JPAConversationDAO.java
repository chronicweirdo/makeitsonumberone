package org.chronicweirdo.chattymonkey.dao.hibernate;

import org.chronicweirdo.chattymonkey.dao.ConversationDAO;
import org.chronicweirdo.chattymonkey.entity.Conversation;
import org.chronicweirdo.chattymonkey.entity.Person;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 9/1/2014.
 */
public class JPAConversationDAO extends JPADAO implements ConversationDAO {

    public void save(Conversation conversation) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(conversation);
        getEntityManager().getTransaction().commit();
    }

    public List<Conversation> getConversations(Person person) {
        getEntityManager().getTransaction().begin();
        //Query query = getEntityManager().createQuery("select c from Conversation c where c.author=:author", Conversation.class);
        Query query = getEntityManager().createQuery("select c from Conversation c where :author member of c.participants", Conversation.class);
        query.setParameter("author", person);
        List<Conversation> result = query.getResultList();
        getEntityManager().getTransaction().commit();
        if (result == null) {
            return new ArrayList<Conversation>(0);
        } else {
            return result;
        }
    }
}
