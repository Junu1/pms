package com.example.pms.service.impl;

import com.example.pms.dto.UserDTO;
import com.example.pms.model.User;
import com.example.pms.repository.UserRepository;
import com.example.pms.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean saveUser(UserDTO userDTO) {
        User user = new User();
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return true;
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();
        for (User user : users) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setPassword(user.getPassword());
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public UserDTO updateUsers(UserDTO userDTO) {
        User user = userRepository.getById(userDTO.getId());
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public User getUserByName(String name) {
        return userRepository.findUserByName(name);
    }
}
