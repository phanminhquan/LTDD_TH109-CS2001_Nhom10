package com.example.orderfoodapi.controller;

import com.example.orderfoodapi.dto.UserUudaiDTO;
import com.example.orderfoodapi.entity.User;
import com.example.orderfoodapi.service.impl.UserUuDaiService;
import com.example.orderfoodapi.service.impl.UuDaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserUuDaiController {
    @Autowired
    private UserUuDaiService userUuDaiService;

    @PostMapping("/user_uudai")
    public UserUudaiDTO create(@RequestBody UserUudaiDTO model){return userUuDaiService.save(model);}

    @PutMapping("/user_uudai/{id}")
    public UserUudaiDTO update(@RequestBody UserUudaiDTO model, @PathVariable("id") int id){
        model.setId(id);
        return userUuDaiService.save(model);
    }
    @DeleteMapping("/user_uudai")
    public void delete(@RequestBody int[] ids){
        userUuDaiService.delete(ids);
    }
}
