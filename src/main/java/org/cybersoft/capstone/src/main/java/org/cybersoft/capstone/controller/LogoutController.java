package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.util.SessionUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "logoutController", urlPatterns = {"/logout"})
public class LogoutController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        SessionUtil sessionUtil = SessionUtil.getInstance();

        sessionUtil.removeValue(req, "userId");
        sessionUtil.removeValue(req, "isValid");

        SessionUtil.getInstance()
                .removeValue(req, "roleDetailDTO");

        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
