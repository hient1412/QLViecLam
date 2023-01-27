/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vl.service;


import com.vl.pojos.UngVien;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface UngVienService {
    List<UngVien> getUngVien();
    UngVien getUngVienID(int id);
    boolean addUV(UngVien uv);
    UngVien getUVByMaTK(int id);
    boolean updateUV(UngVien uv);
    boolean deleteUV(UngVien uv);
    UngVien getUVByTen(String tenUV);
}
