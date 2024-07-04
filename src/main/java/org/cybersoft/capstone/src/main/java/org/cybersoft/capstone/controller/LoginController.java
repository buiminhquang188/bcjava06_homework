package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.dto.LoginDTO;
import org.cybersoft.capstone.mapper.LoginMapper;
import org.cybersoft.capstone.service.LoginService;
import org.cybersoft.capstone.service.impl.LoginServiceImpl;
import org.cybersoft.capstone.util.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private final LoginService loginService = new LoginServiceImpl();

    private final LoginMapper loginMapper = new LoginMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utils.navigate(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginDTO loginDTO = this.loginMapper.loginParameterToDTO(req);
        Boolean isValid = this.loginService.loginUser(loginDTO);

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
