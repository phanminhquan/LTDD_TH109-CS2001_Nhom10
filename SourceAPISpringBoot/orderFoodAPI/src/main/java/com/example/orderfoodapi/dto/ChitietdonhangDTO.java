package com.example.orderfoodapi.dto;

public class ChitietdonhangDTO {
    private Integer id;
    private Integer soLuong;
    private Integer idNhaHangFood;
    private Integer idDonHang;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSoLuong() {
        return this.soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getIdNhaHangFood() {
        return this.idNhaHangFood;
    }

    public void setIdNhaHangFood(Integer idNhaHangFood) {
        this.idNhaHangFood = idNhaHangFood;
    }

    public Integer getIdDonHang() {
        return this.idDonHang;
    }

    public void setIdDonHang(Integer idDonHang) {
        this.idDonHang = idDonHang;
    }
}
