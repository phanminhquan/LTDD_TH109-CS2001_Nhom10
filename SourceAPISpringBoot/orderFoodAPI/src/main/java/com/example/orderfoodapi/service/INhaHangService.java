package com.example.orderfoodapi.service;

import com.example.orderfoodapi.dto.NhahangDTO;

import java.util.List;

public interface INhaHangService {
    NhahangDTO save(NhahangDTO nhahangDTO);
    void delete(int[] ids);
    List<NhahangDTO> getAllNhaHang (int id);

    List<NhahangDTO> getlist();
    List<NhahangDTO> getListTop();

    double getRatingOfRestarant(int id);

    int countRate(int id);

    List<NhahangDTO> getListNhaHangByFoodSeacrch(String kw);
    NhahangDTO getNhaHangById(int id);
}
