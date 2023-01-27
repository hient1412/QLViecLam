/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.controllers;

import com.vl.pojos.TaiKhoan;
import com.vl.pojos.UngTuyen;
import com.vl.pojos.UngVien;
import com.vl.service.TaiKhoanService;
import com.vl.service.TinTuyenDungService;
import com.vl.service.UngTuyenService;
import com.vl.service.UngVienService;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author DELL
 */    
@Controller
@RequestMapping("/candidate")
public class UngVienController {

    @Autowired
    private TinTuyenDungService tinTuyenDungService;
    @Autowired
    private UngTuyenService ungTuyenService;
    @Autowired
    private TaiKhoanService taiKhoanService;
    @Autowired
    private UngVienService ungVienService;

    @GetMapping("/edit")
    public String uvEditView(Model model, Authentication authentication) {
        TaiKhoan tk = this.taiKhoanService.getTKByTen(authentication.getName());
        model.addAttribute("ungVien", tk.getUngVien());
        return "candidate-edit";
    }

    @PostMapping("/edit")
    public String ntdEdit(Model model, @ModelAttribute(value = "ungVien") UngVien uv) {
        if (this.ungVienService.updateUV(uv) == true) {
            return "redirect:/personal-info";
        } else {
            model.addAttribute("errMessage", "Có lỗi xảy ra không thể cập nhật thông tin");
        }
        return "candidate-edit";
    }
    
    @GetMapping("/list-apply")
    public String ungVienApply(Model model,@RequestParam(name = "id") int id) {
        model.addAttribute("apply", this.ungTuyenService.getUngTuyenByMaUV(id));
        return "list-apply";
    }

    @GetMapping("/job-apply")
    public String jobApplyView(Model model, Authentication authentication, @RequestParam(name = "id") int id) {
        model.addAttribute("ungTuyen", new UngTuyen());
        model.addAttribute("t", this.tinTuyenDungService.getTinTuyenDungId(id));
        model.addAttribute("uv", this.taiKhoanService.getTKByTen(authentication.getName()).getUngVien());
        return "job-apply";
    }
    
    @PostMapping("/job-apply")
    public String jobApply(Model model,@ModelAttribute(value = "ungTuyen") UngTuyen ungTuyen) {
        ungTuyen.setNgayUT(new Date());
        ungTuyen.setMaUV(ungTuyen.getMaUV());
        ungTuyen.setMaTTD(ungTuyen.getMaTTD());
        if (this.ungTuyenService.addUngTuyen(ungTuyen) == true) {
            return "redirect:/list-apply?id=" + ungTuyen.getMaUV();
        } else {
            model.addAttribute("errMessage", "Có lỗi xảy ra không thể ứng tuyển");
        }
        return "job-apply";
    }
}

