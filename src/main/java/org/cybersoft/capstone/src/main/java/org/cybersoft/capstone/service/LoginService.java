package org.cybersoft.capstone.service;

import org.cybersoft.capstone.dto.LoginDTO;

public interface LoginService {
    Boolean loginUser(LoginDTO loginDTO);
}
