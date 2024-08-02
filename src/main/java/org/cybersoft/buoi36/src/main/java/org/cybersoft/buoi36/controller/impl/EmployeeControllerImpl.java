package org.cybersoft.buoi36.controller.impl;

import org.cybersoft.buoi36.controller.EmployeeController;
import org.cybersoft.buoi36.dto.EmployeeDTO;
import org.cybersoft.buoi36.entity.EmployeeEntity;
import org.cybersoft.buoi36.mapper.EmployeeMapper;
import org.cybersoft.buoi36.payload.request.Employee;
import org.cybersoft.buoi36.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeControllerImpl implements EmployeeController {
    private final EmployeeMapper employeeMapper;
    private final EmployeeService employeeService;

    public EmployeeControllerImpl(EmployeeMapper employeeMapper, EmployeeService employeeService) {
        this.employeeMapper = employeeMapper;
        this.employeeService = employeeService;
    }

    @Override
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        List<EmployeeEntity> employeeEntities = this.employeeService.getEmployees();
        return ResponseEntity.ok(
                this.employeeMapper.entitiesToDTO(employeeEntities)
        );
    }

    @Override
    public ResponseEntity<EmployeeDTO> getEmployee(Long id) {
        EmployeeEntity employee = this.employeeService.getEmployee(id);
        if (employee == null) return ResponseEntity.notFound()
                .build();

        return ResponseEntity.ok(
                this.employeeMapper.entityToDTO(employee)

        );
    }

    @Override
    public ResponseEntity<EmployeeDTO> createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = this.employeeService.createEmployee(employee);
        if (employeeEntity == null) return ResponseEntity.notFound()
                .build();

        return new ResponseEntity<>(
                this.employeeMapper.entityToDTO(employeeEntity),
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<EmployeeDTO> updateEmployee(Long id, Employee employee) {
        EmployeeEntity employeeEntity = this.employeeService.updateEmployee(id, employee);
        if (employeeEntity == null) return ResponseEntity.notFound()
                .build();

        return ResponseEntity.ok(
                this.employeeMapper.entityToDTO(employeeEntity)
        );
    }

    @Override
    public ResponseEntity<String> deleteEmployee(Long id) {
        EmployeeEntity employeeEntity = this.employeeService.deleteEmployee(id);
        if (employeeEntity == null) return ResponseEntity.notFound()
                .build();

        return ResponseEntity.ok("Delete Employee Success");
    }
}
