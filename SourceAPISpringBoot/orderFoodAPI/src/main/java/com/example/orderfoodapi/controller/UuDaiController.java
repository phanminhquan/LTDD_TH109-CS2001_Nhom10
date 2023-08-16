package com.example.orderfoodapi.controller;

import com.example.orderfoodapi.dto.UudaiDTO;
import com.example.orderfoodapi.service.impl.UuDaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UuDaiController {
    @Autowired
    private UuDaiService uuDaiService;

    @PostMapping("/uudai")
    public UudaiDTO createUuDai(@RequestBody UudaiDTO model){
        return uuDaiService.save(model);
    }

    @PutMapping("/uudai/{id}")
    public UudaiDTO updateUuDai(@RequestBody UudaiDTO model, @PathVariable("id") int id){
        model.setId(id);
        return uuDaiService.save(model);
    }
    @DeleteMapping("/uudai")
    public void deleteUuDai(@RequestBody int[] ids){
        uuDaiService.delete(ids);
    }

    @GetMapping("/uudai/nhahang/{id}/")
    public ResponseEntity<List<UudaiDTO>> getUuDaiByNhaHang(@PathVariable("id") int id){
        return ResponseEntity.ok().body(uuDaiService.uuDaiListByNhahang(id));
    }
}
