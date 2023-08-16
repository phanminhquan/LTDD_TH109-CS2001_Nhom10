package com.example.orderfoodapi.service;

import com.example.orderfoodapi.dto.NhahangFoodDTO;

import java.util.Map;

public interface INhaHangFoodService {
    NhahangFoodDTO save(NhahangFoodDTO nhahangFoodDTO);
    void delete(int[] ids);
    NhahangFoodDTO getIDNhaHangFood(Map<String,Object> obj);

}
