package org.cybersoft.buoi25.service.impl;

import org.cybersoft.buoi25.repository.RoleRepository;
import org.cybersoft.buoi25.dto.RoleDTO;
import org.cybersoft.buoi25.entity.RoleEntity;
import org.cybersoft.buoi25.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    public RoleServiceImpl() {
        this.roleRepository = new RoleRepository();
    }

    @Override
    public List<RoleEntity> getRoles() {
        return this.roleRepository.getRoles();
    }

    @Override
    public Integer saveRole(RoleDTO roleDTO) {
        return this.roleRepository.saveRole(roleDTO);
    }
}
