package com.example.orderfoodapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "nhahang_food")
public class NhahangFood {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Id_NhaHang")
    private Nhahang nhahang;

    @ManyToOne
    @JoinColumn(name = "Id_Food")
    private Food food;

    @OneToMany(mappedBy = "nhahangFood")
    private List<Chitietdonhang> chitietdonhang = new ArrayList<>();

    @OneToMany(mappedBy = "nhahangFood")
    private List<Danhgia> danhgia = new ArrayList<>();

    @OneToMany(mappedBy = "nhahangFood")
    private List<Uudai> uudai = new ArrayList<>();

}
