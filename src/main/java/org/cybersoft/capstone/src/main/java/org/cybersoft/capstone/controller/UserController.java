package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.dto.UserDTO;
import org.cybersoft.capstone.entity.RoleEntity;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.service.RoleService;
import org.cybersoft.capstone.service.UserService;
import org.cybersoft.capstone.service.impl.RoleServiceImpl;
import org.cybersoft.capstone.service.impl.UserServiceImpl;
import org.cybersoft.capstone.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userController", urlPatterns = {"/user-table", "/user-add", "/user-details"})
public class UserController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final RoleService roleService = new RoleServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/user-table":
                this.getUsers(req, resp);
                break;
            case "/user-add":
                this.createUser(req, resp);
                break;
            default:
                break;
        }

        Utils.navigate(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phoneNumber = req.getParameter("phoneNumber");
        String role = req.getParameter("role");

        UserDTO userDTO = new UserDTO(firstName, lastName, email, password, phoneNumber, Integer.parseInt(role));
        Integer resultIndex = this.userService.createUser(userDTO);

        if (resultIndex > 0) {
            resp.sendRedirect(req.getContextPath() + "/user-table");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    private void getUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<UserEntity> users = this.userService.getUsers();
        req.setAttribute("users", users);
    }

    private void createUser(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<RoleEntity> roles = this.roleService.getRoles();
        req.setAttribute("roles", roles);
    }
}
