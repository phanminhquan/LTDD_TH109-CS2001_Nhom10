package com.example.orderfoodapi.service;

import com.example.orderfoodapi.dto.LoginDTO;
import com.example.orderfoodapi.dto.UserDTO;

import java.util.Map;

public interface IUserService {
    UserDTO save(UserDTO userDTO);
    void delete (int[] ids);

    UserDTO loginUser(LoginDTO loginDTO);

    UserDTO UpdateProfile(int id , Map<String,Object> obj);
}
