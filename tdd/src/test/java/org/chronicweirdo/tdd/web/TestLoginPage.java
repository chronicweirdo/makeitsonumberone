package org.chronicweirdo.tdd.web;

/**
 * Created by scacoveanu on 6/2/2014.
 */
public class TestLoginPage extends MyJspTestCase {

    public void testFormFieldsArePresent() throws Exception {
        System.out.println(getWebRoot());
        get("/login.jsp");
        form().shouldHaveField("j_username");
        form().shouldHaveField("j_password");
        form().shouldHaveSubmitButton("login");
    }
}
