package com.example.orderfoodapi.service;

import com.example.orderfoodapi.dto.UudaiDTO;
import com.example.orderfoodapi.entity.Uudai;

import java.util.List;

public interface IUuDaiService {
    UudaiDTO save(UudaiDTO uudaiDTO);
    void delete(int[] id);
    List<UudaiDTO> uuDaiListByNhahang(int id);
}
