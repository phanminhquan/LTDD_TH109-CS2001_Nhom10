package com.example.orderfoodapi.service.impl;

import com.example.orderfoodapi.converter.ChiTietDonHangConverter;
import com.example.orderfoodapi.dto.ChitietdonhangDTO;
import com.example.orderfoodapi.entity.*;
import com.example.orderfoodapi.repository.ChiTietDonHangRepository;
import com.example.orderfoodapi.repository.DonHangRepository;
import com.example.orderfoodapi.repository.NhaHangFoodRepository;
import com.example.orderfoodapi.service.IChiTietDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChiTietDonHangService implements IChiTietDonHangService {

    @Autowired
    ChiTietDonHangRepository chiTietDonHangRepository;
    @Autowired
    ChiTietDonHangConverter chiTietDonHangConverter;
    @Autowired
    DonHangRepository donHangRepository;
    @Autowired
    NhaHangFoodRepository nhaHangFoodRepository;

    @Override
    public ChitietdonhangDTO save(ChitietdonhangDTO chitietdonhangDTO) {
        Chitietdonhang chitietdonhang = new Chitietdonhang();
        if (chitietdonhangDTO.getId() != null) {
            Chitietdonhang oldChitietdonhang = chiTietDonHangRepository.findChiTietDonHangById(chitietdonhangDTO.getId());
            chitietdonhang = chiTietDonHangConverter.toEntity(chitietdonhangDTO, oldChitietdonhang);
        } else chitietdonhang = chiTietDonHangConverter.toEntity(chitietdonhangDTO);
        Donhang donhang = donHangRepository.findDonHangById(chitietdonhangDTO.getIdDonHang());
        chitietdonhang.setDonhang(donhang);
        NhahangFood nhaHangFood = nhaHangFoodRepository.findNhahangFoodById(chitietdonhangDTO.getIdNhaHangFood());
        chitietdonhang.setNhahangFood(nhaHangFood);
        chitietdonhang = chiTietDonHangRepository.save(chitietdonhang);
        return chiTietDonHangConverter.toDTO(chitietdonhang);
    }

    @Override
    public void delete(int[] ids) {
        for (int item : ids) {
            chiTietDonHangRepository.deleteById(item);
        }
    }

    @Override
    public List<ChitietdonhangDTO> saveList(List<ChitietdonhangDTO> list) {
        for(ChitietdonhangDTO ct : list){
            ct = this.save(ct);
        }
        return list;
    }

    @Override
    public List<ChitietdonhangDTO> findByDonhang(int id){
        Donhang d = donHangRepository.findDonHangById(id);
        List<Chitietdonhang> list = chiTietDonHangRepository.findByDonhang(d);
        List<ChitietdonhangDTO> chitietdonhangDTOS = new ArrayList<>();
        for(Chitietdonhang ct: list){
            chitietdonhangDTOS.add(chiTietDonHangConverter.toDTO(ct));
        }
        return chitietdonhangDTOS;
    }

    @Override
    public List<Object[]> listChiTietDonHangByIDDonHang(int id) {
        List<Object[]> list  = chiTietDonHangRepository.ListChiTietDonHangByIDDonHang(id);
        return list;
    }

}
