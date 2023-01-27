/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vl.service;

import com.vl.pojos.Admin;

/**
 *
 * @author DELL
 */
public interface AdminService {
    Admin getAdminByMaTK(int maTK);
    Admin getAdminID(int id);
    boolean updateAdmin(Admin ad);
}
