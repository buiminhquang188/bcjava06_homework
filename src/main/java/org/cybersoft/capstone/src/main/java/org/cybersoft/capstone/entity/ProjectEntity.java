package org.cybersoft.capstone.entity;

import java.sql.Timestamp;

public class ProjectEntity {
    private Integer id;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;

    public ProjectEntity(String name) {
        this.name = name;
    }

    public ProjectEntity(Integer id, String name, Timestamp startDate, Timestamp endDate) {
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
}
