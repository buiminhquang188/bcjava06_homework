package org.cybersoft.capstone.controller;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "logoutController", urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletContext servletContext = this.getServletConfig()
                .getServletContext();
        servletContext.setAttribute("isValid", null);
        servletContext.setAttribute("userId", null);

        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
