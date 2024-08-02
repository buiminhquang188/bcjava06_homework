package org.cybersoft.capstone.service;

import org.cybersoft.capstone.dto.LoginDTO;
import org.cybersoft.capstone.payload.response.LoginResponse;

public interface LoginService {
    LoginResponse loginUser(LoginDTO loginDTO);
}
