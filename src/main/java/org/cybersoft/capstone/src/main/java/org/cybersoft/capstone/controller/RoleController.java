package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.dto.RoleDTO;
import org.cybersoft.capstone.entity.RoleEntity;
import org.cybersoft.capstone.service.RoleService;
import org.cybersoft.capstone.service.impl.RoleServiceImpl;
import org.cybersoft.capstone.util.Utils;
import org.cybersoft.capstone.validation.RoleRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "roleController", urlPatterns = {"/role-table", "/role-add"})
public class RoleController extends HttpServlet {
    private final RoleRequest roleRequest = new RoleRequest();
    private final RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/role-table":
                this.getRoles(req);
                break;
            default:
                break;
        }
        Utils.navigate(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        req.setCharacterEncoding("UTF-8");
        RoleDTO roleDTO = this.roleRequest.getParameter(req);

        if (roleDTO == null) {
            Utils.navigate(req, resp);
            return;
        }

        Integer resultIndex = this.roleService.createRole(roleDTO);

        if (resultIndex > 0) {
            resp.sendRedirect(req.getContextPath() + "/role-table");
        }
    }

    private void getRoles(HttpServletRequest req) {
        List<RoleEntity> roles = this.roleService.getRoles();
        req.setAttribute("roles", roles);
    }
}
