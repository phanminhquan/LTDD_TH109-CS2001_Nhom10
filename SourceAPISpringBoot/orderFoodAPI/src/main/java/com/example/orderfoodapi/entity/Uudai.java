package com.example.orderfoodapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter

@Entity
@Table(name = "uudai")
public class Uudai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "NoiDung")
    private String noiDung;

    @Column(name = "GiaTri")
    private Integer giaTri;

    @Column(name = "NgayBatdau")
    private Date ngayBatdau;

    @Column(name = "NgayKetThuc")
    private Date ngayKetThuc;

    @Column(name = "HinhAnh")
    private String hinhAnh;

    @Column(name = "Loai")
    private String loai;

    @ManyToOne
    @JoinColumn(name = "Id_NhaHangFood")
    private NhahangFood nhahangFood;

    @OneToMany(mappedBy = "uudai")
    private List<UserUudai> userUudai = new ArrayList<>();

}
