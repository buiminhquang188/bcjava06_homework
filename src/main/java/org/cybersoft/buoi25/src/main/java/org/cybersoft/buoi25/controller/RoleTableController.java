package org.cybersoft.buoi25.controller;

import org.cybersoft.buoi25.entity.RoleEntity;
import org.cybersoft.buoi25.service.RoleService;
import org.cybersoft.buoi25.service.impl.RoleServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "roleTableController", urlPatterns = {"/role-table"})
public class RoleTableController extends HttpServlet {
    private final RoleService roleService;

    public RoleTableController() {
        this.roleService = new RoleServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoleEntity> roles = this.roleService.getRoles();

        req.setAttribute("roles", roles);
        req.getRequestDispatcher("role-table.jsp")
                .forward(req, resp);
    }
}
