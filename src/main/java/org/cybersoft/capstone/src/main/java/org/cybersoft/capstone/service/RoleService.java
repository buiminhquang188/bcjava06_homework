package org.cybersoft.capstone.service;

import org.cybersoft.capstone.dto.RoleDTO;
import org.cybersoft.capstone.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> getRoles();

    Integer createRole(RoleDTO roleDTO);

    Boolean deleteRole(Integer id);
}
