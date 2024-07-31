package org.cybersoft.capstone.validation;

import org.cybersoft.capstone.constant.Validation;
import org.cybersoft.capstone.dto.TaskDTO;
import org.cybersoft.capstone.dto.TaskProgressDTO;
import org.cybersoft.capstone.mapper.TaskMapper;
import org.cybersoft.capstone.util.Utils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;
import java.util.HashMap;

public class TaskRequest {
    private final TaskMapper taskMapper = new TaskMapper();

    public TaskDTO getParameter(HttpServletRequest req) {
        HashMap<String, String> errors = new HashMap<>();

        String name = req.getParameter("name");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String projectId = req.getParameter("projectId");
        String userIdTask = req.getParameter("userIdTask");
        String statusId = req.getParameter("statusId");

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

        if (projectId == null || projectId.isEmpty() || projectId.isBlank()) {
            errors.put("projectId", Validation.IS_REQUIRED.getText("Project"));
        } else {
            req.setAttribute("projectId", projectId);
        }

        if (userIdTask == null || userIdTask.isEmpty() || userIdTask.isBlank()) {
            errors.put("userIdTask", Validation.IS_REQUIRED.getText("User"));
        } else {
            req.setAttribute("userIdTask", userIdTask);
        }

        if (statusId == null || statusId.isEmpty() || statusId.isBlank()) {
            errors.put("statusId", Validation.IS_REQUIRED.getText("Status"));
        } else {
            req.setAttribute("statusId", statusId);
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            return null;
        }

        return this.taskMapper.taskParameterToDTO(name, startDate, endDate, projectId, userIdTask, statusId);
    }

    public TaskProgressDTO getParameterProgress(HttpServletRequest req) {
        HashMap<String, String> errors = new HashMap<>();

        String statusId = req.getParameter("statusId");

        if (statusId == null || statusId.isEmpty() || statusId.isBlank()) {
            errors.put("statusId", Validation.IS_REQUIRED.getText("Status"));
        } else {
            req.setAttribute("statusId", statusId);
        }

        if (!errors.isEmpty()) {
            req.setAttribute("errors", errors);
            return null;
        }

        return this.taskMapper.taskProgressParameterToDTO(statusId);
    }
}
