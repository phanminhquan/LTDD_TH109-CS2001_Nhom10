package com.example.orderfoodapi.converter;


import com.example.orderfoodapi.dto.UserUudaiDTO;
import com.example.orderfoodapi.entity.UserUudai;
import org.springframework.stereotype.Component;

@Component
public class UserUuDaiConverter {
    public UserUudai toEntiy(UserUudaiDTO uudaiDTO){
        UserUudai userUudai = new UserUudai();
        userUudai.setId(uudaiDTO.getId());
        return userUudai;
    }

    public UserUudaiDTO toDTO(UserUudai uudai){
        UserUudaiDTO userUudai = new UserUudaiDTO();
        if(uudai.getId()!=null)
        {
            userUudai.setId(uudai.getId());
        }

        return userUudai;
    }

    public UserUudai toEntiy(UserUudaiDTO uudaiDTO,UserUudai userUudai){
        userUudai.setId(uudaiDTO.getId());
        return userUudai;
    }

}
