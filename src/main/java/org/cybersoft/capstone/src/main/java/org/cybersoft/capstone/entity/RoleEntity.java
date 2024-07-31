package org.cybersoft.capstone.entity;

import java.util.List;

public class RoleEntity {
    private Integer id;
    private String name;
    private String description;

    private List<RoleDetailEntity> roleDetails;

    public RoleEntity() {
    }

    public RoleEntity(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<RoleDetailEntity> getRoleDetails() {
        return roleDetails;
    }

    public void setRoleDetails(List<RoleDetailEntity> roleDetails) {
        this.roleDetails = roleDetails;
    }
}
