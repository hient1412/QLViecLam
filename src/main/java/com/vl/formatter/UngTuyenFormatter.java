/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.formatter;

import com.vl.pojos.UngTuyen;
import java.text.ParseException;
import java.util.Locale;
import org.springframework.format.Formatter;

/**
 *
 * @author DELL
 */
public class UngTuyenFormatter implements Formatter<UngTuyen> {
    @Override
    public String print(UngTuyen ut, Locale locale) {
        return String.valueOf(ut.getMaUT());
    }

    @Override
    public UngTuyen parse(String utID, Locale locale) throws ParseException {
        UngTuyen ut = new UngTuyen();
        ut.setMaUT(Integer.parseInt(utID));
        return ut;
    }
}
