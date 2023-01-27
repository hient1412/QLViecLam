/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.controllers;

import com.vl.pojos.NhaTuyenDung;
import com.vl.pojos.TaiKhoan;
import com.vl.pojos.TinTuyenDung;
import com.vl.service.LoaiVLService;
import com.vl.service.NhaTuyenDungService;
import com.vl.service.TaiKhoanService;
import com.vl.service.TinTuyenDungService;
import com.vl.service.UngTuyenService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/company")
public class NhaTuyenDungController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    @Autowired
    private NhaTuyenDungService nhaTuyenDungService;

    @Autowired
    private TinTuyenDungService tinTuyenDungService;

    @Autowired
    private UngTuyenService ungTuyenService;
    
    @Autowired
    private LoaiVLService loaiVLService;

    @GetMapping("/view")
    public String company(Model model, Authentication a) {
        TaiKhoan tk = this.taiKhoanService.getTKByTen(a.getName());
        model.addAttribute("ntd", tk.getNhaTuyenDung().getMaNTD());
        return "company-view";
    }

    @GetMapping("/list-job-upload")
    public String companyListJob(Model model, @RequestParam(required = false) Map<String, String> params,
            @RequestParam(name = "id") int id) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("job", this.tinTuyenDungService.getTinTuyenDungByMaNTD(id, page));

        return "list-job-upload";
    }

    @GetMapping("/list-job-upload/delete")
    public String jobDelete(Model model, @RequestParam(name = "id") int id,
            RedirectAttributes r) {
        String errMessage = "";
        TinTuyenDung ttd = this.tinTuyenDungService.getTinTuyenDungId(id);
        if (this.tinTuyenDungService.deleteTTD(ttd) == true) {
            errMessage = String.format("Đã xóa thành công tin tuyển dụng có tiêu đề là '%s'", ttd.getTenTTD());
        } else {
            errMessage = String.format("Có lỗi xảy ra không thể xóa tin tuyển dụng: '%s'", ttd.getTenTTD());
        }
        r.addFlashAttribute("errMessage", errMessage);
        return "redirect:/company/list-job-upload?id=" + ttd.getMaNTD();
    }

    @GetMapping("/job-upload")
    public String jobUploadView(Model model) {
        model.addAttribute("loaiVL", this.loaiVLService.getLoaiVL());
        model.addAttribute("ttd", new TinTuyenDung());
        return "job-upload";
    }

    @PostMapping("/job-upload")
    public String jobUpload(Model model, @ModelAttribute(value = "ttd") TinTuyenDung tintd,
            RedirectAttributes r, Authentication a) {
        TaiKhoan tk = this.taiKhoanService.getTKByTen(a.getName());
        tintd.setTrangThai(1);
        tintd.setMaNTD(tk.getNhaTuyenDung());
        if (this.tinTuyenDungService.addTinTuyenDung(tintd) == true) {
            r.addFlashAttribute("errMessage", String.format("Đăng thành công tin '%s'", tintd.getTenTTD()));
            return "redirect:/company/list-job-upload?id=" + tk.getNhaTuyenDung().getMaNTD();
        } else {
            model.addAttribute("errMessage", String.format("Có lỗi xảy ra không thể đăng tin '%s'", tintd.getTenTTD()));
        }
        return "job-upload";
    }

    @GetMapping("/edit")
    public String ntdEditView(Model model, Authentication authentication) {
        TaiKhoan tk = this.taiKhoanService.getTKByTen(authentication.getName());
        model.addAttribute("nhaTD", tk.getNhaTuyenDung());
        return "company-edit";
    }

    @PostMapping("/edit")
    public String ntdEdit(Model model, @ModelAttribute(value = "nhaTD") NhaTuyenDung nhaTD) {
        if (this.nhaTuyenDungService.updateNTD(nhaTD) == true) {
            return "redirect:/personal-info";
        } else {
            model.addAttribute("errMessage", "Có lỗi xảy ra không thể cập nhật thông tin");
        }
        return "company-edit";
    }

    @GetMapping("/list-job-upload/edit")
    public String jobEditView(Model model, @RequestParam(name = "id") int id) {
        model.addAttribute("loaiVL", this.loaiVLService.getLoaiVL());
        model.addAttribute("ttd", this.tinTuyenDungService.getTinTuyenDungId(id));
        return "job-upload-edit";
    }

    @PostMapping("/list-job-upload/edit")
    public String jobEdit(Model model, @ModelAttribute(value = "ttd") TinTuyenDung tinTD,
            RedirectAttributes r,Authentication a) {
        TaiKhoan tk = this.taiKhoanService.getTKByTen(a.getName());
        tinTD.setMaNTD(tk.getNhaTuyenDung());
        String errMessage = "";
        if (this.tinTuyenDungService.updateTTD(tinTD) == true) {
            errMessage = String.format("Đã chỉnh sửa thành công thành công tin tuyển dụng có tiêu đề là '%s'", tinTD.getTenTTD());
            return "redirect:/company/list-job-upload?id=" + tinTD.getMaNTD();
        } else {
            errMessage = String.format("Có lỗi xảy ra không thể chỉnh sửa tin tuyển dụng: '%s'", tinTD.getTenTTD());
        }
        r.addFlashAttribute("errMessage", errMessage);
        model.addAttribute("errMessage", errMessage);
        return "job-upload-edit";
    }
    
    @GetMapping("/uv-apply")
    public String ungVienApply(Model model,@RequestParam(name = "id") int id) {
        model.addAttribute("apply", this.ungTuyenService.getUngTuyenByMaNTD(id));
        return "uv-apply";
    }

}
