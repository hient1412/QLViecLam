/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.vl.repository;

import com.vl.pojos.UngTuyen;
import java.util.List;

/**
 *
 * @author DELL
 */
public interface UngTuyenRepository {
    List<UngTuyen> getUngTuyen(int maTTD);
    boolean addUngTuyen(UngTuyen ut);
    List<Object[]> getUngTuyenByMaUV(int maUV);
    List<Object[]> getUngTuyenByMaNTD(int maNTD);
}
