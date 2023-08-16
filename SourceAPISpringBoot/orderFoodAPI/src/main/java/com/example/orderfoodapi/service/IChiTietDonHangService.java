package com.example.orderfoodapi.service;

import com.example.orderfoodapi.dto.ChitietdonhangDTO;
import com.example.orderfoodapi.entity.Chitietdonhang;
import com.example.orderfoodapi.entity.Donhang;

import java.util.List;

public interface IChiTietDonHangService {

    ChitietdonhangDTO save(ChitietdonhangDTO chiTietDonHangDTO);

    void delete(int[] ids);
    List<ChitietdonhangDTO> saveList(List<ChitietdonhangDTO> list);
    List<ChitietdonhangDTO> findByDonhang(int id);
    List<Object[]> listChiTietDonHangByIDDonHang(int id);

}