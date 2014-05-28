package org.chronicweirdo.tdd.web;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Silviu on 5/28/14.
 */
public class LoginServlet extends HttpServlet {

    public static final String J_USERNAME = "j_username";
    public static final String J_PASSWORD = "j_password";

    protected AuthenticationService getAuthenticationService() {
        return null;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter(J_USERNAME);
        String password = request.getParameter(J_PASSWORD);
        if (getAuthenticationService().isValidLogin(user, password)) {
            response.sendRedirect("/frontpage");
            request.getSession().setAttribute("username", user);
        } else {
            response.sendRedirect("/invalidlogin");
        }
    }
}
