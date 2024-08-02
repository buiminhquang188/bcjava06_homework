package org.cybersoft.buoi36.controller;

import org.cybersoft.buoi36.dto.BaseDepartmentDTO;
import org.cybersoft.buoi36.dto.DepartmentDTO;
import org.cybersoft.buoi36.payload.request.Department;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/api", produces = "application/json")
public interface DepartmentController {
    @GetMapping("/departments")
    ResponseEntity<List<BaseDepartmentDTO>> getDepartments();

    @GetMapping("/department/{id}")
    ResponseEntity<DepartmentDTO> getDepartment(@PathVariable Long id);

    @PostMapping("/department")
    ResponseEntity<DepartmentDTO> createDepartment(@RequestBody Department department);

    @PatchMapping("/department/{id}")
    ResponseEntity<DepartmentDTO> updateDepartment(@PathVariable Long id, @RequestBody Department department);

    @DeleteMapping("/department/{id}")
    ResponseEntity<String> deleteDepartment(@PathVariable Long id);
}
