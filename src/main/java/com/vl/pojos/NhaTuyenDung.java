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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "nhatuyendung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NhaTuyenDung.findAll", query = "SELECT n FROM NhaTuyenDung n"),
    @NamedQuery(name = "NhaTuyenDung.findByMaNTD", query = "SELECT n FROM NhaTuyenDung n WHERE n.maNTD = :maNTD"),
    @NamedQuery(name = "NhaTuyenDung.findByTenNTD", query = "SELECT n FROM NhaTuyenDung n WHERE n.tenNTD = :tenNTD"),
    @NamedQuery(name = "NhaTuyenDung.findByDiaChi", query = "SELECT n FROM NhaTuyenDung n WHERE n.diaChi = :diaChi"),
    @NamedQuery(name = "NhaTuyenDung.findBySoDT", query = "SELECT n FROM NhaTuyenDung n WHERE n.soDT = :soDT"),
    @NamedQuery(name = "NhaTuyenDung.findByEmail", query = "SELECT n FROM NhaTuyenDung n WHERE n.email = :email"),
    @NamedQuery(name = "NhaTuyenDung.findByMoTaNTD", query = "SELECT n FROM NhaTuyenDung n WHERE n.moTaNTD = :moTaNTD")})
public class NhaTuyenDung implements Serializable {

    
    @JsonIgnore
    @Lob
    @Size(max = 65535)
    @Column(name = "avatar")
    private String avatar;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maNTD")
    private Integer maNTD;
    @Size(max = 20)
    @Column(name = "tenNTD")
    private String tenNTD;
    @JsonIgnore
    @Size(max = 30)
    @Column(name = "diaChi")
    private String diaChi;
    @JsonIgnore
    @Size(max = 15)
    @Column(name = "soDT")
    private String soDT;
    @JsonIgnore
    @Size(max = 25)
    @Column(name = "email")
    private String email;
    @Transient
    @JsonIgnore
    private MultipartFile file;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "moTaNTD")
    private String moTaNTD;
    @JoinColumn(name = "maTK", referencedColumnName = "maTK")
    @OneToOne
    private TaiKhoan maTK;
    @JsonIgnore
    @OneToMany(mappedBy = "maNTD", fetch = FetchType.EAGER)
    private Set<BinhLuan> binhLuanSet;
    @JsonIgnore
    @OneToMany(mappedBy = "maNTD")
    private Set<TinTuyenDung> tinTuyenDungSet;

    public NhaTuyenDung() {
    }

    public NhaTuyenDung(Integer maNTD) {
        this.maNTD = maNTD;
    }

    public Integer getMaNTD() {
        return maNTD;
    }

    public void setMaNTD(Integer maNTD) {
        this.maNTD = maNTD;
    }

    public String getTenNTD() {
        return tenNTD;
    }

    public void setTenNTD(String tenNTD) {
        this.tenNTD = tenNTD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMoTaNTD() {
        return moTaNTD;
    }

    public void setMoTaNTD(String moTaNTD) {
        this.moTaNTD = moTaNTD;
    }
    public TaiKhoan getMaTK() {
        return maTK;
    }

    public void setMaTK(TaiKhoan maTK) {
        this.maTK = maTK;
    }

    @XmlTransient
    public Set<BinhLuan> getBinhLuanSet() {
        return binhLuanSet;
    }

    public void setBinhLuanSet(Set<BinhLuan> binhLuanSet) {
        this.binhLuanSet = binhLuanSet;
    }


    @XmlTransient
    public Set<TinTuyenDung> getTinTuyenDungSet() {
        return tinTuyenDungSet;
    }

    public void setTinTuyenDungSet(Set<TinTuyenDung> tinTuyenDungSet) {
        this.tinTuyenDungSet = tinTuyenDungSet;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maNTD != null ? maNTD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NhaTuyenDung)) {
            return false;
        }
        NhaTuyenDung other = (NhaTuyenDung) object;
        if ((this.maNTD == null && other.maNTD != null) || (this.maNTD != null && !this.maNTD.equals(other.maNTD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return maNTD.toString();
    }

    
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * @return the file
     */
    public MultipartFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(MultipartFile file) {
        this.file = file;
    }
    
}
