package org.cybersoft.capstone.mapper;

import org.cybersoft.capstone.dto.LoginDTO;

import javax.servlet.http.HttpServletRequest;

public class LoginMapper {
    public LoginDTO loginParameterToDTO(HttpServletRequest req) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        return new LoginDTO(username, password);
    }
}
