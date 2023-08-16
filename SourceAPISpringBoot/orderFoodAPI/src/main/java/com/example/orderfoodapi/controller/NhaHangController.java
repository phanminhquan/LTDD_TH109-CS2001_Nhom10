package com.example.orderfoodapi.controller;

import com.example.orderfoodapi.dto.FoodDTO;
import com.example.orderfoodapi.dto.NhahangDTO;
import com.example.orderfoodapi.service.INhaHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class NhaHangController {
    @Autowired
    private INhaHangService nhaHangService;
    @PostMapping("/nhahang")
    public NhahangDTO create(@RequestBody NhahangDTO model){
        return nhaHangService.save(model);
    }

    @PutMapping("/nhahang/{id}")
    public NhahangDTO updateNhahang(@RequestBody NhahangDTO model, @PathVariable("id") int id)
    {
        model.setId(id);
        return nhaHangService.save(model);
    }
    @DeleteMapping("/nhahang")
    public void deleteNhahang(@RequestBody int[] ids)
    {
        nhaHangService.delete(ids);
    }

    @GetMapping("/nhahang/{id}")
    public ResponseEntity<List<NhahangDTO>> findNhaHangByLoaiFood(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(nhaHangService.getAllNhaHang(id));
    }

    @GetMapping("/nhahang/")
    public  ResponseEntity<List<NhahangDTO>> findALLNhaHang(){
        return ResponseEntity.ok().body((nhaHangService.getlist()));
    }
    @GetMapping("/nhahangtop/")
    public ResponseEntity<List<NhahangDTO>> getNhaHangTop() {
        return ResponseEntity.ok().body(nhaHangService.getListTop());
    }

    @GetMapping("/nhahang/rating/{id}")
    public  ResponseEntity<Double> getRating(@PathVariable("id") int id){
        return ResponseEntity.ok().body(nhaHangService.getRatingOfRestarant(id));
    }

    @GetMapping("/nhahang/countrating/{id}")
    public  ResponseEntity<Integer> countRating(@PathVariable("id") int id){
        return ResponseEntity.ok().body(nhaHangService.countRate(id));
    }

    @GetMapping("/nhahang/food")
    public ResponseEntity<List<NhahangDTO>> getListNhaHangbyFoodSearch(@RequestParam(defaultValue = "") String kw){
        return new ResponseEntity<>(nhaHangService.getListNhaHangByFoodSeacrch(kw), HttpStatus.OK);
    }
    @GetMapping("/nhahang/detail/{id}")
    public  ResponseEntity<NhahangDTO> getNhaHangByID(@PathVariable("id") int id){
        return new ResponseEntity<>(nhaHangService.getNhaHangById(id), HttpStatus.OK);
    }
}
