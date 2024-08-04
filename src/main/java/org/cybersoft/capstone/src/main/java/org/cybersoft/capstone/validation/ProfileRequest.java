package org.cybersoft.capstone.validation;

import org.cybersoft.capstone.constant.Validation;
import org.cybersoft.capstone.dto.ProfileDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class ProfileRequest {
    public ProfileDTO getParameter(HttpServletRequest req, HttpServletResponse resp) {
        HashMap<String, String> errors = new HashMap<>();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String password = req.getParameter("password");
        String phoneNumber = req.getParameter("phoneNumber");

        if (firstName.isEmpty() || firstName.isBlank()) {
            errors.put("firstName", Validation.IS_REQUIRED.getText("First name"));
        } else {
            req.setAttribute("firstName", firstName);
        }

        if (lastName.isEmpty() || lastName.isBlank()) {
            errors.put("lastName", Validation.IS_REQUIRED.getText("Last name"));
        } else {
            req.setAttribute("lastName", lastName);
        }

        if (phoneNumber.isEmpty() || phoneNumber.isBlank()) {
            errors.put("phoneNumber", Validation.IS_REQUIRED.getText("Phone number"));
        } else {
            req.setAttribute("phoneNumber", phoneNumber);
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            return null;
        }

        if (password == null || password.isEmpty() || password.isBlank()) {
            password = null;
        }

        return new ProfileDTO(firstName, lastName, password, phoneNumber);
    }
}
