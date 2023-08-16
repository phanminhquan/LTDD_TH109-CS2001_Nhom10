package com.example.orderfoodapi.service.impl;

import com.example.orderfoodapi.converter.LoaiFoodConverter;
import com.example.orderfoodapi.dto.FoodDTO;
import com.example.orderfoodapi.dto.LoaifoodDTO;
import com.example.orderfoodapi.entity.Food;
import com.example.orderfoodapi.entity.Loaifood;
import com.example.orderfoodapi.repository.LoaiFoodRepository;
import com.example.orderfoodapi.service.ILoaiFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoaiFoodService implements ILoaiFoodService {
    @Autowired
    private LoaiFoodRepository loaiFoodRepository;
    @Autowired
    private LoaiFoodConverter loaiFoodConverter;

    @Override
    public LoaifoodDTO save(LoaifoodDTO loaifoodDTO) {
        Loaifood loaifood = new Loaifood();
        if(loaifoodDTO.getId() != null){
            Loaifood oldLoaiFood = loaiFoodRepository.findLoaifoodById(loaifoodDTO.getId());
            loaifood = loaiFoodConverter.toEntity(loaifoodDTO,oldLoaiFood);
        }else{
            loaifood = loaiFoodConverter.toEntity(loaifoodDTO);
        }
        loaifood = loaiFoodRepository.save(loaifood);
        return loaiFoodConverter.toDTO(loaifood);
    }

    @Override
    public void delete(int[] id) {
        for (int item: id){
            loaiFoodRepository.deleteById(item);
        }
    }

    @Override
    public List<LoaifoodDTO> findAll() {
        List<Loaifood> list = loaiFoodRepository.findAll();
        List<LoaifoodDTO> loaifoodDTOS = new ArrayList<LoaifoodDTO>();
        for(Loaifood f : list){
            LoaifoodDTO fdto = loaiFoodConverter.toDTO(f);
            loaifoodDTOS.add(fdto);
        }
        return loaifoodDTOS;
    }
}
