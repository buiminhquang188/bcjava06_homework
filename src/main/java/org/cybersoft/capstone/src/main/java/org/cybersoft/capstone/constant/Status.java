package org.cybersoft.capstone.constant;

public enum Status {
    SUCCESS("Success", 200), FAILED("Failed", 400);

    private String status;
    private Integer statusCode;

    Status(String status, Integer statusCode) {
        this.status = status;
        this.statusCode = statusCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }
}
