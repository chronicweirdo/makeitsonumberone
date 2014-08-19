package org.chronicweirdo.chattymonkey.dao.hibernate;

import org.chronicweirdo.chattymonkey.dao.PersonDAO;
import org.chronicweirdo.chattymonkey.entity.Person;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by scacoveanu on 8/19/2014.
 */
public class JPAPersonDAOTest {

    public static final String JOAN = "Joan";
    private EntityManager entityManager;
    private PersonDAO dao;

    @Before
    public void setUp() throws Exception {
        // populate database with some data
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(JPADAO.PERSISTENCE_UNIT_NAME);
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(new Person("Jane"));
        entityManager.persist(new Person("Jessie"));
        entityManager.persist(new Person(JOAN));
        entityManager.persist(new Person("Mary"));
        entityManager.getTransaction().commit();
        //entityManager.close(); TODO: should this be closed? should a new entity manager be created every time?

        // create dao
        dao = new JPAPersonDAO();
        ((JPAPersonDAO) dao).setEntityManager(entityManager);
    }

    @Test
    public void save() throws Exception {
        dao.save(new Person("Alex"));

        entityManager.getTransaction().begin();
        List<Person> alexes = entityManager.createQuery("from Person where userName = 'Alex'", Person.class).getResultList();
        entityManager.getTransaction().commit();

        assertEquals(alexes.size(), 1);
        Person alex = alexes.get(0);
        assertEquals(alex.getUserName(), "Alex");
        assertNotNull(alex.getId());
    }

    @Test
    public void findByUserName() throws Exception {
        List<Person> joans = dao.findByUserName(JOAN);

        assertNotNull(joans);
        assertEquals(joans.size(), 1);
        Person joan = joans.get(0);
        assertEquals(joan.getUserName(), JOAN);
    }
}
