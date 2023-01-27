/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.service.imply;

import com.vl.pojos.TinTuyenDung;
import com.vl.pojos.UngTuyen;
import com.vl.repository.TinTuyenDungRepository;
import com.vl.service.TinTuyenDungService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class TinTuyenDungServiceImply implements TinTuyenDungService {

    @Autowired
    private TinTuyenDungRepository tinTuyenDungRepository;

    @Override
    public List<TinTuyenDung> getTinTuyenDung(Map<String, String> params, int page) {
        return this.tinTuyenDungRepository.getTinTuyenDung(params, page);
    }

    @Override
    public long countTinTuyenDung() {
        return this.tinTuyenDungRepository.countTinTuyenDung();
    }

    @Override
    public List<TinTuyenDung> getTinTuyenDung(int page) {
        return this.tinTuyenDungRepository.getTinTuyenDung(page);
    }

    @Override
    public boolean addTinTuyenDung(TinTuyenDung ttd) {
        return this.tinTuyenDungRepository.addTinTuyenDung(ttd);
    }

    @Override
    public TinTuyenDung getTinTuyenDungId(int id) {
        return this.tinTuyenDungRepository.getTinTuyenDungId(id);
    }

    @Override
    public List<Object[]> getTinTuyenDungJoin(int page) {
        return this.tinTuyenDungRepository.getTinTuyenDungJoin(page);
    }

    @Override
    public List<Object[]> getTinTuyenDungJoinID(int id) {
        return this.tinTuyenDungRepository.getTinTuyenDungJoinID(id);
    }

    @Override
    public List<Object[]> getTinTuyenDungJoin(Map<String, String> params, int page) {
        return this.tinTuyenDungRepository.getTinTuyenDungJoin(params, page);
    }

    @Override
    public List<Object[]> getTinTuyenDungBykw(String kw, int page) {
        return this.tinTuyenDungRepository.getTinTuyenDungBykw(kw, page);
    }

    @Override
    public List<Object[]> getTinTuyenDungByMaNTD(int maNTD, int page) {
        return this.tinTuyenDungRepository.getTinTuyenDungByMaNTD(maNTD, page);
    }


    @Override
    public boolean deleteTTD(TinTuyenDung ttd) {
        return this.tinTuyenDungRepository.deleteTTD(ttd);
    }

    @Override
    public boolean updateTTD(TinTuyenDung ttd) {
        return this.tinTuyenDungRepository.updateTTD(ttd);
    }

    @Override
    public List<Object[]> countTTDByLoaiVL() {
        return this.tinTuyenDungRepository.countTTDByLoaiVL();
    }


}
