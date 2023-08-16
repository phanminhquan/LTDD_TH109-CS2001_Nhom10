package com.example.orderfoodapi.service;

import com.example.orderfoodapi.dto.ChitietdonhangDTO;
import com.example.orderfoodapi.dto.DonhangDTO;
import com.example.orderfoodapi.entity.Chitietdonhang;
import com.example.orderfoodapi.entity.Donhang;

import java.util.List;
import java.util.Map;

public interface IDonHangService {
    DonhangDTO save(DonhangDTO donhangDTO);
    void delete(int[] ids);

    DonhangDTO UpdateTrangThai(int id , Map<String,Object> obj);
    List<DonhangDTO> getAll();

    List<DonhangDTO> getListDonHangByUserId(int id);


    List<Object[]> customResponseDonHangUI(int idUser);
}
