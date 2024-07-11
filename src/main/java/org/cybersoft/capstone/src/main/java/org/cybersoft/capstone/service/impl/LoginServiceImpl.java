package org.cybersoft.capstone.service.impl;

import org.cybersoft.capstone.dto.LoginDTO;
import org.cybersoft.capstone.entity.UserEntity;
import org.cybersoft.capstone.repository.UserRepository;
import org.cybersoft.capstone.repository.impl.UserRepositoryImpl;
import org.cybersoft.capstone.service.LoginService;

public class LoginServiceImpl implements LoginService {
    private final UserRepository userRepository = new UserRepositoryImpl();

    @Override
    public Boolean loginUser(LoginDTO loginDTO) {
        UserEntity user = this.userRepository.getUserByUsernameAndPassword(loginDTO);
        return user != null && user.getUsername() != null;
    }
}
