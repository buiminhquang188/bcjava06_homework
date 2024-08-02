package org.cybersoft.capstone.entity;

public class StatusEntity {
    private Integer id;
    private String name;
    private Integer total;

    public StatusEntity(String name) {
        this.name = name;
    }

    public StatusEntity(Integer id) {
        this.id = id;
    }

    public StatusEntity(Integer id, String name, Integer total) {
        this.id = id;
        this.name = name;
        this.total = total;
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

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
