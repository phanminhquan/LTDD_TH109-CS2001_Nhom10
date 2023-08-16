package com.example.orderfoodapi.service.impl;

import com.example.orderfoodapi.converter.NhaHangConverter;
import com.example.orderfoodapi.dto.FoodDTO;
import com.example.orderfoodapi.dto.NhahangDTO;
import com.example.orderfoodapi.entity.Food;
import com.example.orderfoodapi.entity.Nhahang;
import com.example.orderfoodapi.repository.NhaHangRepository;
import com.example.orderfoodapi.service.INhaHangService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.apache.commons.lang3.reflect.Typed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Service
public class NhaHangService implements INhaHangService {

    @Autowired
    private NhaHangConverter nhaHangConverter;

    @Autowired
    private NhaHangRepository nhaHangRepository;
    @Override
    public NhahangDTO save(NhahangDTO nhahangDTO) {
        Nhahang nhahang = new Nhahang();
        if(nhahangDTO.getId() != null){
            Nhahang oldNhahang = nhaHangRepository.findNhahangById(nhahangDTO.getId());
            nhahang = nhaHangConverter.toEntity(nhahangDTO,oldNhahang);
        }else{
            nhahang = nhaHangConverter.toEntity(nhahangDTO);
        }
        nhahang = nhaHangRepository.save(nhahang);
        return nhaHangConverter.toDTO(nhahang);
    }

    @Override
    public void delete(int[] ids) {
        for(int item : ids)
        {
            nhaHangRepository.deleteById(item);
        }
    }

    @Override
    public List<NhahangDTO> getAllNhaHang(int id) {
        List<Nhahang> nhahangs = nhaHangRepository.finAllNhaHangByLoaiFood(id);
        List<NhahangDTO> nhahangDTOS = new ArrayList<NhahangDTO>();
        for(Nhahang f : nhahangs){
            NhahangDTO nhahangDTO = nhaHangConverter.toDTO(f);
            nhahangDTOS.add(nhahangDTO);
        }
        return nhahangDTOS;
    }

    @Override
    public List<NhahangDTO> getlist() {
        List<Nhahang> nhahang = nhaHangRepository.findAll();
        List<NhahangDTO> nhahangDTO = new ArrayList<>();
        for(Nhahang f : nhahang){
            NhahangDTO nhahangD = nhaHangConverter.toDTO(f);
            nhahangDTO.add(nhahangD);
        }
        return nhahangDTO;
    }

    @Override
    public List<NhahangDTO> getListTop() {
        List<Nhahang> list = nhaHangRepository.TopNhaHang();
        List<NhahangDTO> nhahangDTOS = new ArrayList<NhahangDTO>();
        for(Nhahang f : list){
            NhahangDTO nhdto = nhaHangConverter.toDTO(f);
            nhahangDTOS.add(nhdto);
        }
        return nhahangDTOS;
    }

    @Override
    public double getRatingOfRestarant(int id) {
        return nhaHangRepository.getRatingOfRestautrant(id);
    }

    @Override
    public int countRate(int id) {
        return nhaHangRepository.countRateOFRestautrant(id);
    }

    @Override
    public List<NhahangDTO> getListNhaHangByFoodSeacrch(String kw) {
        List<NhahangDTO> nhahangDTOS = new ArrayList<>();
        for(Nhahang n : nhaHangRepository.getNhaHangByFoodSearch(kw)){
            nhahangDTOS.add(nhaHangConverter.toDTO(n));
        }
        return nhahangDTOS;
    }

    @Override
    public NhahangDTO getNhaHangById(int id) {
        return nhaHangConverter.toDTO(nhaHangRepository.findNhahangById(id));
    }
}
