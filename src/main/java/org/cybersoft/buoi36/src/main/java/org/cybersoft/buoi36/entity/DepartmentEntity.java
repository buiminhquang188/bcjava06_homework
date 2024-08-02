package org.cybersoft.buoi36.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "department")
public class DepartmentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "department")
    private List<EmployeeEntity> employees;

    public DepartmentEntity() {
    }

    public DepartmentEntity(Long id) {
        this.id = id;
    }

    public DepartmentEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public DepartmentEntity(String name, String description, List<EmployeeEntity> employees) {
        this.name = name;
        this.description = description;
        this.employees = employees;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<EmployeeEntity> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeEntity> employees) {
        this.employees = employees;
    }
}
