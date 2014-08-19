package org.chronicweirdo.chattymonkey.entity;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by scacoveanu on 8/19/2014.
 */
public class PersonTest {

    @Test
    public void createAPerson() throws Exception {
        Person person = new Person();
        person.setEmail("person@email.com");
        person.setUserName("nick");
        person.setPassword("p455word");
        assertNotNull(person);
    }
}
