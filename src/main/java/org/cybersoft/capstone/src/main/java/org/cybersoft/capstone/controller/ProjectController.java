package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.config.CustomServlet;
import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.service.ProjectService;
import org.cybersoft.capstone.service.impl.ProjectServiceImpl;
import org.cybersoft.capstone.util.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.List;

@WebServlet(
        name = "projectController",
        urlPatterns = {"/groupwork", "/groupwork/*", "/groupwork-add", "/groupwork-details/*"}
)
public class ProjectController extends CustomServlet {
    private final ProjectService projectService = new ProjectServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        if ("/groupwork".equals(path)) {
            this.getProjects(req);
        }
        Utils.navigate(req, resp);
    }

    @Override
    protected void doGetDetail(HttpServletRequest req, HttpServletResponse resp, Integer pathParameter) throws ServletException, IOException {
        String path = req.getServletPath();
        this.getProject(req, pathParameter);

        switch (path) {
            case "/groupwork":
                req.getRequestDispatcher("/groupwork-edit.jsp")
                        .forward(req, resp);
                break;
            case "/groupwork-details":
                req.getRequestDispatcher("/groupwork-details.jsp")
                        .forward(req, resp);
                break;
            default:
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ProjectDTO projectDTO = this.getParametersToDTO(req);
        Boolean isCreated = this.projectService.createProject(projectDTO);

        if (isCreated) {
            resp.sendRedirect(req.getContextPath() + "/groupwork");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp, Integer pathParameter) throws IOException {
        ProjectDTO projectDTO = this.getParametersToDTO(req);
        Boolean isUpdated = this.projectService.updateProject(pathParameter, projectDTO);

        if (isUpdated) {
            resp.sendRedirect(req.getContextPath() + "/groupwork");
        }
    }

    private void getProjects(HttpServletRequest req) {
        List<ProjectEntity> projects = this.projectService.getProjects();
        req.setAttribute("projects", projects);
    }

    private void getProject(HttpServletRequest req, Integer id) {
        ProjectEntity project = this.projectService.getProject(id);
        req.setAttribute("project", project);
    }

    private ProjectDTO getParametersToDTO(HttpServletRequest req) {
        String name = req.getParameter("name");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        return new ProjectDTO(
                name,
                Utils.parseStringToTimeStamp(startDate, LocalTime.MIN),
                Utils.parseStringToTimeStamp(endDate, LocalTime.MAX)
        );
    }
}
