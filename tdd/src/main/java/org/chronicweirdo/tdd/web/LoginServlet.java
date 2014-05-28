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

    protected AuthenticationService getAuthenticationService() {
        return null;
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("j_username");
        String password = request.getParameter("j_password");
        if (getAuthenticationService().isValidLogin(user, password)) {
            response.sendRedirect("/frontpage");
            request.getSession().setAttribute("username", user);
        } else {
            response.sendRedirect("/invalidlogin");
        }
    }
}
