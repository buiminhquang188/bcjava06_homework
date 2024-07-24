package org.cybersoft.capstone.mapper;

import org.cybersoft.capstone.dto.TaskDTO;
import org.cybersoft.capstone.util.Utils;

import java.time.LocalTime;

public class TaskMapper {
    public TaskDTO taskParameterToDTO(String name, String startDate, String endDate, String projectId, String userId, String statusId) {
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
