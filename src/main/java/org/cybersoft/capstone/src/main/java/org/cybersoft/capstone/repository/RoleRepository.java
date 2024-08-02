package org.cybersoft.capstone.repository;

import org.cybersoft.capstone.dto.RoleDTO;
import org.cybersoft.capstone.entity.RoleEntity;

import java.util.List;

public interface RoleRepository {
    List<RoleEntity> getRoles();

    Integer createRole(RoleDTO roleDTO);

    Integer deleteRole(Integer id);
}
