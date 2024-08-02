package org.cybersoft.capstone.dto;

public class TaskProgressDTO {
    private Integer statusId;

    public TaskProgressDTO(Integer statusId) {
        this.statusId = statusId;
    }

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }
}
