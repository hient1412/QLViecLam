/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "ungvien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UngVien.findAll", query = "SELECT u FROM UngVien u"),
    @NamedQuery(name = "UngVien.findByMaUV", query = "SELECT u FROM UngVien u WHERE u.maUV = :maUV"),
    @NamedQuery(name = "UngVien.findByHoUV", query = "SELECT u FROM UngVien u WHERE u.hoUV = :hoUV"),
    @NamedQuery(name = "UngVien.findByTenUV", query = "SELECT u FROM UngVien u WHERE u.tenUV = :tenUV"),
    @NamedQuery(name = "UngVien.findByNgaySinh", query = "SELECT u FROM UngVien u WHERE u.ngaySinh = :ngaySinh"),
    @NamedQuery(name = "UngVien.findByDiaChi", query = "SELECT u FROM UngVien u WHERE u.diaChi = :diaChi"),
    @NamedQuery(name = "UngVien.findByQueQuan", query = "SELECT u FROM UngVien u WHERE u.queQuan = :queQuan"),
    @NamedQuery(name = "UngVien.findByEmail", query = "SELECT u FROM UngVien u WHERE u.email = :email"),
    @NamedQuery(name = "UngVien.findByNoiLamViec", query = "SELECT u FROM UngVien u WHERE u.noiLamViec = :noiLamViec"),
    @NamedQuery(name = "UngVien.findByMoTaUV", query = "SELECT u FROM UngVien u WHERE u.moTaUV = :moTaUV")})
public class UngVien implements Serializable {

    @JsonIgnore
    @OneToMany(mappedBy = "maUV",  fetch = FetchType.EAGER)
    private Set<UngTuyen> ungTuyenSet;

    
    @Lob
    @Size(max = 65535)
    @Column(name = "cv")
    private String cv;
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
    @JsonIgnore
    @Size(max = 10)
    @Column(name = "gioiTinh")
    private String gioiTinh;
    @JsonIgnore
    @Lob
    @Size(max = 65535)
    @Column(name = "avatar")
    private String avatar;
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maUV")
    private Integer maUV;
    @Size(max = 20)
    @Column(name = "hoUV")
    private String hoUV;
    @Size(max = 10)
    @Column(name = "tenUV")
    private String tenUV;
    @Size(max = 10)
    @JsonIgnore
    @Column(name = "ngaySinh")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date ngaySinh;
    @Size(max = 50)
    @JsonIgnore
    @Column(name = "diaChi")
    private String diaChi;
    @Size(max = 45)
    @JsonIgnore
    @Column(name = "queQuan")
    private String queQuan;
    @Transient
    @JsonIgnore
    private MultipartFile file;
    @Size(max = 25)
    @JsonIgnore
    @Column(name = "email")
    private String email;
    @Size(max = 25)
    @JsonIgnore
    @Column(name = "noiLamViec")
    private String noiLamViec;
    @Size(max = 100)
    @JsonIgnore
    @Column(name = "moTaUV")
    private String moTaUV;
    @JsonIgnore
    @JoinColumn(name = "maTK", referencedColumnName = "maTK")
    @OneToOne
    private TaiKhoan maTK;
    

    public UngVien() {
    }

    public UngVien(Integer maUV) {
        this.maUV = maUV;
    }

    public Integer getMaUV() {
        return maUV;
    }

    public void setMaUV(Integer maUV) {
        this.maUV = maUV;
    }

    public String getHoUV() {
        return hoUV;
    }

    public void setHoUV(String hoUV) {
        this.hoUV = hoUV;
    }

    public String getTenUV() {
        return tenUV;
    }

    public void setTenUV(String tenUV) {
        this.tenUV = tenUV;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoiLamViec() {
        return noiLamViec;
    }

    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }

    public String getMoTaUV() {
        return moTaUV;
    }

    public void setMoTaUV(String moTaUV) {
        this.moTaUV = moTaUV;
    }

    public TaiKhoan getMaTK() {
        return maTK;
    }

    public void setMaTK(TaiKhoan maTK) {
        this.maTK = maTK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maUV != null ? maUV.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UngVien)) {
            return false;
        }
        UngVien other = (UngVien) object;
        if ((this.maUV == null && other.maUV != null) || (this.maUV != null && !this.maUV.equals(other.maUV))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vl.pojo.UngVien[ maUV=" + maUV + " ]";
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    /**
     * @return the ungTuyenSet
     */
    @XmlTransient
    public Set<UngTuyen> getUngTuyenSet() {
        return ungTuyenSet;
    }

    /**
     * @param ungTuyenSet the ungTuyenSet to set
     */
    public void setUngTuyenSet(Set<UngTuyen> ungTuyenSet) {
        this.ungTuyenSet = ungTuyenSet;
    }

}
