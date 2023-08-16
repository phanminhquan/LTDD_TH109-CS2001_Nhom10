package com.example.orderfoodapi.service;

import com.example.orderfoodapi.dto.UserUudaiDTO;



public interface IUserUuDaiSevice {
    UserUudaiDTO save(UserUudaiDTO uudaiDTO);
    void delete(int[] ids);
}
