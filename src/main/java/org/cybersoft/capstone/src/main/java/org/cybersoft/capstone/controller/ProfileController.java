package org.cybersoft.capstone.controller;

import org.cybersoft.capstone.config.CustomServlet;
import org.cybersoft.capstone.dto.ProfileDTO;
import org.cybersoft.capstone.entity.ProfileEntity;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.mapper.StatisticMapper;
import org.cybersoft.capstone.payload.response.ProjectStatResponse;
import org.cybersoft.capstone.service.ProfileService;
import org.cybersoft.capstone.service.UserService;
import org.cybersoft.capstone.service.impl.ProfileServiceImpl;
import org.cybersoft.capstone.service.impl.UserServiceImpl;
import org.cybersoft.capstone.util.SessionUtil;
import org.cybersoft.capstone.util.Utils;
import org.cybersoft.capstone.validation.ProfileRequest;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "profileController", urlPatterns = {"/profile", "/profile-edit", "/profile-edit/*"})
public class ProfileController extends CustomServlet {
    private final ProfileRequest profileRequest = new ProfileRequest();
    private final StatisticMapper statisticMapper = new StatisticMapper();
    private final ProfileService profileService = new ProfileServiceImpl();
    private final UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String path = req.getServletPath();
        SessionUtil sessionUtil = SessionUtil.getInstance();
        Object userId = sessionUtil.getValue(req, "userId");
        Integer id = Integer.parseInt(String.valueOf(userId));

        if (path.equals("/profile")) {
            this.getProfile(req, id);
        } else if (path.equals("/profile-edit")) {
            this.getUserDetail(req, id);
        }

        Utils.navigate(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProfileDTO profileDTO = this.profileRequest.getParameter(req, resp);
        Integer pathParameter = Integer.parseInt(String.valueOf(req.getParameter("pathParameter")));

        if (profileDTO == null) {
            this.getUserDetail(req, pathParameter);
            req.getRequestDispatcher("/profile-edit.jsp")
                    .forward(req, resp);
            return;
        }

        Boolean isUpdated = this.profileService.updateProfile(profileDTO, pathParameter);

        if (isUpdated) {
            resp.sendRedirect(req.getContextPath() + "/profile-edit");
        }
    }

    private void getProfile(HttpServletRequest req, Integer userId) {
        ProfileEntity profile = this.profileService.getProfile(userId);
        List<StatusEntity> statuses = this.profileService.getStatProfile(userId);

        ProjectStatResponse profileStat = this.statisticMapper.statusEntityToResponse(statuses);

        req.setAttribute("profileStat", profileStat);
        req.setAttribute("profile", profile);
    }

    private void getUserDetail(HttpServletRequest req, Integer userId) {
        UserEntity user = this.userService.getUser(userId);
        req.setAttribute("user", user);
    }
}
