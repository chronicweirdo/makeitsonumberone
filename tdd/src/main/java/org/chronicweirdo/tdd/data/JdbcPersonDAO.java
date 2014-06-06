package org.chronicweirdo.tdd.data;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by scacoveanu on 6/6/2014.
 */
public class JdbcPersonDAO {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Person> findByLastName(String name) {
        try {
            Connection connection = dataSource.getConnection();
            String sql = "SELECT * FROM people WHERE last_name = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            List<Person> people = new ArrayList<Person>();
            while (resultSet.next()) {
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                people.add(new Person(firstName, lastName));
            }
            resultSet.close();
            statement.close();
            connection.close();
            return people;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
