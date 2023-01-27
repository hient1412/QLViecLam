/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.service.imply;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vl.pojos.TaiKhoan;
import com.vl.repository.TaiKhoanRepository;
import com.vl.service.TaiKhoanService;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service("userDetailsService")
public class TaiKhoanServiceImply implements TaiKhoanService {

    @Autowired
    private TaiKhoanRepository taiKhoanRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public TaiKhoan getTKByID(int maTK) {
        return this.taiKhoanRepository.getTKByID(maTK);
    }

    @Override
    public UserDetails loadUserByUsername(String taiKhoan) throws UsernameNotFoundException {
        List<TaiKhoan> tks = this.getTK(taiKhoan);
        if (tks.isEmpty()) {
            throw new UsernameNotFoundException("Tên tài khoản không tồn tại !!!");
        }
        TaiKhoan tk = tks.get(0);
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(tk.getLoaiTK()));
        return new User(tk.getTaiKhoan(), tk.getMatKhau(), authorities);
    }

    @Override
    public boolean addTK(TaiKhoan tk) {
        String password = tk.getMatKhau();
        tk.setMatKhau(this.passwordEncoder.encode(password));
        tk.setLoaiTK(tk.getLoaiTK());
        return this.taiKhoanRepository.addTaiKhoan(tk);
    }

    @Override
    public List<TaiKhoan> getTK(String tk) {
        return this.taiKhoanRepository.getTK(tk);
    }

    @Override
    public TaiKhoan getTKByTen(String tk) {
        return this.taiKhoanRepository.getTKByTen(tk);
    }

    @Override
    public List<TaiKhoan> getLoaiTK(String loaiTK, int page, int trangThai) {
        return this.taiKhoanRepository.getLoaiTK(loaiTK, page, trangThai);
    }
    
    @Override
    public boolean updateTT(TaiKhoan tk) {
        tk.setTrangThai(tk.getTrangThai());
        return this.taiKhoanRepository.updateTT(tk);
    }

    @Override
    public List<TaiKhoan> getTK(int page) {
        return this.taiKhoanRepository.getTK(page);
    }

    @Override
    public boolean deleteTK(TaiKhoan tk) {
        return this.taiKhoanRepository.deleteTK(tk);
    }

    @Override
    public boolean updateTK(TaiKhoan tk) {
        String password = tk.getMatKhau();
        tk.setMatKhau(this.passwordEncoder.encode(password));
        return this.taiKhoanRepository.updateTK(tk);
    }

    @Override
    public List<Object[]> countLoaiTK() { 
        return this.taiKhoanRepository.countLoaiTK();
    }

}
