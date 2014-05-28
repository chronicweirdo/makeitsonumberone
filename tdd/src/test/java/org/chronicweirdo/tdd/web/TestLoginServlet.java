package org.chronicweirdo.tdd.web;

import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServlet;

/**
 * Created by scacoveanu on 5/28/2014.
 */
public class TestLoginServlet {

    @Test
    public void wrongPasswordShouldRedirectToErrorPage() throws Exception {
        HttpServlet servlet = new LoginServlet();
        MockHttpServletRequest request = new MockHttpServletRequest("GET", "/login");
        request.addParameter("j_username", "nosuchuser");
        request.addParameter("j_password", "wrongpassword");
        MockHttpServletResponse response = new MockHttpServletResponse();
        servlet.service(request, response);
        assertEquals("/invalidlogin", response.getRedirectedUrl());
    }
}
