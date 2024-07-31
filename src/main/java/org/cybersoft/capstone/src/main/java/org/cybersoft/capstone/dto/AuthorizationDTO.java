package org.cybersoft.capstone.dto;

public class AuthorizationDTO {
    private Integer id;
    private String method;
    private String url;
    private Integer licensed;
    private Integer checkAction;

    public AuthorizationDTO(Integer id, String method, String url, Integer licensed, Integer checkAction) {
        this.id = id;
        this.method = method;
        this.url = url;
        this.licensed = licensed;
        this.checkAction = checkAction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getLicensed() {
        return licensed;
    }

    public void setLicensed(Integer licensed) {
        this.licensed = licensed;
    }

    public Integer getCheckAction() {
        return checkAction;
    }

    public void setCheckAction(Integer checkAction) {
        this.checkAction = checkAction;
    }
}
