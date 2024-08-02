package org.cybersoft.buoi36.mapper;

import org.cybersoft.buoi36.dto.BaseDepartmentDTO;
import org.cybersoft.buoi36.dto.DepartmentDTO;
import org.cybersoft.buoi36.entity.DepartmentEntity;
import org.cybersoft.buoi36.entity.EmployeeEntity;
import org.cybersoft.buoi36.payload.request.Department;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentMapper implements IMapper<DepartmentEntity, BaseDepartmentDTO> {
    @Override
    public List<BaseDepartmentDTO> entitiesToDTO(List<DepartmentEntity> departmentEntities) {
        return departmentEntities.stream()
                .map(departmentEntity -> new BaseDepartmentDTO(
                        departmentEntity.getId(),
                        departmentEntity.getName(),
                        departmentEntity.getDescription()
                ))
                .toList();
    }

    @Override
    public DepartmentDTO entityToDTO(DepartmentEntity departmentEntity) {
        if (departmentEntity == null) return null;

        return new DepartmentDTO(
                departmentEntity.getId(),
                departmentEntity.getName(),
                departmentEntity.getDescription(),
                departmentEntity.getEmployees()
                        .stream()
                        .map(EmployeeEntity::getId)
                        .toList()
        );
    }

    public DepartmentDTO entityToDTO(DepartmentEntity departmentEntity, Department department) {
        if (departmentEntity == null) return null;

        return new DepartmentDTO(
                departmentEntity.getId(),
                departmentEntity.getName(),
                departmentEntity.getDescription(),
                departmentEntity.getEmployees()
                        .stream()
                        .map(EmployeeEntity::getId)
                        .filter(employeeIds -> department.employeeIds()
                                .contains(employeeIds))
                        .toList()
        );
    }
}
