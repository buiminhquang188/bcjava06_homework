package org.cybersoft.buoi25.service.impl;

import org.cybersoft.buoi25.dao.RoleDAO;
import org.cybersoft.buoi25.dto.RoleDTO;
import org.cybersoft.buoi25.entity.RoleEntity;
import org.cybersoft.buoi25.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {
    private final RoleDAO roleDAO;

    public RoleServiceImpl() {
        this.roleDAO = new RoleDAO();
    }

    @Override
    public List<RoleEntity> getRoles() {
        return this.roleDAO.getRoles();
    }

    @Override
    public Integer saveRole(RoleDTO roleDTO) {
        return this.roleDAO.saveRole(roleDTO);
    }
}
