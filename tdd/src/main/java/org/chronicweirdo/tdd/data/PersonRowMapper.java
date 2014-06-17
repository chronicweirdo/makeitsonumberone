package org.chronicweirdo.tdd.data;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by scacoveanu on 6/17/2014.
 */
public class PersonRowMapper implements RowMapper {

    public Object mapRow(ResultSet resultSet, int i) throws SQLException {
        return new Person(resultSet.getString("first_name"), resultSet.getString("last_name"));
    }
}
