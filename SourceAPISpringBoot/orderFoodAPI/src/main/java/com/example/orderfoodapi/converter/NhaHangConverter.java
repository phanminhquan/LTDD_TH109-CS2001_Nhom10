package com.example.orderfoodapi.converter;

import com.example.orderfoodapi.dto.FoodDTO;
import com.example.orderfoodapi.dto.NhahangDTO;
import com.example.orderfoodapi.entity.Food;
import com.example.orderfoodapi.entity.Nhahang;
import org.springframework.stereotype.Component;

@Component
public class NhaHangConverter {
    public Nhahang toEntity(NhahangDTO nhahangDTO)
    {
        Nhahang nhahang = new Nhahang();
        nhahang.setId(nhahangDTO.getId());
        nhahang.setTen(nhahangDTO.getTen());
        nhahang.setDiaChi(nhahangDTO.getDiaChi());
        nhahang.setSoDienThoai(nhahangDTO.getSoDienThoai());
        nhahang.setEmail(nhahangDTO.getEmail());
        nhahang.setAvatar(nhahangDTO.getAvatar());
        return nhahang;
    }
    public NhahangDTO toDTO(Nhahang Entity)
    {
        NhahangDTO nhahang = new NhahangDTO();
        if(Entity.getId() != null){
            nhahang.setId(Entity.getId());
        }
        nhahang.setTen(Entity.getTen());
        nhahang.setDiaChi(Entity.getDiaChi());
        nhahang.setSoDienThoai(Entity.getSoDienThoai());
        nhahang.setEmail(Entity.getEmail());
        nhahang.setAvatar(Entity.getAvatar());
        return nhahang;
    }

    public Nhahang toEntity(NhahangDTO nhahangDTO, Nhahang nhahang)
    {
        nhahang.setId(nhahangDTO.getId());
        nhahang.setTen(nhahangDTO.getTen());
        nhahang.setDiaChi(nhahangDTO.getDiaChi());
        nhahang.setSoDienThoai(nhahangDTO.getSoDienThoai());
        nhahang.setEmail(nhahangDTO.getEmail());
        nhahang.setAvatar(nhahangDTO.getAvatar());
        return nhahang;
    }
}
