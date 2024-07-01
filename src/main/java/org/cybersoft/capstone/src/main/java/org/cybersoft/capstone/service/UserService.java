package org.cybersoft.capstone.service;

import org.cybersoft.capstone.dto.UserDTO;
import org.cybersoft.capstone.entity.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> getUsers();

    Integer createUser(UserDTO userDTO);

    Boolean deleteUser(Integer id);
}
