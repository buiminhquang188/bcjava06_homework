package org.cybersoft.capstone.service.impl;

import org.cybersoft.capstone.dto.AuthorizationDTO;
import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.entity.RoleDetailEntity;
import org.cybersoft.capstone.mapper.AuthorizationMapper;
import org.cybersoft.capstone.repository.AuthorizationRepository;
import org.cybersoft.capstone.repository.impl.AuthorizationRepositoryImpl;
import org.cybersoft.capstone.service.AuthorizationService;

import java.util.List;

public class AuthorizationServiceImpl implements AuthorizationService {
    private final AuthorizationRepository authorizationRepository = new AuthorizationRepositoryImpl();

    private final AuthorizationMapper authorizationMapper = new AuthorizationMapper();

    @Override
    public RoleDetailDTO getAuthorizationByUserId(AuthorizationDTO authorizationDTO) {
        List<RoleDetailEntity> roleDetailEntities = this.authorizationRepository.getAuthorizationByUserId(authorizationDTO);
        return this.authorizationMapper.entityToDTO(roleDetailEntities);
    }

    @Override
    public Boolean isValidAction(AuthorizationDTO authorizationDTO) {
        List<RoleDetailEntity> roleDetailEntities = this.authorizationRepository.getValidAction(authorizationDTO);
        return roleDetailEntities != null && !roleDetailEntities.isEmpty();
    }
}
