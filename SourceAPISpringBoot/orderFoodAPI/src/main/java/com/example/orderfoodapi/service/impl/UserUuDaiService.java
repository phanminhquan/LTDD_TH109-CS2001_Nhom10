package com.example.orderfoodapi.service.impl;

import com.example.orderfoodapi.converter.UserUuDaiConverter;
import com.example.orderfoodapi.dto.UserUudaiDTO;
import com.example.orderfoodapi.entity.User;
import com.example.orderfoodapi.entity.UserUudai;
import com.example.orderfoodapi.entity.Uudai;
import com.example.orderfoodapi.repository.UserReponsitory;
import com.example.orderfoodapi.repository.UserUuDaiRepository;
import com.example.orderfoodapi.repository.UuDaiRepository;
import com.example.orderfoodapi.service.IUserUuDaiSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUuDaiService implements IUserUuDaiSevice {

    @Autowired
    private UserReponsitory userReponsitory;
    @Autowired
    private  UuDaiRepository uuDaiRepository;

    @Autowired
    private UserUuDaiConverter userUuDaiConverter;

    @Autowired
    private UserUuDaiRepository userUuDaiRepository;

    @Override
    public UserUudaiDTO save(UserUudaiDTO userUudaiDTO) {
        UserUudai userUudai = new UserUudai();
        if(userUudaiDTO.getId()!=null){
            UserUudai userUdaiOld = userUuDaiRepository.findUserUudaiById(userUudaiDTO.getId());
            userUudai = userUuDaiConverter.toEntiy(userUudaiDTO,userUdaiOld);
        }
        else{
            userUudai = userUuDaiConverter.toEntiy(userUudaiDTO);
        }
        User user = userReponsitory.findUserById(userUudaiDTO.getIdUser());
        Uudai uudai = uuDaiRepository.findUudaiById(userUudaiDTO.getIdUuDai());

        userUudai.setUser(user);
        userUudai.setUudai(uudai);
        userUudai = userUuDaiRepository.save(userUudai);
        return userUuDaiConverter.toDTO(userUudai);
    }

    @Override
    public void delete(int[] ids) {
        for(int item : ids){
            userUuDaiRepository.deleteById(item);
        }
    }

}
