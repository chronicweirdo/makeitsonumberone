package org.chronicweirdo.tdd.web;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * Created by Silviu on 5/28/14.
 */
public class TestLoginController {

    @Test
    public void wrongPasswordShouldRedirectToErrorPage() throws Exception {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("j_username", "nosuchusername");
        request.addParameter("j_password", "nosuchpasword");
        MockHttpServletResponse response = new MockHttpServletResponse();

        Controller controller = new LoginController();
        ModelAndView modelAndView = controller.handleRequest(request, response);

        assertEquals("wrongpassword", modelAndView.getViewName());
    }
}
