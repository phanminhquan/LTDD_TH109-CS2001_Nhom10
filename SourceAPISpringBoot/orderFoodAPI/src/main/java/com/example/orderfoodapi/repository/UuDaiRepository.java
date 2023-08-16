package com.example.orderfoodapi.repository;

import com.example.orderfoodapi.entity.Uudai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UuDaiRepository extends JpaRepository<Uudai,Integer> {
    Uudai findUudaiById(int id);

    @Query(nativeQuery = true,value = "SELECT * FROM orderfood.uudai where now() >= ngay_batdau && now() <= ngay_ket_thuc;")
    List<Uudai> getUuDaiyNhaHang(@Param("id") int id);
}
