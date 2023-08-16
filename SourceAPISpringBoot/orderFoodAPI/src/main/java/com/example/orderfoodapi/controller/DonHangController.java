package com.example.orderfoodapi.controller;




import com.example.orderfoodapi.dto.DonhangDTO;
import com.example.orderfoodapi.service.impl.DonHangService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class DonHangController {
    @Autowired
    DonHangService donHangService;
    @PostMapping("/donhang")
    public DonhangDTO create(@RequestBody DonhangDTO model) {
        return donHangService.save(model);
    }
    @PutMapping("/donhang/{id}")
    public DonhangDTO update(@RequestBody DonhangDTO model, @PathVariable("id") int id) {
        model.setId(id);
        return donHangService.save(model);
    }

    @DeleteMapping("/donhang")
    public void delete (@RequestBody int[] ids) { donHangService.delete(ids); }

    @PatchMapping("/donhang/{id}")
    public ResponseEntity<DonhangDTO> updateTrangthai(@PathVariable("id") int id,@RequestBody Map<String, Object> field){
        return new ResponseEntity<>(donHangService.UpdateTrangThai(id,field), HttpStatus.NO_CONTENT);
    }

    @GetMapping("/donhang")
    public ResponseEntity<List<DonhangDTO>> getListDonhang(){
        return new ResponseEntity<>(donHangService.getAll(),HttpStatus.OK);
    }

    @GetMapping("/donhang/user/{id}")
    public ResponseEntity<List<DonhangDTO>> getListDonhangByUser(@PathVariable("id") int id){
        return  new ResponseEntity<>(donHangService.getListDonHangByUserId(id),HttpStatus.OK);
    }
    @GetMapping("/donhangui/{iduser}")
    public  ResponseEntity<List<Object[]>> ListDonHangUI(@PathVariable("iduser") int id){
        return new ResponseEntity<>(donHangService.customResponseDonHangUI(id),HttpStatus.OK);
    }

}
