/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.service.imply;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.vl.pojos.UngVien;
import com.vl.repository.UngVienRepository;
import com.vl.service.UngVienService;
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
public class UngVienServiceImply implements UngVienService {

    @Autowired
    private UngVienRepository ungVienRepository;

    @Autowired
    private Cloudinary cloudinary;

    @Override
    public List<UngVien> getUngVien() {
        return this.ungVienRepository.getUngVien();
    }

    @Override
    public UngVien getUngVienID(int id) {
        return this.ungVienRepository.getUngVienID(id);
    }

    @Override
    public boolean addUV(UngVien uv) {
        uv.setMaTK(uv.getMaTK());
        uv.setGioiTinh(uv.getGioiTinh());
        if (!uv.getFile().isEmpty() || (uv.getAvatar() != null)) {
            try {
                Map r = this.cloudinary.uploader().upload(uv.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                uv.setAvatar((String) r.get("secure_url"));
                return this.ungVienRepository.addUV(uv);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        } else if ("Nam".equals(uv.getGioiTinh())) {
            uv.setAvatar("https://scr.vn/wp-content/uploads/2020/07/Avatar-Facebook-tr%E1%BA%AFng.jpg");
            return this.ungVienRepository.addUV(uv);
        } else {
            uv.setAvatar("https://scr.vn/wp-content/uploads/2020/07/%E1%BA%A2nh-%C4%91%E1%BA%A1i-di%E1%BB%87n-FB-m%E1%BA%B7c-%C4%91%E1%BB%8Bnh-n%E1%BB%AF.jpg");
            return this.ungVienRepository.addUV(uv);
        }
        return this.ungVienRepository.addUV(uv);
    }

    @Override
    public UngVien getUVByMaTK(int id) {
        return this.ungVienRepository.getUVByMaTK(id);
    }

    @Override
    public boolean updateUV(UngVien uv) {
        if (!uv.getFile().isEmpty()) {
            try {
                Map r = this.cloudinary.uploader().upload(uv.getFile().getBytes(), ObjectUtils.asMap("resource_type", "auto"));
                uv.setCv((String) r.get("secure_url"));
                return this.ungVienRepository.updateUV(uv);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return this.ungVienRepository.updateUV(uv);
    }

    @Override
    public boolean deleteUV(UngVien uv) {
        return this.ungVienRepository.deleteUV(uv);
    }

    @Override
    public UngVien getUVByTen(String tenUV) {
        return this.ungVienRepository.getUVByTen(tenUV);
    }
}
