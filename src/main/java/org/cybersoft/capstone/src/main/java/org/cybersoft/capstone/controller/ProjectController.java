package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.config.CustomServlet;
import org.cybersoft.capstone.constant.Role;
import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.mapper.ProjectMapper;
import org.cybersoft.capstone.mapper.StatisticMapper;
import org.cybersoft.capstone.payload.response.ProjectDetailResponse;
import org.cybersoft.capstone.payload.response.ProjectStatResponse;
import org.cybersoft.capstone.service.ProjectService;
import org.cybersoft.capstone.service.UserService;
import org.cybersoft.capstone.service.impl.ProjectServiceImpl;
import org.cybersoft.capstone.service.impl.UserServiceImpl;
import org.cybersoft.capstone.util.SessionUtil;
import org.cybersoft.capstone.util.Utils;
import org.cybersoft.capstone.validation.ProjectRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "projectController",
        urlPatterns = {"/groupwork", "/groupwork/*", "/groupwork-add", "/groupwork-details/*"}
)
public class ProjectController extends CustomServlet {
    private final SessionUtil sessionUtil = SessionUtil.getInstance();
    private final ProjectRequest projectRequest = new ProjectRequest();
    private final StatisticMapper statisticMapper = new StatisticMapper();
    private final ProjectMapper projectMapper = new ProjectMapper();
    private final ProjectService projectService = new ProjectServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/groupwork":
                Object userId = this.sessionUtil.getValue(req, "userId");
                if (userId != null) {
                    this.getProjects(req, Integer.parseInt(userId.toString()));
                } else {
                    this.getProjects(req);
                }
                break;
            case "/groupwork-add":
                this.getOptions(req);
                break;
            default:
                break;
        }

        Utils.navigate(req, resp);
    }

    @Override
    protected void doGetDetail(HttpServletRequest req, HttpServletResponse resp, Integer pathParameter) throws ServletException, IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/groupwork":
                this.getOptions(req);
                this.getProject(req, pathParameter);
                req.getRequestDispatcher("/groupwork-edit.jsp")
                        .forward(req, resp);
                break;
            case "/groupwork-details":
                this.getProjectStatistic(req, pathParameter);
                this.getProjectDetail(req, pathParameter);
                req.getRequestDispatcher("/groupwork-details.jsp")
                        .forward(req, resp);
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ProjectDTO projectDTO = this.projectRequest.getParameter(req);

        if (projectDTO == null) {
            this.getOptions(req);
            Utils.navigate(req, resp);
            return;
        }

        Boolean isCreated = this.projectService.createProject(projectDTO);

        if (isCreated) {
            resp.sendRedirect(req.getContextPath() + "/groupwork");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp, Integer pathParameter) throws IOException, ServletException {
        ProjectDTO projectDTO = this.projectRequest.getParameter(req);

        if (projectDTO == null) {
            this.doGetDetail(req, resp, pathParameter);
            return;
        }

        Boolean isUpdated = this.projectService.updateProject(pathParameter, projectDTO);

        if (isUpdated) {
            resp.sendRedirect(req.getContextPath() + "/groupwork");
        }
    }

    private void getProjects(HttpServletRequest req) {
        List<ProjectEntity> projects = this.projectService.getProjects();
        req.setAttribute("projects", projects);
    }

    private void getProjects(HttpServletRequest req, Integer id) {
        List<ProjectEntity> projects = this.projectService.getProjects(id);
        req.setAttribute("projects", projects);
    }

    private void getProject(HttpServletRequest req, Integer id) {
        ProjectEntity project = this.projectService.getProject(id);
        req.setAttribute("project", project);
    }

    private void getProjectStatistic(HttpServletRequest req, Integer id) {
        List<StatusEntity> statuses = this.projectService.getProjectStatistic(id);
        ProjectStatResponse projectStat = this.statisticMapper.statusEntityToResponse(statuses);
        req.setAttribute("projectStat", projectStat);
    }

    private void getProjectDetail(HttpServletRequest req, Integer id) {
        List<ProjectEntity> project = this.projectService.getProjectDetail(id);
        List<ProjectDetailResponse> projectDetailResponse = this.projectMapper.projectEntitiesToResponse(project);
        req.setAttribute("project", projectDetailResponse);
    }

    private void getOptions(HttpServletRequest req) {
        List<UserEntity> users = this.userService.getUserOptionsByRole(Role.LEADER.getId());
        req.setAttribute("users", users);
    }
}
