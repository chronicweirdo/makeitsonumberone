package org.chronicweirdo.chattymonkey.dao.hibernate;

import org.chronicweirdo.chattymonkey.dao.ConversationDAO;
import org.chronicweirdo.chattymonkey.entity.Conversation;
import org.chronicweirdo.chattymonkey.entity.Message;
import org.chronicweirdo.chattymonkey.entity.Person;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by scacoveanu on 9/1/2014.
 */
public class JPAConversationDAOTest extends JPADAOTest {

    private static final String EMAIL = "email";
    private static final String EMAIL2 = "email2";
    private static final String PASSWORD = "password";
    private static final String USERNAME = "username";
    private static final String USERNAME2 = "username2";
    private static final long TIME = 1;
    public static final String TITLE = "title";
    public static final String TITLE2 = "title2";
    private static final String TEXT1 = "text1";
    private static final String TEXT2 = "text2";
    private JPAConversationDAO conversationDAO;
    private Person person;
    private Person person2;

    @Before
    public void setUp() throws Exception {
        // will delete the database
        getNewEntityManager();

        // create some data
        person = new Person();
        person.setEmail(EMAIL);
        person.setPassword(PASSWORD);
        person.setUserName(USERNAME);

        person2 = new Person();
        person2.setEmail(EMAIL2);
        person2.setUserName(PASSWORD);
        person2.setUserName(USERNAME2);

        Conversation conversation = createConversation(TITLE, Arrays.asList(person, person2),
                Arrays.asList(person, person2, person), Arrays.asList("hello", "hi", "can we talk?"));
        Conversation conversation2 = createConversation(TITLE2, Arrays.asList(person2, person),
                Arrays.asList(person2, person, person, person), Arrays.asList("i am here", "where?", "where are you?", "are you stalking me??"));

        getEntityManager().getTransaction().begin();
        getEntityManager().persist(person);
        getEntityManager().persist(person2);
        getEntityManager().getTransaction().commit();

        getEntityManager().getTransaction().begin();
        getEntityManager().persist(conversation);
        getEntityManager().persist(conversation2);
        getEntityManager().getTransaction().commit();

        conversationDAO = new JPAConversationDAO();
        conversationDAO.setEntityManager(getEntityManager());
    }

    // first participant is author
    private Conversation createConversation(String title, List<Person> participants, List<Person> authors, List<String> messages) throws Exception {
        Conversation conversation = new Conversation();
        conversation.setTitle(title);
        if (participants == null || participants.size() < 1) {
            throw new Exception("must have at least a participant in a conversation");
        }
        conversation.setAuthor(participants.get(0));
        conversation.setParticipants(participants);
        conversation.setTime(System.currentTimeMillis());
        if (authors == null || messages == null || authors.size() != messages.size()) {
            throw new Exception("authors and messages do not contain correct data");
        }
        List<Message> messageList = new ArrayList<Message>(authors.size());
        for (int i = 0; i < authors.size(); i++) {
            Message message = new Message();
            message.setAuthor(authors.get(i));
            message.setText(messages.get(i));
            message.setConversation(conversation);
            message.setTime(System.currentTimeMillis());
            messageList.add(message);
        }
        conversation.setMessages(messageList);
        return conversation;
    }

    @Test
    public void loadConversations() throws Exception {
        List<Conversation> conversations = conversationDAO.getConversations(person);
        assertNotNull(conversations);
        assertEquals(conversations.size(), 2);
        Conversation conversation = conversations.get(0);
        assertEquals(conversation.getAuthor(), person);
        assertEquals(conversation.getParticipants().size(), 2);
        assertEquals(conversation.getMessages().size(), 3);
    }

    @Test
    public void save() throws Exception {
        Conversation conversation = createConversation("another conversation", Arrays.asList(person, person2),
                Arrays.asList(person), Arrays.asList("what a beautiful day"));
        conversationDAO.save(conversation);

        List<Conversation> conversations = conversationDAO.getConversations(person);
        assertEquals(conversations.size(), 3);
    }

    @Test
    public void delete() throws Exception {
        List<Conversation> originalConversations = conversationDAO.getConversations(person);
        assertTrue(originalConversations.size() > 0);
        conversationDAO.delete(originalConversations.get(0));
        List<Conversation> newConversations = conversationDAO.getConversations(person);
        assertEquals(originalConversations.size() - 1, newConversations.size());
    }

    //@After
    public void tearDown() throws Exception {
        // there is a problem with deleting data through JPA queries
        // cascading does not work correctly, we get constraint violations
        getEntityManager().getTransaction().begin();
        getEntityManager().createQuery("delete from Conversation c").executeUpdate();
        getEntityManager().getTransaction().commit();
        getEntityManager().getTransaction().begin();
        getEntityManager().createQuery("delete from Person p").executeUpdate();
        getEntityManager().getTransaction().commit();
    }

}
