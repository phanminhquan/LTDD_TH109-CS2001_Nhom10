package com.example.orderfoodapi.dto;

import com.example.orderfoodapi.entity.Loaifood;

import java.util.ArrayList;
import java.util.List;

public class FoodDTO {
    private Integer id;
    private String ten;
    private Double giaTien;
    private String avatar;
    private Integer idLoai;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return this.ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public Double getGiaTien() {
        return this.giaTien;
    }

    public void setGiaTien(Double giaTien) {
        this.giaTien = giaTien;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getIdLoai() {
        return this.idLoai;
    }

    public void setIdLoai(Integer idLoai) {
        this.idLoai = idLoai;
    }
}
