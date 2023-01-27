/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.controllers;

import com.vl.pojos.NhaTuyenDung;
import com.vl.pojos.TaiKhoan;
import com.vl.pojos.UngVien;
import com.vl.service.AdminService;
import com.vl.service.NhaTuyenDungService;
import com.vl.service.TaiKhoanService;
import com.vl.service.TinTuyenDungService;
import com.vl.service.UngVienService;
import java.util.Map;
import javax.persistence.NoResultException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author DELL
 */
@Controller
public class HomePageController {

    @Autowired
    private UngVienService ungVienService;
    @Autowired
    private TinTuyenDungService tinTuyenDungService;
    @Autowired
    private TaiKhoanService userDetailsService;
    @Autowired
    private NhaTuyenDungService nhaTuyenDungService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/")
    public String index(Model model, @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("ttdJoin", this.tinTuyenDungService.getTinTuyenDungJoin(page));
        model.addAttribute("counter", this.tinTuyenDungService.countTinTuyenDung());
        return "home";
    }

    @RequestMapping("/companies")
    public String company(Model model) {
        model.addAttribute("ntd", this.nhaTuyenDungService.getNhaTuyenDung());
        return "company";
    }

    @RequestMapping("/candidates")
    public String candidates(Model model) {
        model.addAttribute("uv", this.ungVienService.getUngVien());
        return "candidates";
    }

    @GetMapping("/candidate-detail/{candidateId}")
    public String candidateDetail(Model model, @PathVariable(value = "candidateId") int candidateId) {
        model.addAttribute("uv", this.ungVienService.getUngVienID(candidateId));
        return "candidate-detail";
    }

    @RequestMapping("/search")
    public String search(Model model,
            @RequestParam(required = false) Map<String, String> params) {
        int page = Integer.parseInt(params.getOrDefault("page", "1"));
        model.addAttribute("kw", params.get("kw"));
        model.addAttribute("ttdJoin", this.tinTuyenDungService.getTinTuyenDungBykw(params.get("kw"), page));
        model.addAttribute("counterS", this.tinTuyenDungService.getTinTuyenDungBykw(params.get("kw"), page).size());
        return "search";
    }

    @GetMapping("/login")
    public String login() {

        return "login";
    }

    @GetMapping("/company-detail/{companyId}")
    public String jobDetail(Model model, @PathVariable(value = "companyId") int companyId) {
        model.addAttribute("ntd", this.nhaTuyenDungService.getNhaTuyenDungID(companyId));
        model.addAttribute("job", this.tinTuyenDungService.getTinTuyenDungByMaNTD(companyId, 0));
        return "company-detail";
    }

    @GetMapping("/personal-info")
    public String personal(Model model, Authentication authentication) {
        TaiKhoan tk = this.userDetailsService.getTKByTen(authentication.getName());
        model.addAttribute("tk", tk);
        try {
            if (tk.getLoaiTK().equals(TaiKhoan.NTD)) {
                model.addAttribute("ntd", this.nhaTuyenDungService.getNTDByMaTK(tk.getMaTK()));
            } else if (tk.getLoaiTK().equals(TaiKhoan.UV)) {
                model.addAttribute("uv", this.ungVienService.getUVByMaTK(tk.getMaTK()));
            } else if (tk.getLoaiTK().equals(TaiKhoan.ADMIN)) {
                model.addAttribute("ad", this.adminService.getAdminByMaTK(tk.getMaTK()));
            }
        } catch (Exception e) {
            return "redirect:/";
        }
        return "personal-info";
    }

    @GetMapping("/registry")
    public String registryView(Model model) {
        model.addAttribute("user", new TaiKhoan());

        return "registry";
    }

    @PostMapping("/registry")
    public ModelAndView registry(Model model, @ModelAttribute(value = "user") TaiKhoan taiKhoan) {
        String errMessage = "";
        if (taiKhoan.getMatKhau().equals(taiKhoan.getXacNhanMK())) {
            if (taiKhoan.getLoaiTK().equals("ROLE_NTD")) {
                taiKhoan.setTrangThai(0);
            } else {
                taiKhoan.setTrangThai(1);
            }
            if (this.userDetailsService.addTK(taiKhoan) == true) {
                if (taiKhoan.getLoaiTK().equals("ROLE_UV")) {
                    return new ModelAndView("redirect:/registry/uv", "id", taiKhoan.getMaTK());
                } else {
                    return new ModelAndView("redirect:/registry/ntd", "id", taiKhoan.getMaTK());
                }
            } else {
                errMessage = "Có lỗi!!";
            }
        } else {
            errMessage = "Không khớp mật khẩu!!";
        }
        model.addAttribute("errMessage", errMessage);
        return new ModelAndView("registry");
    }

    @GetMapping("/registry/uv")
    public String uvView(Model model, @RequestParam(name = "id", required = false) String id) {
        model.addAttribute("ungVien", new UngVien());
        model.addAttribute("tk", userDetailsService.getTKByID(Integer.parseInt(id)));
        return "registry-uv";
    }

    @PostMapping("/registry/uv")
    public String uv(Model model, @ModelAttribute(value = "ungVien") UngVien ungVien) {
        ungVien.setMaTK(ungVien.getMaTK());
        if (this.ungVienService.addUV(ungVien) == true) {
            return "redirect:/login";
        }
        return "registry-uv";
    }

    @GetMapping("/registry/ntd")
    public String ntdView(Model model, @RequestParam(name = "id", required = false) String id) {
        model.addAttribute("nhaTuyenDung", new NhaTuyenDung());
        model.addAttribute("tk", userDetailsService.getTKByID(Integer.parseInt(id)));
        return "registry-ntd";
    }

    @PostMapping("/registry/ntd")
    public String ntd(Model model, @ModelAttribute(value = "nhaTuyenDung") NhaTuyenDung nhaTuyenDung) {
        nhaTuyenDung.setMaTK(nhaTuyenDung.getMaTK());
        if (this.nhaTuyenDungService.addNTD(nhaTuyenDung) == true) {
            return "redirect:/login";
        }
        return "registry-ntd";
    }

}
