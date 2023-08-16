package com.example.orderfoodapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name="Ten")
    private String ten;

    @Column(name = "TaiKhoan")
    private String taiKhoan;

    @Column(name = "MatKhau")
    private String matKhau;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "SoDienThoai")
    private String soDienThoai;

    @Column(name = "Quyen")
    private Integer quyen;

    @Column(name = "Email")
    private String email;

    @Column(name = "Avatar")
    private String avatar;
    @OneToMany(mappedBy = "user")
    private List<Donhang> donhang = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    private List<UserUudai> userUudai = new ArrayList<>();


    @OneToMany(mappedBy = "user")
    private List<Danhgia> danhgia = new ArrayList<>();

}

