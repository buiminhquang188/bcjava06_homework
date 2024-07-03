package org.cybersoft.capstone.entity;

public class StatusEntity {
    private Integer id;
    private String name;

    public StatusEntity(String name) {
        this.name = name;
    }

    public StatusEntity(Integer id) {
        this.id = id;
    }

    public StatusEntity(Integer id, String name) {
        this.id = id;
        this.name = name;
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
}
