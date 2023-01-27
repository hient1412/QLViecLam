/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vl.service;

import com.vl.pojos.TaiKhoan;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author DELL
 */
public interface TaiKhoanService extends UserDetailsService{
    TaiKhoan getTKByID(int maTK);
    boolean addTK(TaiKhoan tk);
    List<TaiKhoan> getTK(String taiKhoan);
    TaiKhoan getTKByTen(String taiKhoan);
    List<TaiKhoan> getLoaiTK(String loaiTK, int page, int trangThai);
    boolean updateTT(TaiKhoan tk);
    List<TaiKhoan> getTK(int page);
    boolean deleteTK(TaiKhoan tk);
    boolean updateTK(TaiKhoan tk);
    List<Object[]> countLoaiTK();
}
