package org.cybersoft.capstone.validation;

import org.cybersoft.capstone.constant.Action;
import org.cybersoft.capstone.dto.AuthorizationDTO;
import org.cybersoft.capstone.mapper.AuthorizationMapper;

import javax.servlet.http.HttpServletRequest;

public class AuthorizationRequest {
    private final AuthorizationMapper authorizationMapper = new AuthorizationMapper();

    public AuthorizationDTO getAuthorizationDTO(HttpServletRequest request, Integer userId) {
        String customMethod = request.getParameter("_method");
        String url = request.getServletPath();
        String pathInfo = request.getPathInfo();
        String method = request.getMethod();

        AuthorizationDTO authorizationDTO = null;

        if (pathInfo != null) {
            String fullPath = url + "/*";
            authorizationDTO = this.authorizationMapper.toDTO(
                    userId,
                    method,
                    fullPath,
                    Action.ACTIVE.ordinal(),
                    Action.ACTIVE.ordinal()
            );
        } else {
            authorizationDTO = this.authorizationMapper.toDTO(
                    userId,
                    method,
                    url,
                    Action.ACTIVE.ordinal(),
                    Action.ACTIVE.ordinal()
            );
        }

        if (customMethod != null) authorizationDTO.setMethod(customMethod);

        return authorizationDTO;
    }

    public AuthorizationDTO getAuthorizationDTO(HttpServletRequest request, Integer userId, String method) {
        String url = request.getServletPath();
        String pathInfo = request.getPathInfo();

        AuthorizationDTO authorizationDTO = null;

        if (pathInfo != null) {
            String fullPath = url + "/*";
            authorizationDTO = this.authorizationMapper.toDTO(
                    userId,
                    method,
                    fullPath,
                    Action.ACTIVE.ordinal(),
                    Action.ACTIVE.ordinal()
            );
        } else {
            authorizationDTO = this.authorizationMapper.toDTO(
                    userId,
                    method,
                    url,
                    Action.ACTIVE.ordinal(),
                    Action.ACTIVE.ordinal()
            );
        }

        return authorizationDTO;
    }
}
