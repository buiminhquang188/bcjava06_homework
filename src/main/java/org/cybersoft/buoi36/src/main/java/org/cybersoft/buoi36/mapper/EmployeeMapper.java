package org.cybersoft.buoi36.mapper;

import org.cybersoft.buoi36.dto.EmployeeDTO;
import org.cybersoft.buoi36.entity.DepartmentEntity;
import org.cybersoft.buoi36.entity.EmployeeEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeMapper implements IMapper<EmployeeEntity, EmployeeDTO> {
    @Override
    public List<EmployeeDTO> entitiesToDTO(List<EmployeeEntity> employeeEntities) {


        return employeeEntities.stream()
                .map(employeeEntity ->
                        new EmployeeDTO(
                                employeeEntity.getId(),
                                employeeEntity.getName(),
                                employeeEntity.getPhoneNumber(),
                                Optional.ofNullable(employeeEntity.getDepartment())
                                        .map(DepartmentEntity::getId)
                                        .orElse(null)
                        )
                )
                .toList();
    }

    @Override
    public EmployeeDTO entityToDTO(EmployeeEntity employeeEntity) {
        if (employeeEntity == null) return null;

        return new EmployeeDTO(
                employeeEntity.getId(),
                employeeEntity.getName(),
                employeeEntity.getPhoneNumber(),
                Optional.ofNullable(employeeEntity.getDepartment())
                        .map(DepartmentEntity::getId)
                        .orElse(null)
        );
    }
}
