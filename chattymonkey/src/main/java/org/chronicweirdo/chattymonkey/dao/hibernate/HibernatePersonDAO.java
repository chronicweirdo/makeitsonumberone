package org.chronicweirdo.chattymonkey.dao.hibernate;

import org.chronicweirdo.chattymonkey.dao.PersonDAO;
import org.chronicweirdo.chattymonkey.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

/**
 * Created by scacoveanu on 8/19/2014.
 */
public class HibernatePersonDAO implements PersonDAO {

    private SessionFactory sessionFactory;

    public void save(Person person) {

    }

    public List<Person> findByUserName(String userName) {
        return null;
    }

    public List<Person> findByEmail(String email) {
        return null;
    }
}
