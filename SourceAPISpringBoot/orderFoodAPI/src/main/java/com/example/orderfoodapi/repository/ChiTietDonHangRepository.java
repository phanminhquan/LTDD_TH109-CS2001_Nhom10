package com.example.orderfoodapi.repository;

import com.example.orderfoodapi.entity.Chitietdonhang;
import com.example.orderfoodapi.entity.Donhang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChiTietDonHangRepository extends JpaRepository<Chitietdonhang,Integer> {
    Chitietdonhang findChiTietDonHangById(int id);
    List<Chitietdonhang> findByDonhang(Donhang donhang);
    @Query("select f.id,ct.soLuong,f.giaTien,ct.id from Chitietdonhang ct join NhahangFood nf on ct.nhahangFood.id = nf.id join Food  f on nf.food.id = f. id where ct.donhang.id = :id")
    List<Object[]> ListChiTietDonHangByIDDonHang(@Param("id") int id);
}
