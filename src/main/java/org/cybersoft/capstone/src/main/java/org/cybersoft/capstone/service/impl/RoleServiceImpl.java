package org.cybersoft.capstone.service.impl;

import org.cybersoft.capstone.dto.RoleDTO;
import org.cybersoft.capstone.entity.RoleEntity;
import org.cybersoft.capstone.repository.RoleRepository;
import org.cybersoft.capstone.repository.impl.RoleRepositoryImpl;
import org.cybersoft.capstone.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository = new RoleRepositoryImpl();

    @Override
    public List<RoleEntity> getRoles() {
        return this.roleRepository.getRoles();
    }

    @Override
    public Integer createRole(RoleDTO roleDTO) {
        return this.roleRepository.createRole(roleDTO);
    }

    @Override
    public Boolean deleteRole(Integer id) {
        return this.roleRepository.deleteRole(id) > 0;
    }
}
