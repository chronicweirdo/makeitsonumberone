package org.chronicweirdo.chattymonkey.service;

import org.chronicweirdo.chattymonkey.dao.PersonDAO;
import org.chronicweirdo.chattymonkey.entity.Person;

import java.util.List;

/**
 * Created by Silviu on 8/26/14.
 */
public class PersonService {

    private PersonDAO personDAO;

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    public Person authenticate(String username, String password) throws Exception {
        if (username == null || password == null) {
            throw new Exception("Insufficient data.");
        }
        Person person = personDAO.getForUsername(username);
        if (person == null) {
            throw new Exception("No person with " + username + " username.");
        }
        if (!password.equals(person.getPassword())) {
            throw new Exception("Authentication exception.");
        }
        return person;
    }

    public List<Person> getContacts(Person user) {
        List<Person> contacts = personDAO.getContacts(user);
        return contacts;
    }
}
