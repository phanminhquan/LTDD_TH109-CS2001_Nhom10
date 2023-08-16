package com.example.orderfoodapi.controller;

import com.example.orderfoodapi.dto.FoodDTO;
import com.example.orderfoodapi.entity.Food;
import com.example.orderfoodapi.repository.FoodRepository;
import com.example.orderfoodapi.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin("*")
@RestController
public class FoodController {
    @Autowired
    private IFoodService foodService;

    @Autowired
    private FoodRepository foodRepository;


    @PostMapping("/food")
    public FoodDTO createFood(@RequestBody FoodDTO model) {
        return foodService.save(model);
    }

    @PutMapping("/food/{id}")
    public FoodDTO updateFood(@RequestBody FoodDTO model, @PathVariable("id") int id) {
        model.setId(id);
        return foodService.save(model);
    }

    @DeleteMapping("/food")
    public void deleteFood(@RequestBody int[] ids) {
        foodService.delete(ids);
    }

    @GetMapping("/food")
    public ResponseEntity<List<FoodDTO>> getAllFood() {
        return ResponseEntity.ok().body(foodService.findAll());
    }

    @GetMapping("/food/{id}")
    public ResponseEntity<FoodDTO> findFoodByID(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(foodService.getFoodByID(id));
    }

    @GetMapping("/food/name")
    public ResponseEntity<List<FoodDTO>> getFoodbyName(@RequestParam(defaultValue = "") String kw){
        return ResponseEntity.ok().body(foodService.findByName(kw));
    }

    @GetMapping ("/food/loaifood/{id}")
    public ResponseEntity<List<FoodDTO>> getFoodByLoai(@PathVariable("id") int id){
        return ResponseEntity.ok().body(foodService.findFoodByLoaiFood(id));
    }
    @GetMapping("/food/nhahang/{id}/")
    public ResponseEntity<List<FoodDTO>> getFoodbyNhaHang(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(foodService.getListFoodByNhaHang(id));
    }

    @GetMapping("/food/donhang/{id}")
    public ResponseEntity<List<Object[]>> getFoodbyDonHang(@PathVariable("id") int id) {
        return ResponseEntity.ok().body(foodService.getFoodByDonHang(id));
    }

//    @RequestMapping(value = "/yourPath/{studentName}")
//    public ResponseEntity<Student> findByName(@pathVariable("studentName") String name) {
//        Student student = studentRepository.findByName(name);
//
//        if(student == null){
//            //handler your own exception here
//        }
//
//        //show the student as json object
//        return ResponseEntity.status(HttpStatus.OK).body(student);
//    }
}

