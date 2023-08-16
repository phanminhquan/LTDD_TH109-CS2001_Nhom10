package com.example.orderfoodapi.converter;


import com.example.orderfoodapi.dto.NhahangFoodDTO;

import com.example.orderfoodapi.entity.NhahangFood;
import org.springframework.stereotype.Component;

@Component
public class NhaHangFoodConverter {

    public NhahangFoodDTO toDTO(NhahangFood entity){
        NhahangFoodDTO nhahangFoodDTO = new NhahangFoodDTO();
        if(entity.getId() != null){
            nhahangFoodDTO.setId(entity.getId());
        }
        return nhahangFoodDTO;
    }

    public  NhahangFood toEntity(NhahangFoodDTO nhahangFoodDTO){
        NhahangFood nhahangFood = new NhahangFood();
        nhahangFood.setId(nhahangFoodDTO.getId());
        return nhahangFood;
    }
    public NhahangFood toEntity(NhahangFoodDTO nhahangFoodDTO, NhahangFood nhahangFood)
    {
        nhahangFood.setId(nhahangFoodDTO.getId());
        return nhahangFood;
    }
}
