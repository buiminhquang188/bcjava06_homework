package org.cybersoft.buoi36.dto;

public class EmployeeDTO {
    private Long id;
    private String name;
    private String phoneNumber;

    private Long departmentId;

    public EmployeeDTO(Long id, String name, String phoneNumber, Long departmentId) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.departmentId = departmentId;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }
}
