package com.example.orderfoodapi.service.impl;

import com.example.orderfoodapi.converter.NhaHangFoodConverter;
import com.example.orderfoodapi.dto.NhahangFoodDTO;
import com.example.orderfoodapi.entity.Food;
import com.example.orderfoodapi.entity.Nhahang;
import com.example.orderfoodapi.entity.NhahangFood;
import com.example.orderfoodapi.repository.FoodRepository;
import com.example.orderfoodapi.repository.NhaHangFoodRepository;
import com.example.orderfoodapi.repository.NhaHangRepository;
import com.example.orderfoodapi.service.INhaHangFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class NhaHangFoodService implements INhaHangFoodService {

    @Autowired
    NhaHangFoodRepository nhaHangFoodRepository;
    @Autowired
    FoodRepository foodRepository;

    @Autowired
    NhaHangFoodConverter nhaHangFoodConverter;
    @Autowired
    NhaHangRepository nhaHangRepository;
    @Override
    public NhahangFoodDTO save(NhahangFoodDTO nhahangFoodDTO) {
        NhahangFood nhahangFood = new NhahangFood();
        if(nhahangFoodDTO.getId() != null){
            NhahangFood oldNhahangFood = nhaHangFoodRepository.findNhahangFoodById(nhahangFoodDTO.getId());
            nhahangFood = nhaHangFoodConverter.toEntity(nhahangFoodDTO,oldNhahangFood);
        }else{
            nhahangFood = nhaHangFoodConverter.toEntity(nhahangFoodDTO);
        }
        Nhahang nhahang = nhaHangRepository.findNhahangById(nhahangFoodDTO.getIdNhaHang());
        nhahangFood.setNhahang(nhahang);
        Food food = foodRepository.findFoodById(nhahangFoodDTO.getIdFood());
        nhahangFood.setFood(food);
        nhahangFood = nhaHangFoodRepository.save(nhahangFood);
        return nhaHangFoodConverter.toDTO(nhahangFood);
    }

    @Override
    public void delete(int[] ids) {
        for (int item: ids){
            nhaHangFoodRepository.deleteById(item);
        }
    }

    @Override
    public NhahangFoodDTO getIDNhaHangFood(Map<String, Object> obj) {
        int idNhaHang = Integer.parseInt(obj.get("idNhaHang").toString());
        int idFood = Integer.parseInt(obj.get("idFood").toString());
        Nhahang n = nhaHangRepository.findNhahangById(idNhaHang);
        Food f = foodRepository.findFoodById(idFood);
        NhahangFood nf = nhaHangFoodRepository.findByNhahangAndFood(n,f).get(0);
        return nhaHangFoodConverter.toDTO(nf);
    }
}
