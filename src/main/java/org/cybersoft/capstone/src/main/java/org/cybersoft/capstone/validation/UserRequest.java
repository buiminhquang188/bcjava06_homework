package org.cybersoft.capstone.validation;

import org.cybersoft.capstone.constant.Validation;
import org.cybersoft.capstone.dto.UserDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class UserRequest {
    public UserDTO getParameter(HttpServletRequest req, HttpServletResponse resp) {
        HashMap<String, String> errors = new HashMap<>();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String phoneNumber = req.getParameter("phoneNumber");
        String role = req.getParameter("role");

        if (firstName.isEmpty() || firstName.isBlank()) {
            errors.put("firstName", Validation.IS_REQUIRED.getText("First name"));
        }

        if (lastName.isEmpty() || lastName.isBlank()) {
            errors.put("lastName", Validation.IS_REQUIRED.getText("Last name"));
        }

        if (email.isEmpty() || email.isBlank()) {
            errors.put("email", Validation.IS_REQUIRED.getText("Email"));
        }

        if (password.isEmpty() || password.isBlank()) {
            errors.put("password", Validation.IS_REQUIRED.getText("Password"));
        }

        if (phoneNumber.isEmpty() || phoneNumber.isBlank()) {
            errors.put("phoneNumber", Validation.IS_REQUIRED.getText("Phone number"));
        }

        if (role == null || role.isEmpty() || role.isBlank()) {
            errors.put("role", Validation.IS_REQUIRED.getText("Role"));
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            return null;
        }

        return new UserDTO(firstName, lastName, email, password, phoneNumber, Integer.parseInt(role));
    }
}
