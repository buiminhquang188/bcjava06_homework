package org.cybersoft.capstone.payload.response;

public class LoginResponse {
    private Integer id;
    private Boolean isValid;

    public LoginResponse(Integer id, Boolean isValid) {
        this.id = id;
        this.isValid = isValid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }
}
