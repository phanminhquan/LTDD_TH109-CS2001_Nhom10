package com.example.orderfoodapi.repository;

import com.example.orderfoodapi.entity.Food;
import com.example.orderfoodapi.entity.Nhahang;
import com.example.orderfoodapi.entity.NhahangFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NhaHangFoodRepository extends JpaRepository<NhahangFood,Integer> {
    NhahangFood findNhahangFoodById(int id);
    List<NhahangFood> findByNhahangAndFood(Nhahang n, Food f);
}
