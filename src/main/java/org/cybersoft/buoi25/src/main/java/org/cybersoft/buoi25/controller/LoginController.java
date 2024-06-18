package org.cybersoft.buoi25.controller;

import org.cybersoft.buoi25.service.LoginService;
import org.cybersoft.buoi25.service.impl.LoginServiceImpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        LoginService loginService = new LoginServiceImpl();
        Boolean isValid = loginService.loginUser(username, password);

        ServletContext servletContext = this.getServletConfig()
                .getServletContext();
        servletContext.setAttribute("isValid", String.valueOf(isValid));

        if (Boolean.TRUE.equals(isValid)) {
            System.out.println("Login Successfully");
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            System.out.println("Login Failed");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
