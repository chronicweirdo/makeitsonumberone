package org.chronicweirdo.tdd.web;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServlet;

/**
 * Created by scacoveanu on 5/28/2014.
 */
public class TestLoginServlet {

    public static final String J_USERNAME = "j_username";
    public static final String J_PASSWORD = "j_password";
    public static final String SESSION_USERNAME = "username";
    public static final String VALID_USER = "validuser";
    public static final String CORRECT_PASSWORD = "correctpassword";
    private FakeAuthenticationService authenticationService;
    private LoginServlet servlet;
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;

    @Test
    public void wrongPasswordShouldRedirectToErrorPage() throws Exception {
        request.addParameter(J_USERNAME, "nosuchuser");
        request.addParameter(J_PASSWORD, "wrongpassword");
        servlet.service(request, response);
        assertEquals("/invalidlogin", response.getRedirectedUrl());
    }

    @Test
    public void validLoginForwardsToFrontPageAndStoresUsername() throws Exception {
        request.addParameter(J_USERNAME, VALID_USER);
        request.addParameter(J_PASSWORD, CORRECT_PASSWORD);

        servlet.service(request, response);

        assertEquals("/frontpage", response.getRedirectedUrl());
        assertEquals(VALID_USER, request.getSession().getAttribute(SESSION_USERNAME));
    }

    @Before
    public void setUp() {
        authenticationService = new FakeAuthenticationService();
        authenticationService.addUser(VALID_USER, CORRECT_PASSWORD);

        servlet = new LoginServlet() {
            @Override
            protected AuthenticationService getAuthenticationService() {
                return authenticationService;
            }
        };

        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }
}
