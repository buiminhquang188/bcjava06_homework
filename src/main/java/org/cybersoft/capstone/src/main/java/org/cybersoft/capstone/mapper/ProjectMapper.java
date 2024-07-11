package org.cybersoft.capstone.mapper;

import org.cybersoft.capstone.constant.TaskStatus;
import org.cybersoft.capstone.entity.ProjectEntity;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.entity.TaskEntity;
import org.cybersoft.capstone.payload.response.ProjectDetailResponse;
import org.cybersoft.capstone.payload.response.ProjectStatResponse;

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

    public ProjectStatResponse statusEntityToResponse(List<StatusEntity> statuses) {
        ProjectStatResponse projectStatResponse = new ProjectStatResponse();
        statuses.forEach(status -> {
            if (status.getId()
                    .equals(TaskStatus.COMPLETED.getId())) {
                projectStatResponse.setCompleted(status.getTotal());
            }
            if (status.getId()
                    .equals(TaskStatus.IN_PROGRESS.getId())) {
                projectStatResponse.setInProgress(status.getTotal());
            }
            if (status.getId()
                    .equals(TaskStatus.NOT_STARTED.getId())) {
                projectStatResponse.setNotStarted(status.getTotal());
            }
        });

        projectStatResponse.setTotal(
                projectStatResponse.getCompleted() + projectStatResponse.getInProgress() + projectStatResponse.getNotStarted()
        );

        return projectStatResponse;
    }
}
