/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.service.imply;

import com.vl.pojos.LoaiVL;
import com.vl.repository.LoaiVLRepository;
import com.vl.service.LoaiVLService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class LoaiVLServiceImply implements LoaiVLService{

    @Autowired
    private LoaiVLRepository loaiVLRepository;
    
    @Override
    public List<LoaiVL> getLoaiVL(int page) {
        return this.loaiVLRepository.getLoaiVL(page);
    }

    @Override
    public LoaiVL getLoaiVLByID(int id) {
        return this.loaiVLRepository.getLoaiVLByID(id);
    }

    @Override
    public boolean deleteLoaiVL(int id) {
        return this.loaiVLRepository.deleteLoaiVL(id);
    }

    @Override
    public boolean updateLoaiVL(LoaiVL vl) {
        return this.loaiVLRepository.updateLoaiVL(vl);
    }

    @Override
    public boolean addLoaiVL(LoaiVL vl) {
        return this.loaiVLRepository.addLoaiVL(vl);
    }

    @Override
    public LoaiVL getLVLByMaTTD(int maTTD) {
        return this.loaiVLRepository.getLVLByMaTTD(maTTD);
    }

    @Override
    public List<LoaiVL> getLoaiVL() {
        return this.loaiVLRepository.getLoaiVL();
    }
    
}
