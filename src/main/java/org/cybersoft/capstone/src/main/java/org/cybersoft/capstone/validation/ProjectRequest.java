package org.cybersoft.capstone.validation;

import org.cybersoft.capstone.constant.Validation;
import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.mapper.ProjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class ProjectRequest {
    private final ProjectMapper projectMapper = new ProjectMapper();

    public ProjectDTO getParameter(HttpServletRequest req) {
        HashMap<String, String> errors = new HashMap<>();

        String name = req.getParameter("name");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");

        if (name.isEmpty() || name.isBlank()) {
            errors.put("name", Validation.IS_REQUIRED.getText("Name"));
        }

        if (startDate.isEmpty() || startDate.isBlank()) {
            errors.put("startDate", Validation.IS_REQUIRED.getText("Start Date"));
        }

        if (endDate.isEmpty() || endDate.isBlank()) {
            errors.put("endDate", Validation.IS_REQUIRED.getText("End Date"));
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            return null;
        }

        return this.projectMapper.parameterToDTO(name, startDate, endDate);
    }
}
