package org.chronicweirdo.chattymonkey.dao.hibernate;

import org.chronicweirdo.chattymonkey.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by scacoveanu on 8/19/2014.
 */
public class HibernateInMemoryTest {

    @Test
    public void savePersonJPA() throws Exception {
        listClasspath();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.chronicweirdo.chattymonkey.jpa");

        Person person = getPerson();

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(person);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    private void listClasspath() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)classLoader).getURLs();

        for (URL url: urls) {
            System.out.println(url.getFile());
        }

        //URL xml = classLoader.getResource("META-INF/persistence.xml");
        //System.out.println(xml.getFile());
    }

    @Test
    public void savePerson() throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Person person = getPerson();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }

    private Person getPerson() {
        Person person = new Person();
        person.setUserName("nick");
        person.setPassword("password");
        person.setEmail("user@email.com");
        return person;
    }
}
