package org.cybersoft.buoi36.service;

import org.cybersoft.buoi36.entity.EmployeeEntity;
import org.cybersoft.buoi36.payload.request.Employee;

import java.util.List;

public interface EmployeeService {
    List<EmployeeEntity> getEmployees();

    EmployeeEntity getEmployee(Long id);

    EmployeeEntity createEmployee(Employee employee);

    EmployeeEntity updateEmployee(Long id, Employee employee);

    EmployeeEntity deleteEmployee(Long id);
}
