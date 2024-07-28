package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.dto.LoginDTO;
import org.cybersoft.capstone.payload.response.LoginResponse;
import org.cybersoft.capstone.service.LoginService;
import org.cybersoft.capstone.service.impl.LoginServiceImpl;
import org.cybersoft.capstone.util.SessionUtil;
import org.cybersoft.capstone.util.Utils;
import org.cybersoft.capstone.validation.LoginRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loginController", urlPatterns = {"/login"})
public class LoginController extends HttpServlet {
    private final LoginRequest loginRequest = new LoginRequest();

    private final LoginService loginService = new LoginServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utils.navigate(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        SessionUtil sessionUtil = SessionUtil.getInstance();
        LoginDTO loginDTO = this.loginRequest.getParameter(req);

        if (loginDTO == null) {
            this.doGet(req, resp);
            return;
        }

        LoginResponse loginResponse = this.loginService.loginUser(loginDTO);

        if (Boolean.TRUE.equals(loginResponse.getValid())) {
            System.out.println("Login Successfully");

            sessionUtil.putValue(req, "userId", loginResponse.getId());
            sessionUtil.putValue(req, "isValid", loginResponse.getValid());

            resp.sendRedirect(req.getContextPath() + "/");
        } else {
            System.out.println("Login Failed");

            sessionUtil.putValue(req, "userId", null);
            sessionUtil.putValue(req, "isValid", loginResponse.getValid());

            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }
}
