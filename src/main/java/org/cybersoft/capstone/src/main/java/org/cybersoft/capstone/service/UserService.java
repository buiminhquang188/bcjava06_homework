package org.cybersoft.capstone.service;

import org.cybersoft.capstone.dto.UserDTO;
import org.cybersoft.capstone.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getUsers();

    UserEntity getUser(Integer id);

    Integer createUser(UserDTO userDTO);

    Boolean deleteUser(Integer id);

    List<UserEntity> getUserOptions();

    List<UserEntity> getUserOptionsByRole(Integer id);
}
