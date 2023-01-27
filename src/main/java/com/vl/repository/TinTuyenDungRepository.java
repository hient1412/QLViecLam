/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vl.repository;

import com.vl.pojos.TinTuyenDung;
import com.vl.pojos.UngTuyen;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author DELL
 */
public interface TinTuyenDungRepository {
    List<TinTuyenDung> getTinTuyenDung(Map<String,String> params,int page);
    List<TinTuyenDung> getTinTuyenDung(int page);
    List<Object[]> getTinTuyenDungJoin(Map<String,String> params,int page);
    List<Object[]> getTinTuyenDungJoin(int page);
    List<Object[]> getTinTuyenDungJoinID(int id);
    TinTuyenDung getTinTuyenDungId(int TinTuyenDungId);
    long countTinTuyenDung();
    boolean addTinTuyenDung(TinTuyenDung t);
    List<Object[]> getTinTuyenDungBykw(String kw, int page);
    List<Object[]> getTinTuyenDungByMaNTD(int maNTD, int page);
    boolean deleteTTD(TinTuyenDung ttd);
    boolean updateTTD(TinTuyenDung ttd);
    List<Object[]> countTTDByLoaiVL();
}
