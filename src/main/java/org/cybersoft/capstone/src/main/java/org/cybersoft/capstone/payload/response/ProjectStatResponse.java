package org.cybersoft.capstone.payload.response;

public class ProjectStatResponse {
    private Integer notStarted = 0;
    private Integer inProgress = 0;
    private Integer completed = 0;
    private Integer total;

    public ProjectStatResponse() {

    }

    public ProjectStatResponse(Integer notStarted, Integer inProgress, Integer completed) {
        this.notStarted = notStarted;
        this.inProgress = inProgress;
        this.completed = completed;
    }

    public Integer getNotStarted() {
        return notStarted;
    }

    public void setNotStarted(Integer notStarted) {
        this.notStarted = notStarted;
    }

    public Integer getInProgress() {
        return inProgress;
    }

    public void setInProgress(Integer inProgress) {
        this.inProgress = inProgress;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
