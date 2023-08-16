package com.example.orderfoodapi.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "GiaTien")
    private Double giaTien;

    @Column(name = "Avatar")
    private String avatar;

    @ManyToOne
    @JoinColumn(name = "Id_Loai")
    private Loaifood loaifood;

    @OneToMany(mappedBy = "food")
    private List<NhahangFood> nhahangFood = new ArrayList<>();
}
