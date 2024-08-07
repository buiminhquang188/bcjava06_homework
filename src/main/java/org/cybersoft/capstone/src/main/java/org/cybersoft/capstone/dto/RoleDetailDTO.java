package org.cybersoft.capstone.dto;

import java.util.List;

public class RoleDetailDTO {
    private Integer id;
    private String name;
    private String url;
    private List<String> actionCode;

    public RoleDetailDTO() {
    }

    public RoleDetailDTO(Integer id, String name, String url, List<String> actionCode) {
        this.id = id;
        this.name = name;
        this.url = url;
        this.actionCode = actionCode;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<String> getActionCode() {
        return actionCode;
    }

    public void setActionCode(List<String> actionCode) {
        this.actionCode = actionCode;
    }
}
