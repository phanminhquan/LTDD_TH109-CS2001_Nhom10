package com.example.orderfoodapi.controller;

import com.example.orderfoodapi.dto.ChitietdonhangDTO;
import com.example.orderfoodapi.service.impl.ChiTietDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChiTietDonHangController {

    @Autowired
    private ChiTietDonHangService chiTietDonHangService;

    @PostMapping("/chi_tiet")
    public ChitietdonhangDTO createChiTietDonHang(@RequestBody ChitietdonhangDTO model) {
        return chiTietDonHangService.save(model);
    }

    @PutMapping("/chi_tiet/{id}")
    public ChitietdonhangDTO updateChiTietDonHang(@RequestBody ChitietdonhangDTO model, @PathVariable("id") int id) {
        model.setId(id);
        return chiTietDonHangService.save(model);
    }

    @DeleteMapping("/chi_tiet")
    public void deleteChiTietDonHang (@RequestBody int[] ids) { chiTietDonHangService.delete(ids); }

    @PostMapping("chi_tiet/list")
    public ResponseEntity<List<ChitietdonhangDTO>> saveList(@RequestBody List<ChitietdonhangDTO> list){
        return new ResponseEntity<>(chiTietDonHangService.saveList(list), HttpStatus.OK);
    }

//    @GetMapping("chi_tiet/donhang/{id}")
//
//    public  ResponseEntity<List<ChitietdonhangDTO>> getListByDonHang(@PathVariable("id") int id){
//        return new ResponseEntity<>(chiTietDonHangService.findByDonhang(id),HttpStatus.OK);
//    }

    @GetMapping("chi_tiet/donhang/{id}")
    public  ResponseEntity<List<Object[]>> listChiTietDonHang(@PathVariable("id") int id){
        List<Object[]> list = chiTietDonHangService.listChiTietDonHangByIDDonHang(id);
        return  new ResponseEntity<>(list,HttpStatus.OK);
    }
}
