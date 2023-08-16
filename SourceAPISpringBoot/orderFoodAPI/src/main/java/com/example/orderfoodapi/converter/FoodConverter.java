package com.example.orderfoodapi.converter;

import com.example.orderfoodapi.dto.FoodDTO;
import com.example.orderfoodapi.entity.Food;
import org.springframework.stereotype.Component;

@Component
public class FoodConverter {
    public Food toEntity(FoodDTO foodDTO){
        Food food = new Food();
        food.setId(foodDTO.getId());
        food.setTen(foodDTO.getTen());
        food.setGiaTien(foodDTO.getGiaTien());
        food.setAvatar(foodDTO.getAvatar());
        return food;
    }

    public FoodDTO toDTO(Food entity){
        FoodDTO food = new FoodDTO();
        if(entity.getId() != null){
            food.setId(entity.getId());
        }
        food.setTen(entity.getTen());
        food.setGiaTien(entity.getGiaTien());
        food.setAvatar(entity.getAvatar());
        return food;
    }

    public Food toEntity(FoodDTO foodDTO, Food food){
        food.setId(foodDTO.getId());
        food.setTen(foodDTO.getTen());
        food.setGiaTien(foodDTO.getGiaTien());
        food.setAvatar(foodDTO.getAvatar());
        return food;
    }
}
