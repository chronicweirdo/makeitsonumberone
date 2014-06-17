package org.chronicweirdo.tdd.data;

import static org.easymock.EasyMock.*;

import org.hibernate.*;
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

    @Test
    public void findByLastNameReturnsEmptyListUponException() throws Exception {
        String queryString = "from Person p where p.lastname = :lastname";
        String name = "Smith";
        HibernateException hibernateError = new HibernateException("");

        expect(factory.getCurrentSession()).andReturn(session);
        expect(session.createQuery(queryString)).andReturn(query);
        expect(query.setParameter("lastname", name)).andReturn(query);
        expect(query.list()).andThrow(hibernateError);

        replay(factory, session,query);

        HibernatePersonDao dao = new HibernatePersonDao();
        dao.setSessionFactory(factory);
        try {
            dao.findByLastName(name);
            fail("should've thrown and exception");
        } catch (RuntimeException expected) {
            assertSame(hibernateError, expected.getCause());
        }

        verify(factory, session, query);
    }
}
