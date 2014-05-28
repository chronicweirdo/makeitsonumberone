package org.chronicweirdo.tdd.web;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Silviu on 5/28/14.
 */
public class FakeAuthenticationService implements AuthenticationService {

    private Map<String, String> users = new HashMap<String, String>();

    public void addUser(String username, String password) {
        users.put(username, password);
    }

    public boolean isValidLogin(String username, String password) {
        return users.containsKey(username) && password.equals(users.get(username));
    }
}
