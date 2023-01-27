/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vl.service;

import com.vl.pojos.BinhLuan;
import com.vl.pojos.NhaTuyenDung;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface NhaTuyenDungService{
    List<NhaTuyenDung> getNhaTuyenDung(String kw);
    List<NhaTuyenDung> getNhaTuyenDung();
    NhaTuyenDung getNhaTuyenDungID(int id);
    List<BinhLuan> getBinhLuan(int id);
    BinhLuan addBinhLuan(String bl, int ntdID);
    boolean addNTD(NhaTuyenDung ntd);
    NhaTuyenDung getNTDByMaTK(int maTK);
    boolean updateNTD(NhaTuyenDung ntd);
    boolean deleteNTD(NhaTuyenDung ntd);
    NhaTuyenDung getNTDByMaTTD(int maTTD);
    
}
