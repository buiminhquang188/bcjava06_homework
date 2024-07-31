package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.dto.UserDTO;
import org.cybersoft.capstone.entity.RoleEntity;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.service.RoleService;
import org.cybersoft.capstone.service.UserService;
import org.cybersoft.capstone.service.impl.RoleServiceImpl;
import org.cybersoft.capstone.service.impl.UserServiceImpl;
import org.cybersoft.capstone.util.SessionUtil;
import org.cybersoft.capstone.util.Utils;
import org.cybersoft.capstone.validation.UserRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "userController", urlPatterns = {"/user-table", "/user-add", "/user-details/*"})
public class UserController extends HttpServlet {
    private final UserService userService = new UserServiceImpl();
    private final RoleService roleService = new RoleServiceImpl();

    private final UserRequest userRequest = new UserRequest();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        switch (path) {
            case "/user-table":
                this.getAuthorizationAction(req);
                break;
            case "/user-add":
                this.createUser(req);
                break;
            case "/user-details":
                this.getUser(req);
                break;
            default:
                break;
        }

        Utils.navigate(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        if (!path.equals("/user-add")) {
            resp.sendRedirect(req.getContextPath() + "/404");
        }

        UserDTO userDTO = this.userRequest.getParameter(req, resp);

        if (userDTO == null) {
            this.createUser(req);
            Utils.navigate(req, resp);
            return;
        }

        Integer resultIndex = this.userService.createUser(userDTO);

        if (resultIndex > 0) {
            resp.sendRedirect(req.getContextPath() + "/user-table");
        }
    }

    private void getAuthorizationAction(HttpServletRequest req) {
        RoleDetailDTO roleDetailDTO = (RoleDetailDTO) SessionUtil.getInstance()
                .getValue(req, "roleDetailDTO");
        Integer userId = Utils.getUserSessionId(req);

        if (roleDetailDTO.getActionCode()
                .contains("VIEW_ALL_MEMBERS")) {
            this.getUsers(req);
            return;
        }
        this.getUsersInProject(req, userId);
    }

    private void getUsers(HttpServletRequest req) {
        List<UserEntity> users = this.userService.getUsers();
        req.setAttribute("users", users);
    }

    private void getUsersInProject(HttpServletRequest req, Integer userId) {
        List<UserEntity> users = this.userService.getUsersInProject(userId);
        req.setAttribute("users", users);
    }

    private void getUser(HttpServletRequest req) {
        Integer id = Utils.getPathParameter(req);
        UserEntity user = this.userService.getUser(id);
        req.setAttribute("user", user);
    }

    private void createUser(HttpServletRequest req) {
        List<RoleEntity> roles = this.roleService.getRoles();
        req.setAttribute("roles", roles);
    }
}
