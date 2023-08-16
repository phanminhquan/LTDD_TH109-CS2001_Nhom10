package com.example.orderfoodapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "donhang")
public class Donhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "TrangThai")
    private Integer trangThai;

    @Column(name = "TongTien")
    private double tongtien;

    @Column(name = "NgayGio")
    private Date ngayGio;

    @Column(name = "GhiChu")
    private String ghiChu;



    @ManyToOne
    @JoinColumn(name = "Id_user")
    private User user;

    @OneToMany(mappedBy = "donhang")
    private List<Chitietdonhang> chitietdonhang = new ArrayList<>();

}
