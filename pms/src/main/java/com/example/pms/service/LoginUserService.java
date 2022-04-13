package com.example.pms.service;

import com.example.pms.dto.LoginUserDTO;

public interface LoginUserService {
    public boolean authentication(LoginUserDTO loginUserDTO);
}
