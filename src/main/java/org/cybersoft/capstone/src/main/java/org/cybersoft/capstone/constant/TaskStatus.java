package org.cybersoft.capstone.constant;

public enum TaskStatus {
    COMPLETED(1),
    IN_PROGRESS(2),
    NOT_STARTED(3);

    private Integer id;

    TaskStatus(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
