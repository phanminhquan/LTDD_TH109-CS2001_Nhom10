package com.example.orderfoodapi.controller;

import com.example.orderfoodapi.dto.DanhgiaDTO;
import com.example.orderfoodapi.dto.FoodDTO;
import com.example.orderfoodapi.service.impl.DanhGiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DanhGiaController {

    @Autowired
    private DanhGiaService danhGiaService;

    @PostMapping("/danh_gia")
    public DanhgiaDTO createDanhGia(@RequestBody DanhgiaDTO model) {
        return danhGiaService.save(model);
    }

    @PutMapping("/danh_gia/{id}")
    public DanhgiaDTO updateDanhGia(@RequestBody DanhgiaDTO model, @PathVariable("id") int id) {
        model.setId(id);
        return danhGiaService.save(model);
    }

    @DeleteMapping("/danh_gia")
    public void deleteDanhGia (@RequestBody int[] ids) { danhGiaService.delete(ids); }

    @GetMapping("/danh_gia/{id}")
    public ResponseEntity<List<DanhgiaDTO>> getDanhGiaByNhaHang (@PathVariable ("id") int id)
    {
        return ResponseEntity.ok().body(danhGiaService.getListDanhGiaByNhaHang(id));
    }

}
