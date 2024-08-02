package org.cybersoft.capstone.validation;

import org.cybersoft.capstone.constant.Validation;
import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.mapper.ProjectMapper;
import org.cybersoft.capstone.util.Utils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;
import java.util.HashMap;

public class ProjectRequest {
    private final ProjectMapper projectMapper = new ProjectMapper();

    public ProjectDTO getParameter(HttpServletRequest req) {
        HashMap<String, String> errors = new HashMap<>();

        String name = req.getParameter("name");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String userIdProject = req.getParameter("userIdProject");

        if (name.isEmpty() || name.isBlank()) {
            errors.put("name", Validation.IS_REQUIRED.getText("Name"));
        } else {
            req.setAttribute("name", name);
        }

        if (startDate.isEmpty() || startDate.isBlank()) {
            errors.put("startDate", Validation.IS_REQUIRED.getText("Start Date"));
        } else {
            req.setAttribute("startDate", Utils.parseStringToTimeStamp(startDate, LocalTime.MIN));
        }

        if (endDate.isEmpty() || endDate.isBlank()) {
            errors.put("endDate", Validation.IS_REQUIRED.getText("End Date"));
        } else {
            req.setAttribute("endDate", Utils.parseStringToTimeStamp(endDate, LocalTime.MAX));
        }

        if (!startDate.isEmpty() && !endDate.isEmpty()) {
            Boolean isValidRangeDate = Utils.isValidRangeDate(Utils.parseStringToTimeStamp(startDate, LocalTime.MIN), Utils.parseStringToTimeStamp(endDate, LocalTime.MAX));

            if (!isValidRangeDate) errors.put("rangeDate", "End date must after start date");
            req.setAttribute("startDate", Utils.parseStringToTimeStamp(startDate, LocalTime.MIN));
            req.setAttribute("endDate", Utils.parseStringToTimeStamp(endDate, LocalTime.MAX));
        }

        if (userIdProject == null || userIdProject.isEmpty() || userIdProject.isEmpty()) {
            errors.put("userIdProject", Validation.IS_REQUIRED.getText("Project Manager"));
        } else {
            req.setAttribute("userIdProject", userIdProject);
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            return null;
        }

        return this.projectMapper.parameterToDTO(name, startDate, endDate, userIdProject);
    }
}
