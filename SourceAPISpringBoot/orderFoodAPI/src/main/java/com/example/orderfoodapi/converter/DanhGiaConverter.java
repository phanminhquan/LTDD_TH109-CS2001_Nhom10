package com.example.orderfoodapi.converter;

import com.example.orderfoodapi.dto.DanhgiaDTO;
import com.example.orderfoodapi.entity.Danhgia;
import org.springframework.stereotype.Component;

@Component
public class DanhGiaConverter {
    public Danhgia toEntity (DanhgiaDTO danhgiaDTO) {
        Danhgia danhgia = new Danhgia();
        danhgia.setId(danhgiaDTO.getId());
        danhgia.setGiaTien(danhgiaDTO.getGiaTien());
        danhgia.setRate(danhgiaDTO.getRate());
        danhgia.setNoiDung(danhgiaDTO.getNoiDung());
        return danhgia;
    }

    public DanhgiaDTO toDTO (Danhgia entity) {
        DanhgiaDTO danhgia = new DanhgiaDTO();
        if (entity.getId() != null)
            danhgia.setId(entity.getId());
        danhgia.setGiaTien(entity.getGiaTien());
        danhgia.setRate(entity.getRate());
        danhgia.setNoiDung(entity.getNoiDung());
        return danhgia;
    }

    public Danhgia toEntity (DanhgiaDTO danhgiaDTO, Danhgia danhgia) {
        danhgia.setId(danhgiaDTO.getId());
        danhgia.setGiaTien(danhgiaDTO.getGiaTien());
        danhgia.setRate(danhgiaDTO.getRate());
        danhgia.setNoiDung(danhgiaDTO.getNoiDung());
        return danhgia;
    }
}
