package com.example.orderfoodapi.service.impl;

import com.example.orderfoodapi.converter.DonHangConVerter;
import com.example.orderfoodapi.dto.DonhangDTO;
import com.example.orderfoodapi.entity.Danhgia;
import com.example.orderfoodapi.entity.Donhang;

import com.example.orderfoodapi.entity.Nhahang;
import com.example.orderfoodapi.entity.User;
import com.example.orderfoodapi.repository.DonHangRepository;

import com.example.orderfoodapi.repository.UserReponsitory;
import com.example.orderfoodapi.service.IDonHangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class DonHangService implements IDonHangService {

    @Autowired
    DonHangRepository donHangRepository;

    @Autowired
    UserReponsitory userReponsitory;

    @Autowired
    DonHangConVerter donHangConVerter;




    @Override
    public DonhangDTO save(DonhangDTO donhangDTO) {
        Donhang donhang = new Donhang();
        if (donhangDTO.getId() != null) {
            Donhang oldDonHang= donHangRepository.findDonHangById(donhangDTO.getId());
            donhang = donHangConVerter.toEntity(donhangDTO, oldDonHang);
        } else donhang = donHangConVerter.toEntity(donhangDTO);
        User user = userReponsitory.findUserById(donhangDTO.getIdUser());
        donhang.setUser(user);
        donhang = donHangRepository.save(donhang);
        return donHangConVerter.toDTO(donhang);
    }

    @Override
    public void delete(int[] ids) {
        for (int item : ids) {
            donHangRepository.deleteById(item);
        }
    }

    @Override
    public DonhangDTO UpdateTrangThai(int id, Map<String, Object> obj) {
        Donhang d = donHangRepository.findDonHangById(id);
        int trangthai =Integer.parseInt(obj.get("trangThai").toString());
        d.setTrangThai(trangthai);
        d = donHangRepository.save(d);
        return donHangConVerter.toDTO(d);
    }


    @Override
    public List<DonhangDTO> getAll() {
        List<DonhangDTO> list = new ArrayList<>();
        for(Donhang d: donHangRepository.findAll()){
            list.add(donHangConVerter.toDTO(d));
        }
        return  list;
    }

    @Override
    public List<DonhangDTO> getListDonHangByUserId(int id) {
        User user = userReponsitory.findUserById(id);
        List<Donhang> list = donHangRepository.findAllByUser(user);
        List<DonhangDTO> listDTO = new ArrayList<>();
        for(Donhang d: list){
            listDTO.add(donHangConVerter.toDTO(d));
        }
        return  listDTO;
    }

    @Override
    public List<Object[]> customResponseDonHangUI(int idUser) {
        return donHangRepository.customResponseDonHangUI(idUser);
    }

}
