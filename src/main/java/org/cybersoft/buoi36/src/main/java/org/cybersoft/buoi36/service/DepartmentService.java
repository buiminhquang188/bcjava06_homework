package org.cybersoft.buoi36.service;

import org.cybersoft.buoi36.entity.DepartmentEntity;
import org.cybersoft.buoi36.payload.request.Department;

import java.util.List;

public interface DepartmentService {
    List<DepartmentEntity> getDepartments();

    DepartmentEntity getDepartment(Long id);

    DepartmentEntity createDepartment(Department department);

    DepartmentEntity updateDepartment(Long id, Department department);

    DepartmentEntity deleteDepartment(Long id);
}
