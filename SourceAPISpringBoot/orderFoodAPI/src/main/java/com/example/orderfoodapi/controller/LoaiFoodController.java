package com.example.orderfoodapi.controller;

import com.example.orderfoodapi.dto.FoodDTO;
import com.example.orderfoodapi.dto.LoaifoodDTO;
import com.example.orderfoodapi.service.impl.LoaiFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoaiFoodController {
    @Autowired
    private LoaiFoodService loaiFoodService;
    @PostMapping("/loaifood")
    public LoaifoodDTO createLoaiFood(@RequestBody LoaifoodDTO model){
        return loaiFoodService.save(model);
    }

    @PutMapping("/loaifood/{id}")
    public  LoaifoodDTO updateLoaiFood(@RequestBody LoaifoodDTO model, @PathVariable("id") int id){
        model.setId(id);
        return loaiFoodService.save(model);
    }

    @DeleteMapping("/loaifood")
    public  void  deleteLoaiFood(@RequestBody int[] ids){
        loaiFoodService.delete(ids);
    }

    @GetMapping ("/loaifood")
    public ResponseEntity<List<LoaifoodDTO>> getAllFood() {
        return ResponseEntity.ok().body(loaiFoodService.findAll());
    }


}
