package org.cybersoft.capstone.mapper;

import org.cybersoft.capstone.dto.ProjectDTO;
import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.entity.TaskEntity;
import org.cybersoft.capstone.payload.response.ProjectDetailResponse;
import org.cybersoft.capstone.util.Utils;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProjectMapper {
    public ProjectDTO parameterToDTO(String name, String startDate, String endDate, String userIdProject) {
        return new ProjectDTO(
                name,
                Utils.parseStringToTimeStamp(startDate, LocalTime.MIN),
                Utils.parseStringToTimeStamp(endDate, LocalTime.MAX),
                Integer.parseInt(userIdProject)
        );
    }

    public List<ProjectDetailResponse> projectEntitiesToResponse(List<ProjectEntity> projects) {
        List<ProjectDetailResponse> projectDetailResponses = new ArrayList<>();

        Map<Integer, List<ProjectEntity>> projectGroup = projects.stream()
                .collect(Collectors.groupingBy(projectEntity -> projectEntity.getUser()
                        .getId()));

        projectGroup.forEach((integer, projectEntities) -> {
            ProjectDetailResponse projectDetailResponse = new ProjectDetailResponse();
            projectDetailResponse.setUser(projectEntities.get(0)
                    .getUser());

            List<TaskEntity> tasks = projectEntities.stream()
                    .map(ProjectEntity::getTask)
                    .toList();

            projectDetailResponse.setTasks(tasks);
            projectDetailResponses.add(projectDetailResponse);
        });

        return projectDetailResponses;
    }
}
