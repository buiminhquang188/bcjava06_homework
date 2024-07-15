package org.cybersoft.capstone.mapper;

import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.entity.TaskEntity;
import org.cybersoft.capstone.payload.response.ProjectDetailResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProjectMapper {
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
