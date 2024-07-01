package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userController", urlPatterns = {"/user-table", "/user-add", "/user-details"})
public class UserController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utils.navigate(req, resp);
    }

    private void navigate(HttpServletRequest req, HttpServletResponse resp, String path) throws ServletException, IOException {
        req.getRequestDispatcher(path)
                .forward(req, resp);
    }
}