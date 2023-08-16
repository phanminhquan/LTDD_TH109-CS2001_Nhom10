package com.example.orderfoodapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "chitietdonhang")
public class Chitietdonhang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @ManyToOne
    @JoinColumn(name = "Id_DonHang")
    private Donhang donhang;

    @ManyToOne
    @JoinColumn(name = "Id_NhaHang_Food")
    private NhahangFood nhahangFood;
}
