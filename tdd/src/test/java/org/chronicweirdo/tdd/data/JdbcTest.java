package org.chronicweirdo.tdd.data;

import org.junit.Test;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.easymock.EasyMock.*;

/**
 * Created by scacoveanu on 6/6/2014.
 */
public class JdbcTest {

    @Test
    public void findPersonByLastname() throws Exception {
        DataSource dataSource = createMock(DataSource.class);
        Connection connection = createMock(Connection.class);
        expect(dataSource.getConnection()).andReturn(connection);
        String sql = "SELECT * FROM people WHERE last_name = ?";
        PreparedStatement statement = createMock(PreparedStatement.class);
        expect(connection.prepareStatement(sql)).andReturn(statement);
        statement.setString(1, "Smith");

        MockMultiRowResultSet resultSet = new MockMultiRowResultSet();
        String[] columns = new String[] {"first_name", "last_name"};
        resultSet.setupColumnNames(columns);
        List<Person> smiths = createListOfPeopleWithLastname("Smith");
        resultSet.setupRows(convertIntoResultSetArray(smiths));
        expect(statement.executeQuery()).andReturn(resultSet);

        resultSet.setExpectedCloseCalls(1);
        statement.close();
        connection.close();

        replay(dataSource, connection, statement);

        JdbcPersonDAO dao = new JdbcPersonDAO();
        dao.setDataSource(dataSource);
        List<Person> people = dao.findByLastName("Smith");
        assertEquals(smiths, people);
        verify(dataSource, connection, statement);
        resultSet.verify();
    }

    private Object[][] convertIntoResultSetArray(List<Person> people) {
        Object[][] array = new Object[people.size()][2];
        for (int i = 0; i < people.size(); i++) {
            Person person = people.get(i);
            array[i] = new Object[] {person.getFirstName(), person.getLastName()};
        }
        return array;
    }

    private List<Person> createListOfPeopleWithLastname(String lastName) {
        List<Person> expected = new ArrayList<Person>();
        expected.add(new Person("Alice", lastName));
        expected.add(new Person("Billy", lastName));
        expected.add(new Person("Samantha", lastName));
        return expected;
    }
}
