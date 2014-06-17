package org.chronicweirdo.tdd.data;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 6/17/2014.
 */
public class JdbcTemplatePersonDaoTest {

    @Test
    public void testFindByLastname() throws Exception {
        final String lastName = "Smith";
        final List<Person> smiths = createListOfPeopleNamed(lastName);

        JdbcTemplate template = createMock(JdbcTemplate.class);
        template.query(eq("SELECT * FROM employee WHERE last_name = ?"), aryEq(new Object[] {lastName}),
                isA(PersonRowMapper.class));
        expectLastCall().andReturn(smiths);

        replay(template);

        JdbcTemplatePersonDao dao = new JdbcTemplatePersonDao();
        dao.setJdbcTemplate(template);
        assertEquals(smiths, dao.findByLastName(lastName));

        verify(template);
    }

    private List<Person> createListOfPeopleNamed(String lastName) {
        List<Person> expectedList = new ArrayList<Person>();
        expectedList.add(new Person("Alice", lastName));
        expectedList.add(new Person("Billy", lastName));
        expectedList.add(new Person("Clark", lastName));
        return expectedList;
    }
}
