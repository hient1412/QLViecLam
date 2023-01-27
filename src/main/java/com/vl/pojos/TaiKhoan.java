/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "taikhoan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TaiKhoan.findAll", query = "SELECT t FROM TaiKhoan t"),
    @NamedQuery(name = "TaiKhoan.findByMaTK", query = "SELECT t FROM TaiKhoan t WHERE t.maTK = :maTK"),
    @NamedQuery(name = "TaiKhoan.findByTaiKhoan", query = "SELECT t FROM TaiKhoan t WHERE t.taiKhoan = :taiKhoan"),
    @NamedQuery(name = "TaiKhoan.findByMatKhau", query = "SELECT t FROM TaiKhoan t WHERE t.matKhau = :matKhau"),
    @NamedQuery(name = "TaiKhoan.findByLoaiTK", query = "SELECT t FROM TaiKhoan t WHERE t.loaiTK = :loaiTK"),
    @NamedQuery(name = "TaiKhoan.findByTrangThai", query = "SELECT t FROM TaiKhoan t WHERE t.trangThai = :trangThai")})
public class TaiKhoan implements Serializable {

    

    @JsonIgnore
    @Column(name = "trangThai")
    private Integer trangThai;

    public static final String ADMIN = "ROLE_ADMIN";
    public static final String NTD = "ROLE_NTD";
    public static final String UV = "ROLE_UV";
    
    private static final long serialVersionUID = 1L;
    
    @JsonIgnore
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maTK")
    private Integer maTK;
    
    @Size(max = 50)
    @Column(name = "taiKhoan")
    private String taiKhoan;
    @JsonIgnore
    @Size(max = 256)
    @Column(name = "matKhau")
    private String matKhau;
    @JsonIgnore
    @Size(max = 15)
    @Column(name = "loaiTK")
    private String loaiTK;
    @JsonIgnore
    @Transient
    private String xacNhanMK;
    @JsonIgnore
    @OneToOne(mappedBy = "maTK")
    private NhaTuyenDung nhaTuyenDung;
    @JsonIgnore
    @OneToOne(mappedBy = "maTK")
    private Admin admin;
    @JsonIgnore
    @OneToOne(mappedBy = "maTK")
    private UngVien ungVien;
    
    @OneToMany(mappedBy = "maTK")
    @JsonIgnore
    private Set<BinhLuan> binhLuanSet;

    public TaiKhoan() {
    }

    public TaiKhoan(Integer maTK) {
        this.maTK = maTK;
    }

    public Integer getMaTK() {
        return maTK;
    }

    public void setMaTK(Integer maTK) {
        this.maTK = maTK;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getLoaiTK() {
        return loaiTK;
    }

    public void setLoaiTK(String loaiTK) {
        this.loaiTK = loaiTK;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTK != null ? maTK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TaiKhoan)) {
            return false;
        }
        TaiKhoan other = (TaiKhoan) object;
        if ((this.maTK == null && other.maTK != null) || (this.maTK != null && !this.maTK.equals(other.maTK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vl.pojo.Taikhoan[ maTK=" + maTK + " ]";
    }

    /**
     * @return the xacNhanMK
     */
    public String getXacNhanMK() {
        return xacNhanMK;
    }

    /**
     * @param xacNhanMK the xacNhanMK to set
     */
    public void setXacNhanMK(String xacNhanMK) {
        this.xacNhanMK = xacNhanMK;
    }
    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }


    /**
     * @return the ungVien
     */
    public UngVien getUngVien() {
        return ungVien;
    }

    /**
     * @param ungVien the ungVien to set
     */
    public void setUngVien(UngVien ungVien) {
        this.ungVien = ungVien;
    }

    /**
     * @return the nhaTuyenDung
     */
    public NhaTuyenDung getNhaTuyenDung() {
        return nhaTuyenDung;
    }

    /**
     * @param nhaTuyenDung the nhaTuyenDung to set
     */
    public void setNhaTuyenDung(NhaTuyenDung nhaTuyenDung) {
        this.nhaTuyenDung = nhaTuyenDung;
    }

    /**
     * @return the admin
     */
    public Admin getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    /**
     * @return the binhLuanSet
     */
    public Set<BinhLuan> getBinhLuanSet() {
        return binhLuanSet;
    }

    /**
     * @param binhLuanSet the binhLuanSet to set
     */
    public void setBinhLuanSet(Set<BinhLuan> binhLuanSet) {
        this.binhLuanSet = binhLuanSet;
    }


}
