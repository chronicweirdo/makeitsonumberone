package org.chronicweirdo.tdd.web;

import org.junit.Test;

/**
 * Created by scacoveanu on 6/2/2014.
 */
public class TestLoginTemplate extends VelocityTestCase {

    @Override
    protected String getWebRoot() {
        return "tdd/src/main/webapp/jsp";
    }

    @Test
    public void previousUsernameIsRetained() throws Exception {
        String previousUsername = "Bob";
        setAttribute("username", previousUsername);
        render("/login.vtl");
        assertFormFieldValue("j_username", previousUsername);
    }
}
