package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.dto.LoginDTO;
import org.cybersoft.capstone.mapper.LoginMapper;
import org.cybersoft.capstone.payload.response.LoginResponse;
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LoginDTO loginDTO = this.loginMapper.loginParameterToDTO(req);
        LoginResponse loginResponse = this.loginService.loginUser(loginDTO);

        ServletContext servletContext = this.getServletConfig()
                .getServletContext();
        servletContext.setAttribute("isValid", String.valueOf(loginResponse.getValid()));
        servletContext.setAttribute("userId", String.valueOf(loginResponse.getId()));

        if (Boolean.TRUE.equals(loginResponse.getValid())) {
            System.out.println("Login Successfully");
            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            System.out.println("Login Failed");
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
