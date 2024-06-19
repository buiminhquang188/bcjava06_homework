package org.cybersoft.buoi25.service.impl;

import org.cybersoft.buoi25.repository.UserRepository;
import org.cybersoft.buoi25.entity.UserEntity;
import org.cybersoft.buoi25.service.LoginService;

import java.util.List;

public class LoginServiceImpl implements LoginService {
    public LoginServiceImpl() {
    }

    @Override
    public Boolean loginUser(String username, String password) {
        UserRepository userRepository = new UserRepository();
        List<UserEntity> users = userRepository.getUserByUsernameAndPassword(username, password);

        if (users.isEmpty()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
