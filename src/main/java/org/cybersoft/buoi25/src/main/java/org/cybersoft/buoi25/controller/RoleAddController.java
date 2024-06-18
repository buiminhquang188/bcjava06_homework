package org.cybersoft.buoi25.controller;

import org.cybersoft.buoi25.dto.RoleDTO;
import org.cybersoft.buoi25.service.RoleService;
import org.cybersoft.buoi25.service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "roleAddController", urlPatterns = {"/role-add"})
public class RoleAddController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("role-add.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        RoleDTO roleDTO = new RoleDTO(name, description);

        RoleService roleService = new RoleServiceImpl();
        Integer resultIndex = roleService.saveRole(roleDTO);

        resp.sendRedirect(req.getContextPath() + "/role-table");
    }
}
