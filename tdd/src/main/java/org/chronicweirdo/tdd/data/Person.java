package org.chronicweirdo.tdd.data;

/**
 * Created by scacoveanu on 6/6/2014.
 */
public class Person {
    private String lastName;
    private String firstName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
