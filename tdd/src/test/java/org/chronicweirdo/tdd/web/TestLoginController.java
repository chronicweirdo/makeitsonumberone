package org.chronicweirdo.tdd.web;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Silviu on 5/28/14.
 */
public class TestLoginController {

    public static final String VALID_USER = "validuser";
    public static final String CORRECT_PASSWORD = "correctpassword";
    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private FakeAuthenticationService authenticationService;
    private LoginController controller;

    @Test
    public void wrongPasswordShouldRedirectToErrorPage() throws Exception {
        request.addParameter(LoginController.J_USERNAME, "nosuchusername");
        request.addParameter(LoginController.J_PASSWORD, "nosuchpasword");

        ModelAndView modelAndView = controller.handleRequest(request, response);

        assertEquals(LoginController.WRONGPASSWORD, modelAndView.getViewName());
    }

    @Test
    public void validLoginForwardsToFrontPage() throws Exception {
        request.addParameter(LoginController.J_USERNAME, VALID_USER);
        request.addParameter(LoginController.J_PASSWORD, CORRECT_PASSWORD);

        ModelAndView modelAndView = controller.handleRequest(request, response);

        assertEquals(LoginController.FRONTPAGE, modelAndView.getViewName());
    }

    @Before
    public void setUp() {
        request = new MockHttpServletRequest();
        request.setMethod("GET");
        response = new MockHttpServletResponse();

        authenticationService = new FakeAuthenticationService();
        authenticationService.addUser(VALID_USER, CORRECT_PASSWORD);

        controller = new LoginController();
        controller.setAuthenticationService(authenticationService);
    }
}
