package org.cybersoft.capstone.repository;

import org.cybersoft.capstone.dto.AuthorizationDTO;
import org.cybersoft.capstone.entity.RoleDetailEntity;

import java.util.List;

public interface AuthorizationRepository {
    List<RoleDetailEntity> getAuthorizationByUserId(AuthorizationDTO authorizationDTO);

    List<RoleDetailEntity> getValidAction(AuthorizationDTO authorizationDTO);
}
