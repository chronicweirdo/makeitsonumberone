package org.chronicweirdo.chattymonkey.service;

import org.chronicweirdo.chattymonkey.dao.ConversationDAO;
import org.chronicweirdo.chattymonkey.dao.PersonDAO;
import org.chronicweirdo.chattymonkey.entity.Conversation;
import org.chronicweirdo.chattymonkey.entity.Message;
import org.chronicweirdo.chattymonkey.entity.Person;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Silviu on 8/26/14.
 *
 * This test simulates use cases of the messenger application.
 */
public class ChatServiceTest {

    public static final int CONTACTS_SIZE = 10;
    public static final int CONVERSATIONS_SIZE = 3;
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";
    private PersonService personService;
    private ChatService chatService;

    @Before
    public void setUp() throws Exception {
        personService = new PersonService();
        PersonDAO personDao = mock(PersonDAO.class);
        Person user = new Person();
        user.setPassword(PASSWORD);
        user.setUserName(USERNAME);
        when(personDao.getForUsername(USERNAME)).thenReturn(user);
        List<Person> contacts = new ArrayList<Person>(CONTACTS_SIZE);
        for (int i = 0; i < CONTACTS_SIZE; i++) {
            Person person = new Person();
            person.setUserName("person" + i);
            contacts.add(person);
        }
        when(personDao.getContacts(user)).thenReturn(contacts);
        personService.setPersonDAO(personDao);

        chatService = new ChatService();
        ConversationDAO conversationDAO = mock(ConversationDAO.class);
        List<Conversation> conversations = mockConversations();
        when(conversationDAO.getConversations(user)).thenReturn(conversations);
        chatService.setConversationDAO(conversationDAO);
    }

    private List<Conversation> mockConversations() {
        List<Conversation> conversations = new ArrayList<Conversation>();
        for (int i = 0; i < CONVERSATIONS_SIZE; i++) {
            conversations.add(mockConversation());
        }
        return conversations;
    }

    private Conversation mockConversation() {
        return new Conversation();
    }

    @Test
    public void newConversation() throws Exception {
        // a user logs in to the application
        String username = USERNAME;
        String password = PASSWORD;
        Person user = personService.authenticate(username, password);
        assertNotNull(user);
        assertEquals(user.getUserName(), username);
        assertEquals(user.getPassword(), password);

        // they have a list of friends and conversations
        List<Person> contacts = personService.getContacts(user);
        assertNotNull(contacts);
        assertEquals(contacts.size(), CONTACTS_SIZE);
        List<Conversation> conversations = chatService.getConversations(user);
        assertNotNull(conversations);
        assertEquals(conversations.size(), CONVERSATIONS_SIZE);

        // they decide to create a new conversation
        String title = "conversation title";
        Conversation conversation = chatService.createConversation(user, title);
        assertNotNull(conversation);
        assertEquals(conversation.getTitle(), title);
        assertEquals(conversation.getCreator(), user);
        conversations = chatService.getConversations(user);
        assertNotNull(conversations);
        assertEquals(conversations.size(), CONVERSATIONS_SIZE + 1);
        assertTrue(conversations.contains(conversation));
        assertEquals(conversation.getParticipants().size(), 1);
        assertTrue(conversation.getParticipants().contains(user));

        // they give a title to the conversation (optional) and add people to it
        List<Person> participants = new ArrayList<Person>(3);
        participants.add(contacts.get(0));
        participants.add(contacts.get(1));
        participants.add(contacts.get(2));
        conversation = chatService.add(conversation, participants);
        assertNotNull(conversation);
        assertEquals(conversation.getParticipants(), participants.size() + 1);
        assertTrue(conversation.getParticipants().contains(contacts.get(0)));
        assertTrue(conversation.getParticipants().contains(contacts.get(1)));
        assertTrue(conversation.getParticipants().contains(contacts.get(2)));
        assertTrue(conversation.getParticipants().contains(user));


        // they send the first message
        String text = "first text message";
        Message message = chatService.message(user, conversation, text);
        assertNotNull(message);
        assertEquals(message.getText(), text);
        assertEquals(message.getFrom(), user);
        assertEquals(message.getViewers().size(), 4);
        assertTrue(message.getViewers().contains(contacts.get(0)));
        assertTrue(message.getViewers().contains(contacts.get(1)));
        assertTrue(message.getViewers().contains(contacts.get(2)));
        assertTrue(message.getViewers().contains(user));

        // periodic updates to the ui show if a new message has arrived in the conversation
        List<Message> messages = chatService.getNew(user, conversation);
        assertNotNull(messages);
        assertEquals(messages.size(), 0);
        messages = chatService.getNew(user, conversation);
        assertNotNull(messages);
        assertEquals(messages.size(), 1);

        // they receive a new message from one of the users
        messages = chatService.getNew(user, conversation);
        assertNotNull(messages);
        assertEquals(messages.size(), 1);

        // they answer
        String text2 = "second text message";
        message = chatService.message(user, conversation, text2);
        //assertNotNull();

        // they receive new messages from more users
        messages = chatService.getNew(user, conversation);

        // they answer
        // ..

        // all the while, with each exchange, the conversation grows
    }
}
