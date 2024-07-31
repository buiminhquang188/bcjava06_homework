package org.cybersoft.capstone.config;

import org.cybersoft.capstone.dto.AuthorizationDTO;
import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.service.AuthorizationService;
import org.cybersoft.capstone.service.impl.AuthorizationServiceImpl;
import org.cybersoft.capstone.util.Utils;
import org.cybersoft.capstone.validation.AuthorizationRequest;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ResourceBundle;

public abstract class CustomServlet extends HttpServlet {
    private final AuthorizationRequest authorizationRequest = new AuthorizationRequest();
    private final AuthorizationService authorizationService = new AuthorizationServiceImpl();
    private static ResourceBundle lStrings = ResourceBundle.getBundle("javax.servlet.http.LocalStrings");

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Integer pathParameter = Utils.getPathParameter(req);
        String customMethod = req.getParameter("_method");

        if (!req.getHttpServletMapping()
                .getPattern()
                .contains("/*") && pathParameter == null) {
            super.service(req, resp);
            return;
        }

        if (customMethod != null && customMethod.equals("PUT")) {
            this.doPut(req, resp, pathParameter);
            return;
        }

        RoleDetailDTO roleDetailEntity = this.doGetAuthorization(req, Utils.getUserSessionId(req));
        req.setAttribute("roleDetail", roleDetailEntity);
        this.doGetDetail(req, resp, pathParameter);
    }

    protected void doGetDetail(HttpServletRequest req, HttpServletResponse resp, Integer pathParameter) throws ServletException, IOException {
        String protocol = req.getProtocol();
        String msg = lStrings.getString("http.method_get_not_supported");
        if (protocol.endsWith("1.1")) {
            resp.sendError(405, msg);
        } else {
            resp.sendError(400, msg);
        }
    }

    protected void doPut(HttpServletRequest req, HttpServletResponse resp, Integer pathParameter) throws ServletException, IOException {

    }

    protected RoleDetailDTO doGetAuthorization(HttpServletRequest req, Integer userId) {
        AuthorizationDTO authorizationDTO = this.authorizationRequest.getAuthorizationDTO(req, userId, "PUT");
        return this.authorizationService.getAuthorizationByUserId(authorizationDTO);
    }
}
