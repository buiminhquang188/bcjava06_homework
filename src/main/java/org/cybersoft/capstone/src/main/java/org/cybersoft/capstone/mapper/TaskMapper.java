package org.cybersoft.capstone.mapper;

import org.cybersoft.capstone.dto.TaskDTO;
import org.cybersoft.capstone.util.Utils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalTime;

public class TaskMapper {
    public TaskDTO taskParameterToDTO(HttpServletRequest req) {
        String name = req.getParameter("name");
        String startDate = req.getParameter("startDate");
        String endDate = req.getParameter("endDate");
        String projectId = req.getParameter("projectId");
        String userId = req.getParameter("userId");
        String statusId = req.getParameter("statusId");

        return new TaskDTO(
                name,
                Utils.parseStringToTimeStamp(startDate, LocalTime.MIN),
                Utils.parseStringToTimeStamp(endDate, LocalTime.MAX),
                Utils.parseStringToInt(projectId),
                Utils.parseStringToInt(userId),
                Utils.parseStringToInt(statusId)
        );
    }
}
