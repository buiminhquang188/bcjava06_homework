package org.cybersoft.capstone.entity;

import java.sql.Timestamp;

public class TaskEntity {
    private Integer id;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private ProjectEntity project;
    private UserEntity user;
    private StatusEntity status;

    public TaskEntity() {

    }

    public TaskEntity(String name, Timestamp startDate, Timestamp endDate) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TaskEntity(Integer id, String name, Timestamp startDate, Timestamp endDate) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public ProjectEntity getProject() {
        return project;
    }

    public void setProject(ProjectEntity project) {
        this.project = project;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public StatusEntity getStatus() {
        return status;
    }

    public void setStatus(StatusEntity status) {
        this.status = status;
    }
}
