package org.cybersoft.buoi25.service.impl;

import org.cybersoft.buoi25.dao.UserDAO;
import org.cybersoft.buoi25.entity.UserEntity;
import org.cybersoft.buoi25.service.LoginService;

import java.util.List;

public class LoginServiceImpl implements LoginService {
    public LoginServiceImpl() {
    }

    @Override
    public Boolean loginUser(String username, String password) {
        UserDAO userDAO = new UserDAO();
        List<UserEntity> users = userDAO.getUserByUsernameAndPassword(username, password);

        if (users.isEmpty()) {
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }
}
