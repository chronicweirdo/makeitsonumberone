package org.chronicweirdo.chattymonkey.dao.hibernate;

import org.chronicweirdo.chattymonkey.dao.PersonDAO;
import org.chronicweirdo.chattymonkey.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 8/19/2014.
 */
public class JPAPersonDAO extends JPADAO implements PersonDAO {

    public void save(Person person) {
        getEntityManager().getTransaction().begin();

        getEntityManager().persist(person);

        getEntityManager().getTransaction().commit();
    }

    public List<Person> findByUserName(String userName) {
        getEntityManager().getTransaction().begin();
        List<Person> result = getEntityManager().createQuery("from Person where userName='" + userName + "'", Person.class).getResultList();
        getEntityManager().getTransaction().commit();
        if (result == null) {
            return new ArrayList<Person>();
        } else {
            return result;
        }

    }

    public List<Person> findByEmail(String email) {
        return null;
    }
}
