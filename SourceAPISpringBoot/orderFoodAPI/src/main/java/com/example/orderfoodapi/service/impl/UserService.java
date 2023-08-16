package com.example.orderfoodapi.service.impl;

import com.example.orderfoodapi.Response.LoginMesage;
import com.example.orderfoodapi.Response.RegisterMessage;
import com.example.orderfoodapi.converter.UserConverter;
import com.example.orderfoodapi.dto.LoginDTO;
import com.example.orderfoodapi.dto.UserDTO;
import com.example.orderfoodapi.entity.Donhang;
import com.example.orderfoodapi.entity.User;
import com.example.orderfoodapi.repository.UserReponsitory;
import com.example.orderfoodapi.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserConverter userConverter;
    @Autowired
    private UserReponsitory userReponsitory;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDTO save(UserDTO userDTO) {
        User user = new User();
        boolean check = true;
        List<User> listCheck = userReponsitory.findAll();

        if (userDTO.getId() != null) {
            User oldUser = userReponsitory.findUserById(userDTO.getId());
            user = userConverter.toEntity(userDTO, oldUser);
            listCheck.remove(oldUser);
        } else {
            user = userConverter.toEntity(userDTO);
        }
        for (User u : listCheck) {
            if (u.getTaiKhoan().equals(user.getTaiKhoan())) {
                check = false;
                break;
            }
        }
        if (check) {
            user = userReponsitory.save(user);
            return userConverter.toDTO(user);
        }
        else
            return null;

    }

    public UserDTO registerUser(UserDTO userDTO){
        if(userDTO == null){
            return null;
        }
        else {
            return userDTO;
        }
    }

    @Override
    public void delete(int[] ids) {
        for(int item: ids){
            userReponsitory.deleteById(item);
        }
    }

    @Override
    public UserDTO loginUser(LoginDTO loginDTO) {
        String msg = "";
        User user1 = userReponsitory.findByTaiKhoan(loginDTO.getTaiKhoan());
        if (user1 != null) {
            String password = loginDTO.getMatKhau();
            String encodedPassword = user1.getMatKhau();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
                Optional<User> user = userReponsitory.findByTaiKhoanAndMatKhau(loginDTO.getTaiKhoan(),encodedPassword);
                if (user.isPresent()) {
                    return userConverter.toDTO(user1);
                } else {
                    return null;
                }
            } else {
                return null;
            }
        }else {
            return null;
        }
    }

    @Override
    public UserDTO UpdateProfile(int id, Map<String, Object> obj) {
        User u = userReponsitory.findUserById(id);
        String taikhoan = obj.get("taiKhoan").toString();
        String hoTen = obj.get("ten").toString();
        String sdt = obj.get("soDienThoai").toString();
        String email = obj.get("email").toString();
        String diachi = obj.get("diaChi").toString();
        u.setTaiKhoan(taikhoan);
        u.setTen(hoTen);
        u.setSoDienThoai(sdt);
        u.setEmail(email);
        u.setDiaChi(diachi);
        u = userReponsitory.save(u);
        return userConverter.toDTO(u);
    }

}
