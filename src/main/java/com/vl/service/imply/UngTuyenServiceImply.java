/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.service.imply;

import com.vl.pojos.UngTuyen;
import com.vl.repository.UngTuyenRepository;
import com.vl.service.UngTuyenService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class UngTuyenServiceImply implements UngTuyenService{
    @Autowired
    private UngTuyenRepository ungTuyenRepository;
    
    @Override
    public List<UngTuyen> getUngTuyen(int maTTD) {
        return this.ungTuyenRepository.getUngTuyen(maTTD);
    }

    @Override
    public boolean addUngTuyen(UngTuyen ut) {
        return this.ungTuyenRepository.addUngTuyen(ut);
    }

    @Override
    public List<Object[]> getUngTuyenByMaUV(int maUV) {
        
        return this.ungTuyenRepository.getUngTuyenByMaUV(maUV);
    }

    @Override
    public List<Object[]> getUngTuyenByMaNTD(int maNTD) {
        return this.ungTuyenRepository.getUngTuyenByMaNTD(maNTD);
    }

}
