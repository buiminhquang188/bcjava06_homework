package org.cybersoft.buoi25.service;

import org.cybersoft.buoi25.dto.RoleDTO;
import org.cybersoft.buoi25.entity.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> getRoles();

    Integer saveRole(RoleDTO roleDTO);

}
