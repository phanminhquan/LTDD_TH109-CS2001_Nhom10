package com.example.orderfoodapi.service.impl;

import com.example.orderfoodapi.converter.UuDaiConverter;
import com.example.orderfoodapi.dto.FoodDTO;
import com.example.orderfoodapi.dto.UudaiDTO;
import com.example.orderfoodapi.entity.Food;
import com.example.orderfoodapi.entity.NhahangFood;
import com.example.orderfoodapi.entity.Uudai;
import com.example.orderfoodapi.repository.NhaHangFoodRepository;
import com.example.orderfoodapi.repository.NhaHangRepository;
import com.example.orderfoodapi.repository.UserReponsitory;
import com.example.orderfoodapi.repository.UuDaiRepository;
import com.example.orderfoodapi.service.IUuDaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UuDaiService implements IUuDaiService {
    @Autowired
    private UuDaiRepository uuDaiRepository;

    @Autowired
    private UuDaiConverter uuDaiConverter;

    @Autowired
    private NhaHangFoodRepository nhaHangFoodRepository;

    @Override
    public UudaiDTO save(UudaiDTO uudaiDTO) {
        Uudai uudai = new Uudai();
        if(uudaiDTO.getId() != null){
            Uudai uudaiold = uuDaiRepository.findUudaiById(uudaiDTO.getId());
            uudai = uuDaiConverter.toEntity(uudaiDTO,uudaiold);
        }
        else{
            uudai = uuDaiConverter.toEntity(uudaiDTO);
        }
        NhahangFood nhahangFood = nhaHangFoodRepository.findNhahangFoodById(uudaiDTO.getIdNhaHangFood());
        uudai.setNhahangFood(nhahangFood);
        uudai = uuDaiRepository.save(uudai);
        return uuDaiConverter.toDTO(uudai);
    }

    @Override
    public void delete(int[] id) {
        for (int item: id)
        {
            uuDaiRepository.deleteById(item);
        }
    }

    @Override
    public List<UudaiDTO> uuDaiListByNhahang(int id) {
        List<Uudai> list = uuDaiRepository.getUuDaiyNhaHang(id);
        List<UudaiDTO> UuDaiDTOS = new ArrayList<UudaiDTO>();
        for(Uudai u : list){
            UudaiDTO udto = uuDaiConverter.toDTO(u);
            UuDaiDTOS.add(udto);
        }
        return UuDaiDTOS;
    }
}
