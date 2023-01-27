/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.controllers;


import com.vl.pojos.TaiKhoan;
import com.vl.pojos.UngTuyen;
import com.vl.pojos.UngVien;
import com.vl.service.LoaiVLService;
import com.vl.service.NhaTuyenDungService;
import com.vl.service.TaiKhoanService;
import com.vl.service.TinTuyenDungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author DELL
 */
@Controller
public class TinTuyenDungController {
    @Autowired
    private TinTuyenDungService tinTuyenDungService;
    @Autowired
    private NhaTuyenDungService nhaTuyenDungService;
    @Autowired
    private LoaiVLService loaiVLService;
    
    @GetMapping("/job-detail/{jobId}")
    public String jobDetail(Model model,@PathVariable(value = "jobId") int jobId){
        model.addAttribute("ttd",this.tinTuyenDungService.getTinTuyenDungId(jobId));
        model.addAttribute("vl",this.loaiVLService.getLVLByMaTTD(jobId));
        model.addAttribute("ntd",this.nhaTuyenDungService.getNTDByMaTTD(jobId));
        return "job-detail";
    }
    
}
