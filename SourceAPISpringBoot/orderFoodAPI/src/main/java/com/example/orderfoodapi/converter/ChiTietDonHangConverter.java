package com.example.orderfoodapi.converter;

import com.example.orderfoodapi.dto.ChitietdonhangDTO;
import com.example.orderfoodapi.entity.Chitietdonhang;
import org.springframework.stereotype.Component;

@Component
public class ChiTietDonHangConverter {
    public Chitietdonhang toEntity (ChitietdonhangDTO chitietdonhangDTO) {
        Chitietdonhang chitietdonhang = new Chitietdonhang();
        chitietdonhang.setId(chitietdonhangDTO.getId());
        chitietdonhang.setSoLuong(chitietdonhangDTO.getSoLuong());
        return chitietdonhang;
    }

    public ChitietdonhangDTO toDTO (Chitietdonhang entity) {
        ChitietdonhangDTO chitietdonhang = new ChitietdonhangDTO();
        if (entity.getId() != null)
            chitietdonhang.setId(entity.getId());
        chitietdonhang.setSoLuong(entity.getSoLuong());
        return chitietdonhang;
    }

    public Chitietdonhang toEntity (ChitietdonhangDTO chitietdonhangDTO, Chitietdonhang chitietdonhang) {
        chitietdonhang.setId(chitietdonhangDTO.getId());
        chitietdonhang.setSoLuong(chitietdonhangDTO.getSoLuong());
        return chitietdonhang;
    }
}
