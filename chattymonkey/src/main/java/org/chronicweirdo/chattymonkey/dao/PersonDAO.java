package org.chronicweirdo.chattymonkey.dao;

import org.chronicweirdo.chattymonkey.entity.Person;

import java.util.List;

/**
 * Created by scacoveanu on 8/19/2014.
 */
public interface PersonDAO {

    void save(Person person);

    List<Person> findByUserName(String userName);

    List<Person> findByEmail(String email);

    Person getForUsername(String username);

    List<Person> getContacts(Person user);
}
