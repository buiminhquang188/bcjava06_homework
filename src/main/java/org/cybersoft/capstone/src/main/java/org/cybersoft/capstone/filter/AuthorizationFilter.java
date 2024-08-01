package org.cybersoft.capstone.filter;

import org.cybersoft.capstone.dto.AuthorizationDTO;
import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.service.AuthorizationService;
import org.cybersoft.capstone.service.impl.AuthorizationServiceImpl;
import org.cybersoft.capstone.util.SessionUtil;
import org.cybersoft.capstone.util.Utils;
import org.cybersoft.capstone.validation.AuthorizationRequest;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "authorizationFilter", urlPatterns = {"/", "/user-table", "/user-add", "/user-details/*", "/role-table", "/role-add", "/groupwork", "/groupwork-add", "/groupwork/*", "/groupwork-details/*", "/task", "/task-add", "/task/*", "/profile"})
public class AuthorizationFilter implements Filter {
    private final AuthorizationRequest authorizationRequest = new AuthorizationRequest();
    private final AuthorizationService authorizationService = new AuthorizationServiceImpl();

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("UTF-8");

        if (request.getPathInfo() != null && request.getPathInfo()
                .equals("/logout")) {
            filterChain.doFilter(request, response);
            return;
        }

        Integer userId = Utils.getUserSessionId(request);

        if (userId == null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        AuthorizationDTO authorizationDTO = this.authorizationRequest.getAuthorizationDTO(request, userId);
        RoleDetailDTO roleDetailDTO = (RoleDetailDTO) SessionUtil.getInstance()
                .getValue(request, "roleDetailDTO");

        if (roleDetailDTO == null) {
            roleDetailDTO = this.authorizationService.getAuthorizationByUserId(authorizationDTO);
            SessionUtil.getInstance()
                    .putValue(request, "roleDetailDTO", roleDetailDTO);
        }

        Boolean isValid = this.authorizationService.isValidAction(authorizationDTO);

        if (roleDetailDTO == null || !isValid) {
            response.sendRedirect(request.getContextPath() + "/404");
            return;
        }

        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
