package org.cybersoft.buoi36.dto;

import java.util.List;

public class DepartmentDTO extends BaseDepartmentDTO {
    private List<Long> employeeIds;

    public DepartmentDTO(Long id, String name, String description, List<Long> employeeIds) {
        super(id, name, description);
        this.employeeIds = employeeIds;
    }

    public List<Long> getEmployeeIds() {
        return employeeIds;
    }

    public void setEmployeeIds(List<Long> employeeIds) {
        this.employeeIds = employeeIds;
    }
}
