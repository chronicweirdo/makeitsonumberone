package org.chronicweirdo.tdd.data;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
        Session session = sessionFactory.getCurrentSession();
        String queryString = "from Person p where p.lastname = :lastname";
        Query query = session.createQuery(queryString);
        query.setParameter("lastname", name);
        return query.list();
    }
}
