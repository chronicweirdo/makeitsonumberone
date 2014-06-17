package org.chronicweirdo.tdd.data;

import static org.easymock.EasyMock.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 6/17/2014.
 */
public class HibernatePersonDaoTest {

    private SessionFactory factory;
    private Session session;
    private Query query;

    @Before
    public void setUp() {
        factory = createMock(SessionFactory.class);
        session = createMock(Session.class);
        query = createMock(Query.class);
    }

    @Test
    public void findByLastName() throws Exception {
        String hibernateQuery = "from Person p where p.lastname = :lastname";
        String lastName = "Smith";

        List<Person> theSmiths = new ArrayList<Person>();
        theSmiths.add(new Person("Alice", lastName));
        theSmiths.add(new Person("Billy", lastName));
        theSmiths.add(new Person("Clark", lastName));

        expect(factory.getCurrentSession()).andReturn(session);
        expect(session.createQuery(hibernateQuery)).andReturn(query);
        expect(query.setParameter("lastname", lastName)).andReturn(query);
        expect(query.list()).andReturn(theSmiths);

        replay(factory, session, query);

        HibernatePersonDao dao = new HibernatePersonDao();
        dao.setSessionFactory(factory);
        assertEquals(theSmiths, dao.findByLastName(lastName));

        verify(factory, session, query);
    }
}
