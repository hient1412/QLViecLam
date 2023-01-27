/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.service.imply;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vl.pojos.BinhLuan;
import com.vl.pojos.NhaTuyenDung;
import com.vl.repository.NhaTuyenDungRepository;
import com.vl.service.NhaTuyenDungService;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class NhaTuyenDungServiceImply implements NhaTuyenDungService{
    @Autowired
    private NhaTuyenDungRepository nhaTuyenDungRepository;

    @Autowired
    private Cloudinary cloudinary;
    
    @Override
    public List<NhaTuyenDung> getNhaTuyenDung(String kw) {
        return this.nhaTuyenDungRepository.getNhaTuyenDung(kw);
    }

    @Override
    public List<NhaTuyenDung> getNhaTuyenDung() {
        return this.nhaTuyenDungRepository.getNhaTuyenDung();
    }

    @Override
    public NhaTuyenDung getNhaTuyenDungID(int id) {
        return this.nhaTuyenDungRepository.getNhaTuyenDungID(id);
    }

    @Override
    public List<BinhLuan> getBinhLuan(int id) {
        return this.nhaTuyenDungRepository.getBinhLuan(id);
    }

    @Override
    public BinhLuan addBinhLuan(String bl, int ntdID) {
        return this.nhaTuyenDungRepository.addBinhLuan(bl, ntdID);
    }

    @Override
    public boolean addNTD(NhaTuyenDung ntd) {
        ntd.setMaTK(ntd.getMaTK());
        if (!ntd.getFile().isEmpty() || (ntd.getAvatar() != null)) {
            try {
                Map r = this.cloudinary.uploader().upload(ntd.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                ntd.setAvatar((String) r.get("secure_url"));
                return this.nhaTuyenDungRepository.addNTD(ntd);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else{
            ntd.setAvatar("https://png.pngtree.com/element_our/png_detail/20181229/vector-shop-icon-png_302739.jpg");
            return this.nhaTuyenDungRepository.addNTD(ntd);
        }
        return this.nhaTuyenDungRepository.addNTD(ntd);
    }

    @Override
    public NhaTuyenDung getNTDByMaTK(int maTK) {
        return this.nhaTuyenDungRepository.getNTDByMaTK(maTK);
    }

    @Override
    public boolean updateNTD(NhaTuyenDung ntd) {
        if (!ntd.getFile().isEmpty()) {
            try {
                Map r = this.cloudinary.uploader().upload(ntd.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                ntd.setAvatar((String) r.get("secure_url"));
                return this.nhaTuyenDungRepository.updateNTD(ntd);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else{
            ntd.setAvatar("https://png.pngtree.com/element_our/png_detail/20181229/vector-shop-icon-png_302739.jpg");
            return this.nhaTuyenDungRepository.updateNTD(ntd);
        }
        return this.nhaTuyenDungRepository.updateNTD(ntd);
    }

    @Override
    public boolean deleteNTD(NhaTuyenDung ntd) {
        return this.nhaTuyenDungRepository.deleteNTD(ntd);
    }

    @Override
    public NhaTuyenDung getNTDByMaTTD(int maTTD) {
        return this.nhaTuyenDungRepository.getNTDByMaTTD(maTTD);
    }
}
