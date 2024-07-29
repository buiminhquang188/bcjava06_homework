package org.cybersoft.capstone.dto;

import java.sql.Timestamp;

public class ProjectDTO {
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer userIdProject;

    public ProjectDTO(String name, Timestamp startDate, Timestamp endDate, Integer userIdProject) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userIdProject = userIdProject;
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

    public Integer getUserIdProject() {
        return userIdProject;
    }

    public void setUserIdProject(Integer userIdProject) {
        this.userIdProject = userIdProject;
    }
}
