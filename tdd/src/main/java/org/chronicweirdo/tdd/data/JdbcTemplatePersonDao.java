package org.chronicweirdo.tdd.data;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import java.util.List;

/**
 * Created by scacoveanu on 6/17/2014.
 */
public class JdbcTemplatePersonDao extends JdbcDaoSupport implements PersonDao{

    public List<Person> findByLastName(String name) {
        String sql = "SELECT * FROM employee WHERE last_name = ?";
        String[] args = new String[] { name };
        RowMapper mapper = new PersonRowMapper();
        return getJdbcTemplate().query(sql, args, mapper);
    }

    public void save(Person person) {
        throw new RuntimeException("not implemented");
    }
}
