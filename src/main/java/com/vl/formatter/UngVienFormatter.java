/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.formatter;

import com.vl.pojos.UngVien;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class UngVienFormatter implements Formatter<UngVien>{

    @Override
    public String print(UngVien uv, Locale locale) {
        return String.valueOf(uv.getMaUV());
    }

    @Override
    public UngVien parse(String uvID, Locale locale) throws ParseException {
        UngVien uv = new UngVien();
        uv.setMaUV(Integer.parseInt(uvID));
        return uv;
    }
    
}
