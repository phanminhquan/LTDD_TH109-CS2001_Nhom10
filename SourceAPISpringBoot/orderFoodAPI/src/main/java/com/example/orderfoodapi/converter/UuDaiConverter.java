package com.example.orderfoodapi.converter;

import com.example.orderfoodapi.dto.UudaiDTO;
import com.example.orderfoodapi.entity.Uudai;
import org.springframework.stereotype.Component;

@Component
public class UuDaiConverter {
    public Uudai toEntity (UudaiDTO uudaiDTO){
        Uudai uudai = new Uudai();
        uudai.setId(uudaiDTO.getId());
        uudai.setNoiDung(uudaiDTO.getNoiDung());
        uudai.setGiaTri(uudaiDTO.getGiaTri());
        uudai.setNgayBatdau(uudaiDTO.getNgayBatdau());
        uudai.setNgayKetThuc(uudaiDTO.getNgayKetThuc());
        uudai.setHinhAnh(uudaiDTO.getHinhAnh());
        uudai.setLoai(uudaiDTO.getLoai());
        return uudai;
    }
    public UudaiDTO toDTO (Uudai entity){
        UudaiDTO uudai = new UudaiDTO();
        if(entity.getId() != null){
            uudai.setId(entity.getId());
        }
        uudai.setNoiDung(entity.getNoiDung());
        uudai.setGiaTri(entity.getGiaTri());
        uudai.setNgayBatdau(entity.getNgayBatdau());
        uudai.setNgayKetThuc(entity.getNgayKetThuc());
        uudai.setHinhAnh(entity.getHinhAnh());
        uudai.setLoai(entity.getLoai());
        return uudai;
    }

    public Uudai toEntity (UudaiDTO uudaiDTO, Uudai uudai){
        uudai.setId(uudaiDTO.getId());
        uudai.setNoiDung(uudaiDTO.getNoiDung());
        uudai.setGiaTri(uudaiDTO.getGiaTri());
        uudai.setNgayBatdau(uudaiDTO.getNgayBatdau());
        uudai.setNgayKetThuc(uudaiDTO.getNgayKetThuc());
        uudai.setHinhAnh(uudaiDTO.getHinhAnh());
        uudai.setLoai(uudaiDTO.getLoai());
        return uudai;
    }
}
