package com.example.orderfoodapi.service;

import com.example.orderfoodapi.dto.DanhgiaDTO;

import java.util.List;

public interface IDanhGiaService {

    DanhgiaDTO save(DanhgiaDTO danhgiaDTO);

    void delete(int[] ids);
    List<DanhgiaDTO> getListDanhGiaByNhaHang (int id);

}
