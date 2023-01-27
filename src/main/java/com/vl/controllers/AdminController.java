/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.controllers;

import com.vl.pojos.Admin;
import com.vl.pojos.LoaiVL;
import com.vl.pojos.NhaTuyenDung;
import com.vl.pojos.TaiKhoan;
import com.vl.pojos.UngVien;
import com.vl.service.AdminService;
import com.vl.service.LoaiVLService;
import com.vl.service.NhaTuyenDungService;
import com.vl.service.TaiKhoanService;
import com.vl.service.TinTuyenDungService;
import com.vl.service.UngVienService;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author DELL
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private TaiKhoanService userDetailsService;
    @Autowired
    private LoaiVLService loaiVLService;
    @Autowired
    private UngVienService ungVienService;
    @Autowired
    private NhaTuyenDungService nhaTuyenDungService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private TinTuyenDungService tinTuyenDungService;

    @GetMapping("/edit")
    public String adminEditView(Model model, Authentication authentication) {
        TaiKhoan tk = this.userDetailsService.getTKByTen(authentication.getName());
        model.addAttribute("admin", tk.getAdmin());
        return "admin-edit";
    }

    @PostMapping("/edit")
    public String adminEdit(Model model, @ModelAttribute(value = "admin") Admin ad) {
        if (this.adminService.updateAdmin(ad) == true) {
            model.addAttribute("errMessage", "Có lỗi xảy ra không thể cập nhật thông tin");
            return "redirect:/personal-info";
        } else {
            model.addAttribute("errMessage", "Có lỗi xảy ra không thể cập nhật thông tin");
        }
        return "admin-edit";
    }
    
    @GetMapping("/view")
    public String adminView() {

        return "admin-view";
    }
    
    
    @GetMapping("/company-confirm")
    public String companyConfirm(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        List<TaiKhoan> listTK = this.userDetailsService.getLoaiTK(TaiKhoan.NTD, page, 0);
        List<TaiKhoan> listSize = this.userDetailsService.getLoaiTK(TaiKhoan.NTD, 0, 0);

        model.addAttribute("listTK", listTK);
        model.addAttribute("size", listSize.size());

        return "company-confirm";
    }

    @GetMapping("/company-confirm/1")
    public String companyConfirm1(Model model, RedirectAttributes r,
            @RequestParam(name = "id") int id) {
        String errMessage = "";
        TaiKhoan tk = this.userDetailsService.getTKByID(id);
        tk.setTrangThai(1);
        if (this.userDetailsService.updateTT(tk) == true) {
            if (tk.getTrangThai() != 1) {
                errMessage = String.format("Đã xác nhận thành công nhà tuyển dụng '%s'", tk.getTaiKhoan());
            } else {
                errMessage = String.format("Có lỗi xảy ra khi xác nhận nhà tuyển dụng '%s'", tk.getTaiKhoan());
            }
        }
        r.addFlashAttribute("errMessage", errMessage);
        return "redirect:/admin/company-confirm";
    }

    @GetMapping("/company-confirm/all")
    public String companyConfirmAll(Model model, RedirectAttributes r) {

        String errMessage = "";

        List<TaiKhoan> tks = this.userDetailsService.getLoaiTK(TaiKhoan.NTD, 0, 0);
        tks.forEach(tk -> {
            tk.setTrangThai(1);
            this.userDetailsService.updateTT(tk);
        });

        int size = this.userDetailsService.getLoaiTK(TaiKhoan.NTD, 0, 0).size();

        if (size != 0) {
            errMessage = "Có lỗi xảy ra khi xác nhận tất cả nhà tuyển dụng";
        }

        r.addFlashAttribute("errMessage", errMessage);
        return "redirect:/admin/company-confirm";
    }

    @GetMapping("/job-type")
    public String jobType(Model model, @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        List<LoaiVL> vls = this.loaiVLService.getLoaiVL(page);
        List<LoaiVL> size = this.loaiVLService.getLoaiVL(0);

        model.addAttribute("vls", vls);
        model.addAttribute("size", size.size());

        return "job-type";
    }

    @GetMapping("/job-type/add")
    public String jobTypeAddView(Model model) {
        model.addAttribute("loaiVL", new LoaiVL());
        return "job-type-add";
    }

    @PostMapping("/job-type/add")
    public String jobTypeAdd(Model model, @ModelAttribute(value = "loaiVL") LoaiVL loaiVL,
            RedirectAttributes r) {
        if (this.loaiVLService.addLoaiVL(loaiVL) == true) {
            r.addFlashAttribute("errMessage", String.format("Thêm thành công loại việc làm '%s'", loaiVL.getTenLoaiVL()));
        } else {
            r.addFlashAttribute("errMessage", String.format("Có lỗi xảy ra không thể thêm loại việc làm '%s'", loaiVL.getTenLoaiVL()));
        }
        return "redirect:/admin/job-type";
    }

    @GetMapping("/job-type/edit")
    public String jobTypeEditView(Model model, @RequestParam(name = "id") int id) {
        model.addAttribute("loaiVL", this.loaiVLService.getLoaiVLByID(id));
        return "job-type-edit";
    }

    @PostMapping("/job-type/edit")
    public String jobTypeEdit(Model model, @ModelAttribute(value = "loaiVL") LoaiVL loaiVL,
            RedirectAttributes r) {
        if (this.loaiVLService.updateLoaiVL(loaiVL) == true) {
            r.addFlashAttribute("errMessage", String.format("Chỉnh sửa thành công loại việc làm có mã '%d' là '%s'", loaiVL.getMaLoaiVL(), loaiVL.getTenLoaiVL()));
        } else {
            r.addFlashAttribute("errMessage", "Có lỗi xảy ra không thể chỉnh sửa loại việc làm");
        }
        return "redirect:/admin/job-type";
    }

    @GetMapping("/job-type/delete")
    public String jobTypeDelete(Model model, @RequestParam(name = "id") int id,
            RedirectAttributes r) {
        String errMessage = "";
        LoaiVL vl = this.loaiVLService.getLoaiVLByID(id);
        if (this.loaiVLService.deleteLoaiVL(id) == true) {
            errMessage = String.format("Đã xóa thành công loại việc làm: '%s'", vl.getTenLoaiVL());
        } else {
            errMessage = String.format("Có lỗi xảy ra không thể xóa loại việc làm: '%s'", vl.getTenLoaiVL());
        }
        r.addFlashAttribute("errMessage", errMessage);
        return "redirect:/admin/job-type";
    }

    @GetMapping("/account")
    public String adminAccount(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));

        List<TaiKhoan> listTK = this.userDetailsService.getTK(page);
        List<TaiKhoan> listSize = this.userDetailsService.getTK(0);

        model.addAttribute("listTK", listTK);
        model.addAttribute("size", listSize.size());

        return "admin-account";
    }

    @GetMapping("/account/see")
    public String accountSee(Model model,
            @RequestParam(name = "id") int id,
            RedirectAttributes r) {
        TaiKhoan tk = this.userDetailsService.getTKByID(id);
        model.addAttribute("tk", tk);
        if (tk.getLoaiTK().equals(TaiKhoan.UV)) {
            UngVien uv = this.ungVienService.getUVByMaTK(id);
            model.addAttribute("uv", uv);
        } else if (tk.getLoaiTK().equals(TaiKhoan.NTD)) {
            NhaTuyenDung ntd = this.nhaTuyenDungService.getNTDByMaTK(id);
            model.addAttribute("ntd", ntd);
        } else {
            Admin ad = this.adminService.getAdminByMaTK(id);
            model.addAttribute("ad", ad);
        }
        return "admin-account-see";
    }

    @GetMapping("/account/edit")
    public String updateTKView(Model model, @RequestParam(name = "id") int id) {
        TaiKhoan tk = this.userDetailsService.getTKByID(id);
        model.addAttribute("tk", tk);
        return "admin-account-edit";
    }

    @PostMapping("account/edit")
    public String updateTK(Model model, @ModelAttribute(value = "tk") TaiKhoan taiKhoan,
            RedirectAttributes r) {
        if (this.userDetailsService.updateTK(taiKhoan) == true) {
            r.addFlashAttribute("errMessage", String.format("Chỉnh sửa thành công tài khoản '%s'", taiKhoan.getTaiKhoan()));
        } else {
            r.addFlashAttribute("errMessage", "Có lỗi xảy ra không thể chỉnh sửa tài khoản");
        }
        return "redirect:/admin/account";
    }

    @GetMapping("/account/add")
    public String addTKView(Model model) {
        TaiKhoan tk = new TaiKhoan();
        model.addAttribute("tk", tk);

        return "admin-account-add";
    }

    @PostMapping("/account/add")
    public String addTK(Model model, @ModelAttribute(value = "tk") TaiKhoan taiKhoan,
                RedirectAttributes r) {
        if (this.userDetailsService.addTK(taiKhoan) == true) {
            r.addFlashAttribute("errMessage", String.format("Thêm thành công tài khoản '%s'", taiKhoan.getTaiKhoan()));
        } else {
            r.addFlashAttribute("errMessage", "Có lỗi xảy ra không thể thêm tài khoản");
        }
        return "redirect:/admin/account";
    }
    @GetMapping("/account/delete")
    public String deleteTK(Model model,@RequestParam(name = "id") int id,
                RedirectAttributes r) {
        String errMessage = "";
        TaiKhoan tk = this.userDetailsService.getTKByID(id);
        if (this.userDetailsService.deleteTK(tk) == true) {
            errMessage = String.format("Đã xóa thành công tài khoản: '%s'", tk.getTaiKhoan());
        } else {
            errMessage = String.format("Có lỗi xảy ra không thể xóa tài khoản: '%s'", tk.getTaiKhoan());
        }
        r.addFlashAttribute("errMessage", errMessage);
        return "redirect:/admin/account";
    }

    @GetMapping("/stats")
    public String adminStats(Model model) {
        return "stats";
    }
    
    @GetMapping("/stats/job-type")
    public String adminStatsJobType(Model model) {
        model.addAttribute("statsLVL",this.tinTuyenDungService.countTTDByLoaiVL());
        return "stats-job-type";
    }
    
    @GetMapping("/stats/account")
    public String adminStatsAccount(Model model) {
        model.addAttribute("statsTK",this.userDetailsService.countLoaiTK());
        return "stats-account";
    }
//    
//    @GetMapping("/stats/job-time")
//    public String adminStatsJobTime(Model model,@RequestParam (required = false)Map<String,String> params) throws ParseException {
//        SimpleDateFormat p = new SimpleDateFormat("yyyy-MM-dd");
//        
//        Date tn = null;
//        String t = params.getOrDefault("tuNgay", null);
//        if(t != null)
//            tn = p.parse(t);
//        
//        Date dn = null;
//        String d = params.getOrDefault("denNgay", null);
//        if(t != null)
//            dn = p.parse(d);
//        
////        model.addAttribute("statsTK",this.userDetailsService.countLoaiTK());
//        return "stats-job-time";
//    }
    
}
