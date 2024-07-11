package org.cybersoft.capstone.payload.response;

import org.cybersoft.capstone.entity.TaskEntity;
import org.cybersoft.capstone.entity.UserEntity;

import java.util.List;

public class ProjectDetailResponse {
    private UserEntity user;
    private List<TaskEntity> tasks;

    public ProjectDetailResponse() {
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public List<TaskEntity> getTasks() {
        return tasks;
    }

    public void setTasks(List<TaskEntity> tasks) {
        this.tasks = tasks;
    }
}
