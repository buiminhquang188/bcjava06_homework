package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.entity.ProfileEntity;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.mapper.StatisticMapper;
import org.cybersoft.capstone.payload.response.ProjectStatResponse;
import org.cybersoft.capstone.service.ProfileService;
import org.cybersoft.capstone.service.impl.ProfileServiceImpl;
import org.cybersoft.capstone.util.Utils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "profileController", urlPatterns = {"/profile", "/profile-edit"})
public class ProfileController extends HttpServlet {
    private final StatisticMapper statisticMapper = new StatisticMapper();
    private final ProfileService profileService = new ProfileServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();

        switch (path) {
            case "/profile":
                this.getProfile(req);
                break;
            case "/profile-edit":
                break;
            default:
                break;
        }

        Utils.navigate(req, resp);
    }

    private void getProfile(HttpServletRequest req) {
        ServletContext servletContext = this.getServletConfig()
                .getServletContext();
        Object userId = servletContext.getAttribute("userId");
        Integer id = Integer.parseInt(String.valueOf(userId));

        ProfileEntity profile = this.profileService.getProfile(id);
        List<StatusEntity> statuses = this.profileService.getStatProfile(id);

        ProjectStatResponse profileStat = this.statisticMapper.statusEntityToResponse(statuses);

        req.setAttribute("profileStat", profileStat);
        req.setAttribute("profile", profile);
    }
}
