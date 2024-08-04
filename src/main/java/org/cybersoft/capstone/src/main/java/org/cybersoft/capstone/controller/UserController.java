package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.config.CustomServlet;
import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.dto.UserDTO;
import org.cybersoft.capstone.entity.RoleEntity;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.entity.TaskEntity;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.mapper.StatisticMapper;
import org.cybersoft.capstone.mapper.UserMapper;
import org.cybersoft.capstone.payload.response.ProjectStatResponse;
import org.cybersoft.capstone.service.RoleService;
import org.cybersoft.capstone.service.TaskService;
import org.cybersoft.capstone.service.UserService;
import org.cybersoft.capstone.service.impl.RoleServiceImpl;
import org.cybersoft.capstone.service.impl.TaskServiceImpl;
import org.cybersoft.capstone.service.impl.UserServiceImpl;
import org.cybersoft.capstone.util.SessionUtil;
import org.cybersoft.capstone.util.Utils;
import org.cybersoft.capstone.validation.UserRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "userController", urlPatterns = {"/user-table", "/user-add", "/user-details/*"})
public class UserController extends CustomServlet {
    private final UserRequest userRequest = new UserRequest();
    private final UserMapper userMapper = new UserMapper();
    private final StatisticMapper statisticMapper = new StatisticMapper();
    private final UserService userService = new UserServiceImpl();
    private final RoleService roleService = new RoleServiceImpl();
    private final TaskService taskService = new TaskServiceImpl();

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
            default:
                break;
        }

        Utils.navigate(req, resp);
    }

    @Override
    protected void doGetDetail(HttpServletRequest req, HttpServletResponse resp, Integer pathParameter) throws ServletException, IOException {
        String path = req.getServletPath();
        if (path.equals("/user-details")) {
            this.getAuthorizationActionDetail(req, resp, pathParameter);
        }
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
            this.getUsers(req, roleDetailDTO.getId());
            return;
        } else if (roleDetailDTO.getActionCode()
                .contains("VIEW_MEMBERS_PROJECT")) {
            List<UserEntity> users = this.userService.getUserInProjectByOwnerId(roleDetailDTO.getId());
            req.setAttribute("users", users);
            return;
        }
        this.getUsersInProject(req, userId);
    }

    private void getAuthorizationActionDetail(HttpServletRequest req, HttpServletResponse resp, Integer pathParameter) throws ServletException, IOException {
        RoleDetailDTO roleDetailDTO = (RoleDetailDTO) SessionUtil.getInstance()
                .getValue(req, "roleDetailDTO");
        this.getUser(req, pathParameter);

        if (roleDetailDTO.getActionCode()
                .contains("VIEW_ALL_MEMBERS")) {
            this.getUserTask(req, pathParameter);
            this.getUserStatistic(req, pathParameter);
        } else if (roleDetailDTO.getActionCode()
                .contains("VIEW_MEMBERS_PROJECT")) {
            this.getUserTaskUnderOwner(req, roleDetailDTO.getId(), pathParameter);
            this.getUserStatisticUnderOwner(req, roleDetailDTO.getId(), pathParameter);
        }

        req.getRequestDispatcher("/user-details.jsp")
                .forward(req, resp);
    }

    private void getUsers(HttpServletRequest req, Integer excludeID) {
        List<UserEntity> users = this.userService.getUsers(excludeID);
        req.setAttribute("users", users);
    }

    private void getUsersInProject(HttpServletRequest req, Integer userId) {
        List<UserEntity> users = this.userService.getUsersInProject(userId);
        req.setAttribute("users", users);
    }

    private void getUser(HttpServletRequest req, Integer userId) {
        UserEntity user = this.userService.getUser(userId);
        req.setAttribute("user", user);
    }

    private void createUser(HttpServletRequest req) {
        List<RoleEntity> roles = this.roleService.getRoles();
        req.setAttribute("roles", roles);
    }

    private void getUserTask(HttpServletRequest req, Integer id) {
        List<TaskEntity> tasks = this.taskService.getTasksByUserId(id);
        Map<String, List<TaskEntity>> userTasks = this.userMapper.tasksEntitiesToResponse(tasks);
        req.setAttribute("userTasks", userTasks);
    }

    private void getUserStatistic(HttpServletRequest req, Integer id) {
        List<StatusEntity> statuses = this.taskService.getTaskStatisticByUserId(id);
        ProjectStatResponse projectStat = this.statisticMapper.statusEntityToResponse(statuses);
        req.setAttribute("projectStat", projectStat);
    }

    private void getUserTaskUnderOwner(HttpServletRequest req, Integer ownerId, Integer userId) {
        List<TaskEntity> tasks = this.taskService.getTaskByOwnerIdAndUserId(ownerId, userId);
        Map<String, List<TaskEntity>> userTasks = this.userMapper.tasksEntitiesToResponse(tasks);
        req.setAttribute("userTasks", userTasks);
    }

    private void getUserStatisticUnderOwner(HttpServletRequest req, Integer ownerId, Integer userId) {
        List<StatusEntity> statuses = this.taskService.getTaskStatisticByOwnerIdAndUserId(ownerId, userId);
        ProjectStatResponse projectStat = this.statisticMapper.statusEntityToResponse(statuses);
        req.setAttribute("projectStat", projectStat);
    }
}
