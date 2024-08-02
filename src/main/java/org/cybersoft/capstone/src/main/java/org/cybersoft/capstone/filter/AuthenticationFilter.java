package org.cybersoft.capstone.filter;

import org.cybersoft.capstone.util.SessionUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        SessionUtil sessionUtil = SessionUtil.getInstance();

        Object isValid = sessionUtil.getValue(request, "isValid");

        if (isValid != null) {
            isValid = isValid.toString();
        }

        String loginURI = request.getContextPath() + "/login";
        boolean loginRequest = request.getRequestURI()
                .equals(loginURI);

        if ("true".equals(isValid) | loginRequest) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
