/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.formatter;

import com.vl.pojos.LoaiVL;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class LoaiVLFormatter implements Formatter<LoaiVL>{

    @Override
    public String print(LoaiVL loaiVL, Locale locale) {
        return String.valueOf(loaiVL.getMaLoaiVL());
    }

    @Override
    public LoaiVL parse(String maLoaiVL, Locale locale) throws ParseException {
        LoaiVL ntd = new LoaiVL();
        ntd.setMaLoaiVL(Integer.parseInt(maLoaiVL));
        return ntd;
    }
    
}
