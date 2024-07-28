package org.cybersoft.capstone.validation;

import org.cybersoft.capstone.constant.Validation;
import org.cybersoft.capstone.dto.RoleDTO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public class RoleRequest {
    public RoleDTO getParameter(HttpServletRequest req, HttpServletResponse resp) {
        HashMap<String, String> errors = new HashMap<>();
        String name = req.getParameter("name");
        String description = req.getParameter("description");

        if (name.isEmpty() || name.isBlank()) {
            errors.put("name", Validation.IS_REQUIRED.getText("Name"));
        } else {
            req.setAttribute("name", name);
        }

        if (description.isEmpty() || description.isBlank()) {
            errors.put("description", Validation.IS_REQUIRED.getText("Description"));
        } else {
            req.setAttribute("description", description);
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            return null;
        }

        return new RoleDTO(name, description);
    }
}
