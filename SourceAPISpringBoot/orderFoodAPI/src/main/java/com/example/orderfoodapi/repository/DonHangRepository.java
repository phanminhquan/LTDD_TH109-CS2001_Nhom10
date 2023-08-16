package com.example.orderfoodapi.repository;

import com.example.orderfoodapi.entity.Donhang;
import com.example.orderfoodapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonHangRepository extends JpaRepository<Donhang,Integer> {
    Donhang findDonHangById(int id);
    List<Donhang> findAllByUser(User user);

    @Query("select d.id,n.id,d.trangThai,d.ngayGio from " +
            "Donhang d " +
            "join Chitietdonhang ct on ct.donhang.id = d.id " +
            "join NhahangFood nf on nf.id = ct.nhahangFood.id " +
            "join Nhahang n on n.id = nf.nhahang.id " +
            "where d.user.id = :iduser " +
            "group by  d.id,n.id,d.trangThai,d.ngayGio")
    List<Object[]> customResponseDonHangUI(@Param("iduser") int iduser);
}
