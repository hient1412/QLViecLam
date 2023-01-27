/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vl.repository;

import com.vl.pojos.TaiKhoan;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface TaiKhoanRepository {
    boolean addTaiKhoan(TaiKhoan tk);
    List<TaiKhoan> getTK(String tk);
    TaiKhoan getTKByID(int maTK);
    TaiKhoan getTKByTen(String taiKhoan);
    List<TaiKhoan> getLoaiTK(String loaiTK, int page, int trangThai);
    boolean updateTT(TaiKhoan tk);
    List<TaiKhoan> getTK(int page);
    boolean deleteTK(TaiKhoan tk);
    boolean updateTK(TaiKhoan tk);
    List<Object[]> countLoaiTK();
    
}
