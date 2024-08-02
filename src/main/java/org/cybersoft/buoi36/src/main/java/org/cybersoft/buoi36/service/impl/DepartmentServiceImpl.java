package org.cybersoft.buoi36.service.impl;

import org.cybersoft.buoi36.entity.DepartmentEntity;
import org.cybersoft.buoi36.entity.EmployeeEntity;
import org.cybersoft.buoi36.payload.request.Department;
import org.cybersoft.buoi36.repository.DepartmentRepository;
import org.cybersoft.buoi36.repository.EmployeeRepository;
import org.cybersoft.buoi36.service.DepartmentService;
import org.cybersoft.buoi36.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    private final EmployeeService employeeService;

    private final EmployeeRepository employeeRepository;

    public DepartmentServiceImpl(DepartmentRepository departmentRepository, EmployeeService employeeService, EmployeeRepository employeeRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeService = employeeService;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<DepartmentEntity> getDepartments() {
        return this.departmentRepository.findAll();
    }

    @Override
    public DepartmentEntity getDepartment(Long id) {
        return this.departmentRepository.findById(id)
                .orElse(null);
    }

    @Override
    public DepartmentEntity createDepartment(Department department) {
        DepartmentEntity departmentEntity = new DepartmentEntity(
                department.name(),
                department.description()
        );

        if (department.employeeIds() != null && !department.employeeIds()
                .isEmpty()) {
            List<EmployeeEntity> employeeEntities = department.employeeIds()
                    .stream()
                    .map(this.employeeService::getEmployee)
                    .filter(Objects::nonNull)
                    .peek(employeeEntity -> employeeEntity.setDepartment(departmentEntity))
                    .collect(Collectors.toList());
            departmentEntity.setEmployees(employeeEntities);
        }

        return this.departmentRepository.save(departmentEntity);
    }

    @Override
    public DepartmentEntity updateDepartment(Long id, Department department) {
        DepartmentEntity departmentEntity = this.getDepartment(id);

        if (departmentEntity == null) return null;

        departmentEntity.setName(department.name());
        departmentEntity.setDescription(department.description());

        if (department.employeeIds() != null && !department.employeeIds()
                .isEmpty()) {
            List<EmployeeEntity> employeeEntities = this.employeeRepository.findAllByIdInOrDepartmentId(department.employeeIds(), departmentEntity.getId());
            employeeEntities.forEach(employeeEntity -> {
                        if (!department.employeeIds()
                                .contains(employeeEntity.getId())) {
                            employeeEntity.setDepartment(null);
                            return;
                        }
                        employeeEntity.setDepartment(departmentEntity);
                    }
            );
            departmentEntity.setEmployees(employeeEntities);
        }
        return this.departmentRepository.save(departmentEntity);
    }

    @Override
    public DepartmentEntity deleteDepartment(Long id) {
        DepartmentEntity departmentEntity = this.getDepartment(id);

        if (departmentEntity == null) return null;

        departmentEntity.getEmployees()
                .forEach(employee -> employee.setDepartment(null));

        this.departmentRepository.delete(departmentEntity);

        return departmentEntity;
    }
}
