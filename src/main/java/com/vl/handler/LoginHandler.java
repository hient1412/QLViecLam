/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.handler;

import com.vl.pojos.TaiKhoan;
import com.vl.service.TaiKhoanService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 *
 * @author DELL
 */
@Component
public class LoginHandler implements AuthenticationSuccessHandler {

    @Autowired
    private TaiKhoanService userDetailsService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication a) throws IOException, ServletException {
        TaiKhoan tk = this.userDetailsService.getTKByTen(a.getName());

        request.getSession().setAttribute("current", tk);
        request.getSession().setAttribute("currentNTD", tk.getNhaTuyenDung());
        request.getSession().setAttribute("currentUV", tk.getUngVien());
        response.sendRedirect("/WebsiteGioiThieuViecLam/");
    }

}
