package org.cybersoft.capstone.entity;

public class RoleDetailEntity {
    private Integer id;
    private String action;
    private String actionName;
    private String actionCode;
    private Boolean checkAction;
    private String url;
    private String method;
    private Integer order;
    private RoleEntity role;

    public RoleDetailEntity() {
    }

    public RoleDetailEntity(Integer id, String action, String actionName, String actionCode, String url, String method, RoleEntity role) {
        this.id = id;
        this.action = action;
        this.actionName = actionName;
        this.actionCode = actionCode;
        this.url = url;
        this.method = method;
        this.role = role;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    public String getActionCode() {
        return actionCode;
    }

    public void setActionCode(String actionCode) {
        this.actionCode = actionCode;
    }

    public Boolean getCheckAction() {
        return checkAction;
    }

    public void setCheckAction(Boolean checkAction) {
        this.checkAction = checkAction;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }
}
