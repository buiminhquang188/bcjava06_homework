package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.config.CustomServlet;
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
import org.cybersoft.capstone.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "taskController", urlPatterns = {"/task", "/task-add"})
public class TaskController extends CustomServlet {
    private final TaskMapper taskMapper = new TaskMapper();
    private final TaskService taskService = new TaskServiceImpl();
    private final ProjectService projectService = new ProjectServiceImpl();
    private final UserService userService = new UserServiceImpl();

    private final StatusService statusService = new StatusServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/task":
                this.getTasks(req);
                break;
            case "/task-add":
                this.createTask(req);
                break;
            default:
                break;
        }

        Utils.navigate(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        TaskDTO taskDTO = taskMapper.taskParameterToDTO(req);
        Boolean isCreated = this.taskService.createTask(taskDTO);

        if (isCreated) {
            resp.sendRedirect(req.getContextPath() + "/task");
        }
    }

    private void getTasks(HttpServletRequest req) {
        List<TaskEntity> tasks = this.taskService.getTasks();
        req.setAttribute("tasks", tasks);
    }

    private void createTask(HttpServletRequest req) {
        List<ProjectEntity> projects = this.projectService.getProjectOptions();
        List<UserEntity> users = this.userService.getUserOptions();
        List<StatusEntity> statuses = this.statusService.getStatuses();
        req.setAttribute("projects", projects);
        req.setAttribute("users", users);
        req.setAttribute("statuses", statuses);
    }
}
