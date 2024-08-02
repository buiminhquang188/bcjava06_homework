package org.cybersoft.capstone.mapper;

import org.cybersoft.capstone.dto.AuthorizationDTO;
import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.entity.RoleDetailEntity;

import java.util.ArrayList;
import java.util.List;

public class AuthorizationMapper {
    public AuthorizationDTO toDTO(Integer id,
                                  String method,
                                  String url,
                                  Integer licensed,
                                  Integer checkAction) {

        return new AuthorizationDTO(
                id,
                method,
                url,
                licensed,
                checkAction
        );
    }

    public RoleDetailDTO entityToDTO(List<RoleDetailEntity> rolesDetailEntity) {
        if (rolesDetailEntity.isEmpty()) return null;

        List<String> actionCode = new ArrayList<>();
        RoleDetailEntity roleDetailEntity = rolesDetailEntity.get(0);

        rolesDetailEntity.forEach(roleEntity -> {
            actionCode.add(roleEntity.getActionCode());
        });

        return new RoleDetailDTO(
                roleDetailEntity.getId(),
                roleDetailEntity
                        .getRole()
                        .getName(),
                roleDetailEntity
                        .getUrl(),
                actionCode
        );
    }

}
