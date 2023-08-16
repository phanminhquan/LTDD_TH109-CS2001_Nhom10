package com.example.orderfoodapi.converter;

import com.example.orderfoodapi.dto.LoaifoodDTO;
import com.example.orderfoodapi.entity.Loaifood;
import org.springframework.stereotype.Component;

@Component
public class LoaiFoodConverter {
    public Loaifood toEntity(LoaifoodDTO loaifoodDTO)
    {
        Loaifood loaifood = new Loaifood();
        loaifood.setId(loaifoodDTO.getId());
        loaifood.setTen(loaifoodDTO.getTen());
        return loaifood;
    }

    public LoaifoodDTO toDTO (Loaifood entity)
    {
        LoaifoodDTO loaifoodDTO = new LoaifoodDTO();
        if(entity.getId() != null)
        {
            loaifoodDTO.setId(entity.getId());
        }
        loaifoodDTO.setTen(entity.getTen());
        return loaifoodDTO;
    }

    public Loaifood toEntity(LoaifoodDTO loaifoodDTO ,Loaifood loaifood)
    {
        loaifood.setId(loaifoodDTO.getId());
        loaifood.setTen(loaifoodDTO.getTen());
        return loaifood;
    }
}
