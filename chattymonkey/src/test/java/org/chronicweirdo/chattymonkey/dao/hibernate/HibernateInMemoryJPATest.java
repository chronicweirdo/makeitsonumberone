package org.chronicweirdo.chattymonkey.dao.hibernate;

import org.chronicweirdo.chattymonkey.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

/**
 * Created by scacoveanu on 8/19/2014.
 */
public class HibernateInMemoryJPATest {

    @Test
    public void savePersonAndLoad() throws Exception {
        listClasspath();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.chronicweirdo.chattymonkey.jpa");

        Person person = getPerson();

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();

        entityManager.getTransaction().begin();
        List<Person> result = entityManager.createQuery("from Person", Person.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();

        for (Person p: result) {
            System.out.println(p.getUserName() + " " + p.getId());
        }

    }

    private void listClasspath() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)classLoader).getURLs();

        for (URL url: urls) {
            System.out.println(url.getFile());
        }
    }

    private Person getPerson() {
        Person person = new Person();
        person.setUserName("nick");
        person.setPassword("password");
        person.setEmail("user@email.com");
        return person;
    }
}
