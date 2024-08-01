package org.cybersoft.capstone.repository;

import org.cybersoft.capstone.dto.LoginDTO;
import org.cybersoft.capstone.dto.UserDTO;
import org.cybersoft.capstone.entity.UserEntity;

import java.util.List;

public interface UserRepository {
    List<UserEntity> getUsers();

    UserEntity getUser(Integer id);

    Integer createUser(UserDTO userDTO);

    Integer deleteUser(Integer id);

    List<UserEntity> getUserOptions();

    List<UserEntity> getUserOptionsByRoleIdAndUserId(Integer roleId, Integer userId);

    List<UserEntity> getUserOptionsInRole(List<Integer> roleIds);

    UserEntity getUserByUsernameAndPassword(LoginDTO loginDTO);

    List<UserEntity> getUsersInProject(List<Integer> projectIds);

    UserEntity getUserWithRole(Integer id);
}
