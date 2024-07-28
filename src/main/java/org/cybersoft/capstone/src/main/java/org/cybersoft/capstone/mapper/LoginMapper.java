package org.cybersoft.capstone.mapper;

import org.cybersoft.capstone.dto.LoginDTO;

public class LoginMapper {
    public LoginDTO loginParameterToDTO(String username, String password) {
        return new LoginDTO(username, password);
    }
}
