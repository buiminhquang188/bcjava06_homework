package org.cybersoft.capstone.service.impl;

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
}
