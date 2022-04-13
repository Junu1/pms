package com.example.pms.service.impl;

import com.example.pms.dto.LoginUserDTO;
import com.example.pms.model.User;
import com.example.pms.service.LoginUserService;
import com.example.pms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private UserService userService;

    @Override
    public boolean authentication(LoginUserDTO loginUserDTO) {
        User user = new User();
        log.info(loginUserDTO.getName());
        user = userService.getUserByName(loginUserDTO.getName());
        log.info("We got our user");
        if (user == null) {
            log.info("Username does not exists");
        } else if (user.getName().equals(loginUserDTO.getName()) && (user.getPassword().equals(loginUserDTO.getPassword()))) {
            log.info("Login successful");
        } else {
            log.info("Username does not match");
        }
        return true;
    }

}
