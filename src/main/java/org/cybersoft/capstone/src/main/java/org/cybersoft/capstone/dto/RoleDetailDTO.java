package org.cybersoft.capstone.dto;

import java.util.List;

public class RoleDetailDTO {
    private String name;
    private String action;
    private String url;
    private List<String> actionCode;

    public RoleDetailDTO() {
    }

    public RoleDetailDTO(String name, String action, String url, List<String> actionCode) {
        this.name = name;
        this.action = action;
        this.url = url;
        this.actionCode = actionCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
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
