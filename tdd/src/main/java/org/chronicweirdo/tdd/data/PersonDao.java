package org.chronicweirdo.tdd.data;

import java.util.List;

/**
 * Created by scacoveanu on 6/17/2014.
 */
public interface PersonDao {
    List<Person> findByLastName(String name);
}
