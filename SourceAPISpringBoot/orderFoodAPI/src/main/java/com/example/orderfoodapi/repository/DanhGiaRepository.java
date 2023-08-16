package com.example.orderfoodapi.repository;

import com.example.orderfoodapi.entity.Danhgia;
import com.example.orderfoodapi.entity.Food;
import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DanhGiaRepository extends JpaRepository<Danhgia,Integer> {
    Danhgia findDanhGiaById(int id);

    @Query(nativeQuery = true, value = "select f.* from orderfood.danhgia f join orderfood.nhahang_food nhf on f.id_nha_hang_food = nhf.id  where nhf.id = :id order by f.id desc ")
    List<Danhgia> getListDanhGiaByNhaHang(@Param("id") int id);
}
