/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vl.repository;

import com.vl.pojos.LoaiVL;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface LoaiVLRepository {
    List<LoaiVL> getLoaiVL(int page);
    LoaiVL getLoaiVLByID(int id);
    boolean deleteLoaiVL(int id);
    boolean updateLoaiVL(LoaiVL vl);
    boolean addLoaiVL(LoaiVL vl);
    LoaiVL getLVLByMaTTD(int maTTD);
    List<LoaiVL> getLoaiVL();
}
