package com.example.orderfoodapi.converter;


import com.example.orderfoodapi.dto.DanhgiaDTO;

import com.example.orderfoodapi.dto.DonhangDTO;
import com.example.orderfoodapi.entity.Donhang;
import org.springframework.stereotype.Component;

@Component
public class DonHangConVerter {
    public Donhang toEntity (DonhangDTO donhangDTO) {

        Donhang donHang = new Donhang();
        donHang.setId(donhangDTO.getId());
        donHang.setTongtien(donhangDTO.getTongTien());
        donHang.setNgayGio(donhangDTO.getNgayGio());
        donHang.setGhiChu(donhangDTO.getGhiChu());
        donHang.setTrangThai(donhangDTO.getTrangThai());
        donHang.setTongtien(donhangDTO.getTongTien());
        return donHang;
    }

    public DonhangDTO toDTO (Donhang entity) {
        DonhangDTO donHang = new DonhangDTO();
        if (entity.getId() != null)
            donHang.setId(entity.getId());
        donHang.setNgayGio(entity.getNgayGio());
        donHang.setGhiChu(entity.getGhiChu());
        donHang.setTrangThai(entity.getTrangThai());
        donHang.setTongTien(entity.getTongtien());
        donHang.setTongTien(entity.getTongtien());
        return donHang;
    }

    public Donhang toEntity (DonhangDTO donHangDTO, Donhang donHang) {
        donHang.setId(donHangDTO.getId());
        donHang.setNgayGio(donHangDTO.getNgayGio());
        donHang.setGhiChu(donHangDTO.getGhiChu());
        donHang.setTrangThai(donHangDTO.getTrangThai());
        donHang.setTongtien(donHang.getTongtien());
        return donHang;
    }
}
