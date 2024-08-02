package org.cybersoft.buoi36.service.impl;

import org.cybersoft.buoi36.entity.DepartmentEntity;
import org.cybersoft.buoi36.entity.EmployeeEntity;
import org.cybersoft.buoi36.payload.request.Employee;
import org.cybersoft.buoi36.repository.DepartmentRepository;
import org.cybersoft.buoi36.repository.EmployeeRepository;
import org.cybersoft.buoi36.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @Override
    public List<EmployeeEntity> getEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public EmployeeEntity getEmployee(Long id) {
        return this.employeeRepository.findById(id)
                .orElse(null);
    }

    @Override
    public EmployeeEntity createEmployee(Employee employee) {
        DepartmentEntity departmentEntity = null;

        if (employee.departmentId() != null)
            departmentEntity = this.departmentRepository.findById(employee.departmentId())
                    .orElse(null);

        EmployeeEntity employeeEntity = new EmployeeEntity(
                employee.name(),
                employee.phoneNumber(),
                departmentEntity
        );


        return this.employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity updateEmployee(Long id, Employee employee) {
        DepartmentEntity departmentEntity = this.departmentRepository.findById(employee.departmentId())
                .orElse(null);
        if (departmentEntity == null) return null;

        EmployeeEntity employeeEntity = this.getEmployee(id);
        if (employeeEntity == null) return null;

        employeeEntity.setName(employee.name());
        employeeEntity.setPhoneNumber(employee.phoneNumber());
        employeeEntity.setDepartment(departmentEntity);

        return this.employeeRepository.save(employeeEntity);
    }

    @Override
    public EmployeeEntity deleteEmployee(Long id) {
        EmployeeEntity employeeEntity = this.getEmployee(id);

        if (employeeEntity == null) return null;

        this.employeeRepository.delete(employeeEntity);

        return employeeEntity;
    }
}
