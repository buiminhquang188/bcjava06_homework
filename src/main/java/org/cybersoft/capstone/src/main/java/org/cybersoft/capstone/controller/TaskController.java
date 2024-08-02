package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.config.CustomServlet;
import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.dto.TaskDTO;
import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.entity.TaskEntity;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.mapper.TaskMapper;
import org.cybersoft.capstone.service.ProjectService;
import org.cybersoft.capstone.service.StatusService;
import org.cybersoft.capstone.service.TaskService;
import org.cybersoft.capstone.service.UserService;
import org.cybersoft.capstone.service.impl.ProjectServiceImpl;
import org.cybersoft.capstone.service.impl.StatusServiceImpl;
import org.cybersoft.capstone.service.impl.TaskServiceImpl;
import org.cybersoft.capstone.service.impl.UserServiceImpl;
import org.cybersoft.capstone.util.SessionUtil;
import org.cybersoft.capstone.util.Utils;
import org.cybersoft.capstone.validation.TaskRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "taskController", urlPatterns = {"/task", "/task/*", "/task-add"})
public class TaskController extends CustomServlet {
    private final TaskRequest taskRequest = new TaskRequest();
    private final TaskMapper taskMapper = new TaskMapper();
    private final TaskService taskService = new TaskServiceImpl();
    private final ProjectService projectService = new ProjectServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final StatusService statusService = new StatusServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        Integer userId = Utils.getUserSessionId(req);

        switch (path) {
            case "/task":
                this.getAuthorizationAction(req);
                break;
            case "/task-add":
                this.getOptions(req, userId);
                break;
            default:
                break;
        }

        Utils.navigate(req, resp);
    }

    @Override
    protected void doGetDetail(HttpServletRequest req, HttpServletResponse resp, Integer pathParameter) throws ServletException, IOException {
        String path = req.getServletPath();
        Integer userId = Utils.getUserSessionId(req);

        if ("/task".equals(path)) {
            this.getTask(req, pathParameter);
            this.getOptions(req, userId);
            req.getRequestDispatcher("/task-edit.jsp")
                    .forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        TaskDTO taskDTO = this.taskRequest.getParameter(req);

        if (taskDTO == null) {
            this.getOptions(req);
            Utils.navigate(req, resp);
            return;
        }

        Boolean isCreated = this.taskService.createTask(taskDTO);

        if (isCreated) {
            resp.sendRedirect(req.getContextPath() + "/task");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp, Integer pathParameter) throws IOException, ServletException {
        TaskDTO taskDTO = this.taskRequest.getParameter(req);

        if (taskDTO == null) {
            this.doGetDetail(req, resp, pathParameter);
            return;
        }

        Boolean isUpdated = this.taskService.updateTask(pathParameter, taskDTO);

        if (isUpdated) {
            resp.sendRedirect(req.getContextPath() + "/task");
        }
    }

    private void getAuthorizationAction(HttpServletRequest req) {
        RoleDetailDTO roleDetailDTO = (RoleDetailDTO) SessionUtil.getInstance()
                .getValue(req, "roleDetailDTO");

        if (roleDetailDTO.getActionCode()
                .contains("VIEW_ALL_TASKS")) {
            this.getTasks(req);
            return;
        } else if (roleDetailDTO.getActionCode()
                .contains("VIEW_PROJECT_TASKS")) {
            List<TaskEntity> tasks = this.taskService.getTaskByOwnerId(roleDetailDTO.getId());
            req.setAttribute("tasks", tasks);
            return;
        }
        this.getTasks(req, roleDetailDTO.getId());
    }

    private void getTasks(HttpServletRequest req) {
        List<TaskEntity> tasks = this.taskService.getTasks();
        req.setAttribute("tasks", tasks);
    }

    private void getTasks(HttpServletRequest req, Integer id) {
        List<TaskEntity> tasks = this.taskService.getTasks(id);
        req.setAttribute("tasks", tasks);
    }

    private void getTask(HttpServletRequest req, Integer id) {
        TaskEntity task = this.taskService.getTask(id);
        req.setAttribute("task", task);
    }

    private void getOptions(HttpServletRequest req) {
        RoleDetailDTO roleDetailDTO = (RoleDetailDTO) SessionUtil.getInstance()
                .getValue(req, "roleDetailDTO");

        List<ProjectEntity> projects = this.projectService.getProjectOptions(roleDetailDTO);
        List<UserEntity> users = this.userService.getUserOptions(roleDetailDTO);
        List<StatusEntity> statuses = this.statusService.getStatuses();
        req.setAttribute("projects", projects);
        req.setAttribute("users", users);
        req.setAttribute("statuses", statuses);
    }

    private void getOptions(HttpServletRequest req, Integer id) {
        RoleDetailDTO roleDetailDTO = (RoleDetailDTO) SessionUtil.getInstance()
                .getValue(req, "roleDetailDTO");

        List<ProjectEntity> projects = this.projectService.getProjectOptions(roleDetailDTO);
        List<UserEntity> users = this.userService.getUserOptions(roleDetailDTO);
        List<StatusEntity> statuses = this.statusService.getStatuses();
        req.setAttribute("projects", projects);
        req.setAttribute("users", users);
        req.setAttribute("statuses", statuses);
    }
}
