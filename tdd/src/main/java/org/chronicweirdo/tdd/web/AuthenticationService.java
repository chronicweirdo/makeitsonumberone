package org.chronicweirdo.tdd.web;

/**
 * Created by Silviu on 5/28/14.
 */
public interface AuthenticationService {
    boolean isValidLogin(String username, String password);
}
