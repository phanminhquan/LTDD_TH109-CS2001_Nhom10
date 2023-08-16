package com.example.orderfoodapi.service.impl;
import com.example.orderfoodapi.converter.FoodConverter;
import com.example.orderfoodapi.dto.FoodDTO;
import com.example.orderfoodapi.entity.Food;
import com.example.orderfoodapi.entity.Loaifood;
import com.example.orderfoodapi.repository.FoodRepository;
import com.example.orderfoodapi.repository.LoaiFoodRepository;
import com.example.orderfoodapi.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FoodService implements IFoodService {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private LoaiFoodRepository loaiFoodRepository;
    @Autowired
    private FoodConverter foodConverter;
    @Override
    public FoodDTO save(FoodDTO foodDTO) {
        Food food = new Food();
        if(foodDTO.getId() != null){
            Food oldFoodEntity = foodRepository.findFoodById(foodDTO.getId());
            food = foodConverter.toEntity(foodDTO,oldFoodEntity);
        }else {
            food = foodConverter.toEntity(foodDTO);
        }
        Loaifood loaifood = loaiFoodRepository.findLoaifoodById(foodDTO.getIdLoai());
        food.setLoaifood(loaifood);
        food = foodRepository.save(food);
        return foodConverter.toDTO(food);
    }
    @Override
    public void delete(int[] ids) {
        for(int item: ids){
            foodRepository.deleteById(item);
        }
    }

    @Override
    public List<FoodDTO> findAll() {
        List<Food> list = foodRepository.findAll();
        List<FoodDTO> foodDTOS = new ArrayList<FoodDTO>();
        for(Food f : list){
            FoodDTO fdto = foodConverter.toDTO(f);
            foodDTOS.add(fdto);
        }
        return foodDTOS;
    }

    @Override
    public FoodDTO getFoodByID(int id) {
        Food food = foodRepository.findFoodById(id);
        return foodConverter.toDTO(food);
    }

    @Override
    public List<FoodDTO> findByName(String kw) {
        List<Food> list = foodRepository.findByTenIsContainingIgnoreCase(kw);
        List<FoodDTO> foodDTOS = new ArrayList<FoodDTO>();
        for(Food f : list){
            FoodDTO fdto = foodConverter.toDTO(f);
            foodDTOS.add(fdto);
        }
        return foodDTOS;
    }

    @Override
    public List<FoodDTO> getListFoodByNhaHang(int id) {
        List<Food> list = foodRepository.getListFoodByNhaHang(id);
        List<FoodDTO> foodDTOS = new ArrayList<FoodDTO>();
        for(Food f : list) {
            FoodDTO fdto = foodConverter.toDTO(f);
            foodDTOS.add(fdto);
        }
        return foodDTOS;
    }

    @Override
    public List<FoodDTO> findFoodByLoaiFood(int id) {
        Loaifood l = loaiFoodRepository.findLoaifoodById(id);
        List<Food> list = foodRepository.findAllByLoaifood(l);
        List<FoodDTO> foodDTOS = new ArrayList<FoodDTO>();
        for (Food f: list){
            FoodDTO foodDTO = foodConverter.toDTO(f);
            foodDTOS.add(foodDTO);
        }
        return foodDTOS;
    }

    @Override
    public List<Object[]> getFoodByDonHang(int id) {
        return foodRepository.getFoodByDonHang(id);
    }

}


