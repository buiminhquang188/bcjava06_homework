package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.entity.TaskEntity;
import org.cybersoft.capstone.service.TaskService;
import org.cybersoft.capstone.service.impl.TaskServiceImpl;
import org.cybersoft.capstone.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "taskController", urlPatterns = {"/task", "/task-add"})
public class TaskController extends HttpServlet {
    private final TaskService taskService = new TaskServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<TaskEntity> tasks = this.taskService.getTasks();
        req.setAttribute("tasks", tasks);
        Utils.navigate(req, resp);
    }
}
