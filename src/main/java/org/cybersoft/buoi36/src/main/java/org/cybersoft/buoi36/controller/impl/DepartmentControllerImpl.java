package org.cybersoft.buoi36.controller.impl;

import org.cybersoft.buoi36.controller.DepartmentController;
import org.cybersoft.buoi36.dto.BaseDepartmentDTO;
import org.cybersoft.buoi36.dto.DepartmentDTO;
import org.cybersoft.buoi36.entity.DepartmentEntity;
import org.cybersoft.buoi36.mapper.DepartmentMapper;
import org.cybersoft.buoi36.payload.request.Department;
import org.cybersoft.buoi36.service.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DepartmentControllerImpl implements DepartmentController {
    private final DepartmentMapper departmentMapper;
    private final DepartmentService departmentService;

    public DepartmentControllerImpl(DepartmentMapper departmentMapper, DepartmentService departmentService) {
        this.departmentMapper = departmentMapper;
        this.departmentService = departmentService;
    }

    @Override
    public ResponseEntity<List<BaseDepartmentDTO>> getDepartments() {
        List<DepartmentEntity> departmentEntities = this.departmentService.getDepartments();
        return ResponseEntity.ok(
                this.departmentMapper.entitiesToDTO(departmentEntities)
        );
    }

    @Override
    public ResponseEntity<DepartmentDTO> getDepartment(Long id) {
        DepartmentEntity departmentEntity = this.departmentService.getDepartment(id);

        if (departmentEntity == null) return ResponseEntity.notFound()
                .build();

        return ResponseEntity.ok(
                this.departmentMapper.entityToDTO(departmentEntity)
        );
    }

    @Override
    public ResponseEntity<DepartmentDTO> createDepartment(Department department) {
        DepartmentEntity departmentEntity = this.departmentService.createDepartment(department);

        return new ResponseEntity<>(
                this.departmentMapper.entityToDTO(departmentEntity),
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<DepartmentDTO> updateDepartment(Long id, Department department) {
        DepartmentEntity departmentEntity = this.departmentService.updateDepartment(id, department);

        if (departmentEntity == null) return ResponseEntity.notFound()
                .build();

        return ResponseEntity.ok(
                this.departmentMapper.entityToDTO(departmentEntity, department)
        );
    }

    @Override
    public ResponseEntity<String> deleteDepartment(Long id) {
        DepartmentEntity departmentEntity = this.departmentService.deleteDepartment(id);
        if (departmentEntity == null) return ResponseEntity.notFound()
                .build();

        return ResponseEntity.ok("Delete Department Success");
    }
}
