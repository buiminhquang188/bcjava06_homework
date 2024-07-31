package org.cybersoft.capstone.service;

import org.cybersoft.capstone.dto.AuthorizationDTO;
import org.cybersoft.capstone.dto.RoleDetailDTO;

public interface AuthorizationService {
    RoleDetailDTO getAuthorizationByUserId(AuthorizationDTO authorizationDTO);
}
