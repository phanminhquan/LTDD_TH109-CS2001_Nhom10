package com.example.orderfoodapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

@Entity
@Table(name = "danhgia")
public class Danhgia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "NoiDung")
    private String noiDung;

    @Column(name = "GiaTien")
    private Double giaTien;

    @Column(name = "Rate")
    private Integer rate;

    @ManyToOne
    @JoinColumn(name = "Id_NhaHangFood")
    private NhahangFood nhahangFood;

    @ManyToOne
    @JoinColumn(name = "Id_User")
    private User user;
}
