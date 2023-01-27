/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.service.imply;

import com.vl.pojos.Admin;
import com.vl.repository.AdminRepository;
import com.vl.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class AdminServiceImply implements AdminService{

    @Autowired
    private AdminRepository adminRepository;
    
    @Override
    public Admin getAdminByMaTK(int maTK) {
        return this.adminRepository.getAdminByMaTK(maTK);
    }

    @Override
    public Admin getAdminID(int id) {
        return this.adminRepository.getAdminID(id);
    }

    @Override
    public boolean updateAdmin(Admin ad) {
        return this.adminRepository.updateAdmin(ad);
    }
    
}
