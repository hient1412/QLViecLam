/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.formatter;

import com.vl.pojos.TaiKhoan;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class TaiKhoanFormatter implements Formatter<TaiKhoan>{

    @Override
    public String print(TaiKhoan tk, Locale locale) {
        return String.valueOf(tk.getMaTK());
    }

    @Override
    public TaiKhoan parse(String tkID, Locale locale) throws ParseException {
        TaiKhoan tk = new TaiKhoan();
        tk.setMaTK(Integer.parseInt(tkID));
        return tk;
    }
    
}
