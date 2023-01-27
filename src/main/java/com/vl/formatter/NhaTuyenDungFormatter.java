/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.formatter;

import com.vl.pojos.NhaTuyenDung;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class NhaTuyenDungFormatter implements Formatter<NhaTuyenDung>{

    @Override
    public String print(NhaTuyenDung ntd, Locale locale) {
        return String.valueOf(ntd.getMaNTD());
    }

    @Override
    public NhaTuyenDung parse(String ntdID, Locale locale) throws ParseException {
        NhaTuyenDung ntd = new NhaTuyenDung();
        ntd.setMaNTD(Integer.parseInt(ntdID));
        return ntd;
    }
    
}
