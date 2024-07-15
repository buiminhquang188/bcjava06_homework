package org.cybersoft.capstone.entity;

import java.util.ArrayList;
import java.util.List;

public class ProfileEntity {
    private UserEntity user;
    private List<TaskEntity> tasks = new ArrayList<>();

    public ProfileEntity() {
    }

    public ProfileEntity(UserEntity user, List<TaskEntity> tasks) {
        this.user = user;
        this.tasks = tasks;
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
