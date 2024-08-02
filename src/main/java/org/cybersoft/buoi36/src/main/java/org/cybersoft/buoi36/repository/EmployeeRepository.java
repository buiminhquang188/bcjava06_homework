package org.cybersoft.buoi36.repository;

import org.cybersoft.buoi36.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    List<EmployeeEntity> findAllByIdInOrDepartmentId(List<Long> employeeId, Long departmentId);
}