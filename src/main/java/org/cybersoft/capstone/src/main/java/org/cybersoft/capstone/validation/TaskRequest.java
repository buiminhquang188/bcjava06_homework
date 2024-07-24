package org.cybersoft.capstone.validation;

import org.cybersoft.capstone.constant.Validation;
import org.cybersoft.capstone.dto.TaskDTO;
import org.cybersoft.capstone.mapper.TaskMapper;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public class TaskRequest {
    private final TaskMapper taskMapper = new TaskMapper();

    public TaskDTO getParameter(HttpServletRequest req) {
        HashMap<String, String> errors = new HashMap<>();

        String name = req.getParameter("name");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String projectId = req.getParameter("projectId");
        String userId = req.getParameter("userId");
        String statusId = req.getParameter("statusId");

        if (name.isEmpty() || name.isBlank()) {
            errors.put("name", Validation.IS_REQUIRED.getText("Name"));
        }

        if (startDate.isEmpty() || startDate.isBlank()) {
            errors.put("startDate", Validation.IS_REQUIRED.getText("Start Date"));
        }

        if (endDate.isEmpty() || endDate.isBlank()) {
            errors.put("endDate", Validation.IS_REQUIRED.getText("End Date"));
        }

        if (projectId == null || projectId.isEmpty() || projectId.isBlank()) {
            errors.put("projectId", Validation.IS_REQUIRED.getText("Project"));
        }

        if (userId == null || userId.isEmpty() || userId.isBlank()) {
            errors.put("userId", Validation.IS_REQUIRED.getText("User"));
        }

        if (statusId == null || statusId.isEmpty() || statusId.isBlank()) {
            errors.put("statusId", Validation.IS_REQUIRED.getText("Status"));
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            return null;
        }

        return this.taskMapper.taskParameterToDTO(name, startDate, endDate, projectId, userId, statusId);
    }
}
