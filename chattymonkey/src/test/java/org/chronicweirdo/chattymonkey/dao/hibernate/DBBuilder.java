package org.chronicweirdo.chattymonkey.dao.hibernate;

import org.chronicweirdo.chattymonkey.entity.Conversation;
import org.chronicweirdo.chattymonkey.entity.Message;
import org.chronicweirdo.chattymonkey.entity.Person;

import javax.persistence.EntityManager;
import java.util.*;

/**
 * Utility class used to populate the in-memory db with some test data
 * Created by scacoveanu on 9/1/2014.
 */
public class DBBuilder {

    public static final List<String> TEXT_DICTIONARY = Arrays.asList(
            "hello", "hi", "how are you?", "are we going out tonight?",
            "did you see the last episode of that show?", "can we talk?",
            "are you around?", "want to see a picture of my knees?"
        );

    private static Random random = new Random(System.currentTimeMillis());

    public static final String[] NAMES = {"olivaw", "glados", "bender", "coppelia"};

    private static String getEmail(String userName) {
        return userName + "@mail.com";
    }

    private static String getPassword(String userName) {
        StringBuilder builder = new StringBuilder();
        boolean odd = false;
        for (char c: userName.toCharArray()) {
            if (odd) {
                builder.append(Character.toUpperCase(c));
            } else {
                builder.append(c);
            }
            odd = !odd;
        }
        return builder.toString();
    }

    private static Person createPerson(String userName) {
        Person person = new Person();
        person.setUserName(userName);
        person.setEmail(getEmail(userName));
        person.setPassword(getPassword(userName));
        return person;
    }

    private static <T> T choose(List<T> options) {
        int choice = random.nextInt(options.size());
        return options.get(choice);
    }

    private static Conversation createConversation(String title, List<Person> participants, int size) throws Exception {
        Conversation conversation = new Conversation();
        conversation.setTitle(title);
        if (participants == null || participants.size() < 1) {
            throw new Exception("must have at least a participant in a conversation");
        }
        conversation.setAuthor(participants.get(0));
        conversation.setParticipants(participants);
        conversation.setTime(System.currentTimeMillis());

        // create random messages
        List<Message> messageList = new ArrayList<Message>(size);
        for (int i = 0; i < size; i++) {
            Message message = new Message();
            message.setAuthor(choose(participants));
            message.setText(choose(TEXT_DICTIONARY));
            message.setConversation(conversation);
            message.setTime(System.currentTimeMillis());
            messageList.add(message);
        }
        conversation.setMessages(messageList);
        return conversation;
    }

    private static Conversation createConversation(String title, List<Person> participants, List<Person> authors,
                                            List<String> messages) throws Exception {
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

    public static void populateDB(EntityManager entityManager) throws Exception {
        // create users
        Map<String, Person> nameToPerson = new HashMap<String, Person>(NAMES.length);
        entityManager.getTransaction().begin();
        for (String name: NAMES) {
            Person person = createPerson(name);
            entityManager.persist(person);
            nameToPerson.put(name, person);
        }
        entityManager.getTransaction().commit();

        // create conversation between users
        entityManager.getTransaction().begin();

        entityManager.persist(createConversation("guybots",
                Arrays.asList(nameToPerson.get(NAMES[0]), nameToPerson.get(NAMES[2])), 3));
        entityManager.persist(createConversation("girlbots",
                Arrays.asList(nameToPerson.get(NAMES[1]), nameToPerson.get(NAMES[3])), 10));
        entityManager.persist(createConversation("notevilones"),
                Arrays.asList(nameToPerson.get(NAMES[0]), nameToPerson.get(NAMES[2]), nameToPerson.get(NAMES[3]), 7)
                );

        entityManager.getTransaction().commit();
    }
}
