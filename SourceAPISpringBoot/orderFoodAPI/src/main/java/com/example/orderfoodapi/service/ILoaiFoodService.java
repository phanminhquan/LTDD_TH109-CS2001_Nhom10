package com.example.orderfoodapi.service;

import com.example.orderfoodapi.dto.LoaifoodDTO;

import java.util.List;

public interface ILoaiFoodService {
    LoaifoodDTO save(LoaifoodDTO loaifoodDTO);
    void delete(int[] id);
    List<LoaifoodDTO> findAll();
}
