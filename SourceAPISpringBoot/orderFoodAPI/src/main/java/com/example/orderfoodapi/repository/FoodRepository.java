package com.example.orderfoodapi.repository;

import com.example.orderfoodapi.dto.FoodDTO;
import com.example.orderfoodapi.entity.Food;
import com.example.orderfoodapi.entity.Loaifood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {
    Food findFoodById(int id);


    List<Food> findFoodsByTenContaining(String ten);

    List<Food> findByTenIsContainingIgnoreCase(String ten);

    List<Food> findAllByLoaifood(Loaifood loaifood);
    @Query("select f from Food f join NhahangFood nhf on f.id = nhf.food.id join Nhahang n on nhf.nhahang.id = n.id where n.id = :id")
    List<Food> getListFoodByNhaHang(@Param("id") int id);

    @Query(nativeQuery = true ,value = "SELECT f.*,ct.id FROM orderfood.food f join orderfood.nhahang_food nf on f.id = nf.id_food join orderfood.chitietdonhang ct on ct.id_nha_hang_food = nf.id join orderfood.donhang d on d.id = ct.id_don_hang where d.id = :id group by f.id,ct.id")
    List<Object[]> getFoodByDonHang(@Param("id") int id);
}