/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.controllers;

import com.vl.pojos.BinhLuan;
import com.vl.service.NhaTuyenDungService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api")
public class ApiCommentController {
    
    @Autowired
    private NhaTuyenDungService nhaTuyenDungService;
    
    
    @GetMapping("/company/{companyID}/comment")
    public ResponseEntity<List<BinhLuan>> getBinhLuan(@PathVariable(value = "companyID") int id){
        return new ResponseEntity<>(this.nhaTuyenDungService.getBinhLuan(id),HttpStatus.OK);
    }
    
    @PostMapping(path = "/company/{companyID}/comment", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BinhLuan> addBinhLuan(@RequestBody Map<String,String> params){
        try{
        String binhLuan = params.get("binhLuan");
        int maNTD = Integer.parseInt(params.get("maNTD"));
        BinhLuan bl = this.nhaTuyenDungService.addBinhLuan(binhLuan, maNTD);
        return new ResponseEntity<>(bl, HttpStatus.CREATED);
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<BinhLuan>(HttpStatus.BAD_REQUEST);
    }
}
