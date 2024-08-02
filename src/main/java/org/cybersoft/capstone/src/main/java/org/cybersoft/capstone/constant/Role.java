package org.cybersoft.capstone.constant;

public enum Role {
    ADMIN(1),
    USER(2),
    LEADER(3);
    private final Integer id;

    Role(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
