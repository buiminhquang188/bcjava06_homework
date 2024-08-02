package org.cybersoft.capstone.mapper;

import org.cybersoft.capstone.constant.TaskStatus;
import org.cybersoft.capstone.entity.StatusEntity;
import org.cybersoft.capstone.payload.response.ProjectStatResponse;

import java.util.List;

public class StatisticMapper {
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
