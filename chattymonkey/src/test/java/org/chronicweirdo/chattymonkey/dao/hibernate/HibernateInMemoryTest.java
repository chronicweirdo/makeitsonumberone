package org.chronicweirdo.chattymonkey.dao.hibernate;

import org.chronicweirdo.chattymonkey.entity.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.Test;

/**
 * Created by scacoveanu on 8/19/2014.
 */
public class HibernateInMemoryTest {

    @Test
    public void savePerson() throws Exception {
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);

        Person person = new Person();
        person.setUserName("nick");
        person.setPassword("password");
        person.setEmail("user@email.com");

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(person);
        session.getTransaction().commit();
        session.close();
    }
}
