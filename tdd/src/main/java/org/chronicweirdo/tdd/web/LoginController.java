package org.chronicweirdo.tdd.web;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Silviu on 5/28/14.
 */
public class LoginController implements Controller {

    public static final String J_USERNAME = "j_username";
    public static final String J_PASSWORD = "j_password";
    public static final String FRONTPAGE = "frontpage";
    public static final String WRONGPASSWORD = "wrongpassword";
    private AuthenticationService authenticationService;

    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        String user = httpServletRequest.getParameter(J_USERNAME);
        String password = httpServletRequest.getParameter(J_PASSWORD);
        if (authenticationService.isValidLogin(user, password)) {
            return new ModelAndView(FRONTPAGE);
        } else {
            return new ModelAndView(WRONGPASSWORD);
        }
    }


    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }
}
