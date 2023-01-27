/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vl.repository;

import com.vl.pojos.UngVien;
import com.vl.pojos.UngTuyen;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface UngVienRepository {
    List<UngVien> getUngVien();
    UngVien getUngVienID(int id);
    boolean addUV(UngVien uv);
    UngVien getUVByMaTK(int id);
    boolean updateUV(UngVien uv);
    boolean deleteUV(UngVien uv);
    UngVien getUVByTen(String tenUV);
}
