package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.config.CustomServlet;
import org.cybersoft.capstone.dto.TaskProgressDTO;
import org.cybersoft.capstone.service.TaskService;
import org.cybersoft.capstone.service.impl.TaskServiceImpl;
import org.cybersoft.capstone.validation.TaskRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "taskProgressController", urlPatterns = {"/task-progress/*"})
public class TaskProgressController extends CustomServlet {
    private final TaskRequest taskRequest = new TaskRequest();
    private final TaskService taskService = new TaskServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/404");
    }

    @Override
    protected void doGetDetail(HttpServletRequest req, HttpServletResponse resp, Integer pathParameter) throws IOException {
        resp.sendRedirect(req.getContextPath() + "/404");
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp, Integer pathParameter) throws IOException {
        TaskProgressDTO taskProgressDTO = this.taskRequest.getParameterProgress(req);

        Boolean isUpdated = this.taskService.updateProgressTask(pathParameter, taskProgressDTO);

        if (isUpdated) {
            resp.sendRedirect(req.getContextPath() + "/task");
        }
    }
}
