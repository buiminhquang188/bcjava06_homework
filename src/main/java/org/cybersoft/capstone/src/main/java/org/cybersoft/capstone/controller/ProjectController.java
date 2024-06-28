package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "projectController", urlPatterns = {"/groupwork", "/groupwork-add", "/groupwork-details"})
public class ProjectController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Utils.navigate(req, resp);
    }
}
