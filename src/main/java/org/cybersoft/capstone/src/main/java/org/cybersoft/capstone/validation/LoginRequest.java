package org.cybersoft.capstone.validation;

import org.cybersoft.capstone.constant.Validation;
import org.cybersoft.capstone.dto.LoginDTO;
import org.cybersoft.capstone.mapper.LoginMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class LoginRequest {
    private final LoginMapper loginMapper = new LoginMapper();

    public LoginDTO getParameter(HttpServletRequest req) {
        HashMap<String, String> errors = new HashMap<>();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.isEmpty() || username.isBlank()) {
            errors.put("username", Validation.IS_REQUIRED.getText("Username"));
        } else {
            req.setAttribute("username", username);
        }

        if (password.isEmpty() || password.isBlank()) {
            errors.put("password", Validation.IS_REQUIRED.getText("Password"));
        } else {
            req.setAttribute("password", password);
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            return null;
        }

        return this.loginMapper.loginParameterToDTO(username, password);
    }
}
