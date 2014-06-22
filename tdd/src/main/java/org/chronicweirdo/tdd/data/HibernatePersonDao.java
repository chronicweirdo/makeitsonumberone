package org.chronicweirdo.tdd.data;

import org.hibernate.*;

import java.util.List;

/**
 * Created by scacoveanu on 6/17/2014.
 */
public class HibernatePersonDao implements PersonDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Person> findByLastName(String name) {
        try {
            Session session = sessionFactory.getCurrentSession();
            String queryString = "from Person p where p.lastname = :lastname";
            Query query = session.createQuery(queryString);
            query.setParameter("lastname", name);
            return query.list();
        } catch (HibernateException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Person person) {
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = session.beginTransaction();
        session.save(person);
        transaction.commit();
    }
}
