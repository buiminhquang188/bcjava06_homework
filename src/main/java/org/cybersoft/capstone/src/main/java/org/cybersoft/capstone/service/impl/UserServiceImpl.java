package org.cybersoft.capstone.service.impl;

import org.cybersoft.capstone.dto.UserDTO;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.repository.UserRepository;
import org.cybersoft.capstone.repository.impl.UserRepositoryImpl;
import org.cybersoft.capstone.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public List<UserEntity> getUsers() {
        return this.userRepository.getUsers();
    }

    @Override
    public Integer createUser(UserDTO userDTO) {
        return this.userRepository.createUser(userDTO);
    }

    @Override
    public Boolean deleteUser(Integer id) {
        Integer resultIndex = this.userRepository.deleteUser(id);
        return resultIndex > 0;
    }
}
