package org.cybersoft.buoi36.controller;

import org.cybersoft.buoi36.dto.EmployeeDTO;
import org.cybersoft.buoi36.payload.request.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api", produces = "application/json")
public interface EmployeeController {
    @GetMapping("/employees")
    ResponseEntity<List<EmployeeDTO>> getEmployees();

    @GetMapping("/employee/{id}")
    ResponseEntity<EmployeeDTO> getEmployee(@PathVariable Long id);

    @PostMapping("/employee")
    ResponseEntity<EmployeeDTO> createEmployee(@RequestBody Employee employee);

    @PatchMapping("/employee/{id}")
    ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id, @RequestBody Employee employee);

    @DeleteMapping("/employee/{id}")
    ResponseEntity<String> deleteEmployee(@PathVariable Long id);
}
