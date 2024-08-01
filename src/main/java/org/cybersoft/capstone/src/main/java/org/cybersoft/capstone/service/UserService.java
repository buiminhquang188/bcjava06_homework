package org.cybersoft.capstone.service;

import org.cybersoft.capstone.dto.RoleDetailDTO;
import org.cybersoft.capstone.dto.UserDTO;
import org.cybersoft.capstone.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getUsers();

    List<UserEntity> getUsersInProject(Integer id);

    UserEntity getUser(Integer id);

    Integer createUser(UserDTO userDTO);

    Boolean deleteUser(Integer id);

    List<UserEntity> getUserOptions(RoleDetailDTO roleDetailDTO);

    List<UserEntity> getUserOptionsByRole(RoleDetailDTO roleDetailDTO);

    UserEntity getUserWithRole(Integer id);

    List<UserEntity> getUserInProjectByOwnerId(Integer ownerId);

    Boolean createUserPermission(Integer roleId, Integer userId);

    Boolean deleteUserPermission(Integer userId);
}
