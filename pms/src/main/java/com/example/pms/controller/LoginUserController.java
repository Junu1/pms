package com.example.pms.controller;

import com.example.pms.dto.LoginUserDTO;
import com.example.pms.service.LoginUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "login")
public class LoginUserController {
    @Autowired
    private LoginUserService loginUserService;

    @PostMapping
    public void login(@RequestBody LoginUserDTO loginUserDTO) {
        log.info("1");
        log.info(loginUserDTO.getName());
        loginUserService.authentication(loginUserDTO);
    }
}
