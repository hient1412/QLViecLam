/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "tintuyendung")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TinTuyenDung.findAll", query = "SELECT t FROM TinTuyenDung t"),
    @NamedQuery(name = "TinTuyenDung.findByMaTTD", query = "SELECT t FROM TinTuyenDung t WHERE t.maTTD = :maTTD"),
    @NamedQuery(name = "TinTuyenDung.findByTenTTD", query = "SELECT t FROM TinTuyenDung t WHERE t.tenTTD = :tenTTD"),
    @NamedQuery(name = "TinTuyenDung.findByNgayDang", query = "SELECT t FROM TinTuyenDung t WHERE t.ngayDang = :ngayDang"),
    @NamedQuery(name = "TinTuyenDung.findByNgayKT", query = "SELECT t FROM TinTuyenDung t WHERE t.ngayKT = :ngayKT"),
    @NamedQuery(name = "TinTuyenDung.findByTrangThai", query = "SELECT t FROM TinTuyenDung t WHERE t.trangThai = :trangThai")})
public class TinTuyenDung implements Serializable {

    @JsonIgnore
    @OneToMany(mappedBy = "maTTD",fetch = FetchType.EAGER)
    private Set<UngTuyen> ungTuyenSet;
    @JsonIgnore
    @Column(name = "trangThai")
    private Integer trangThai;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "viTri")
    private String viTri;
    @JsonIgnore
    @Lob
    @Size(max = 65535)
    @Column(name = "moTaTTD")
    private String moTaTTD;
    @JsonIgnore
    @Column(name = "soLuong")
    private Integer soLuong;
    @JsonIgnore
    @Size(max = 45)
    @Column(name = "kinhNghiem")
    private String kinhNghiem;
    @JsonIgnore
    @Size(max = 100)
    @Column(name = "noiLamViec")
    private String noiLamViec;
    @Size(max = 45)
    @Column(name = "luong")
    @JsonIgnore
    private String luong;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maTTD")
    private Integer maTTD;
    @Size(max = 256)
    @Column(name = "tenTTD")
    private String tenTTD;
    @JsonIgnore
    @Column(name = "ngayDang")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayDang = new Date();
    @JsonIgnore
    @Column(name = "ngayKT")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date ngayKT;

    @JoinColumn(name = "maNTD", referencedColumnName = "maNTD")
    @ManyToOne
    @JsonProperty("nhaTuyenDung")
    private NhaTuyenDung maNTD;
    @JsonIgnore
    @JoinColumn(name = "maLoaiVL", referencedColumnName = "maLoaiVL")
    @ManyToOne
    private LoaiVL maLoaiVL;

    public TinTuyenDung() {
    }

    public TinTuyenDung(Integer maTTD) {
        this.maTTD = maTTD;
    }

    public Integer getMaTTD() {
        return maTTD;
    }

    public void setMaTTD(Integer maTTD) {
        this.maTTD = maTTD;
    }

    public String getTenTTD() {
        return tenTTD;
    }

    public void setTenTTD(String tenTTD) {
        this.tenTTD = tenTTD;
    }

    public Date getNgayDang() {
        return ngayDang;
    }

    public void setNgayDang(Date ngayDang) {
        this.ngayDang = ngayDang;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }


    public NhaTuyenDung getMaNTD() {
        return maNTD;
    }

    public void setMaNTD(NhaTuyenDung maNTD) {
        this.maNTD = maNTD;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maTTD != null ? maTTD.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TinTuyenDung)) {
            return false;
        }
        TinTuyenDung other = (TinTuyenDung) object;
        if ((this.maTTD == null && other.maTTD != null) || (this.maTTD != null && !this.maTTD.equals(other.maTTD))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vl.pojo.TinTuyenDung[ maTTD=" + maTTD + " ]";
    }

    /**
     * @return the maLoaiVL
     */
    public LoaiVL getMaLoaiVL() {
        return maLoaiVL;
    }

    /**
     * @param maLoaiVL the maLoaiVL to set
     */
    public void setMaLoaiVL(LoaiVL maLoaiVL) {
        this.maLoaiVL = maLoaiVL;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getViTri() {
        return viTri;
    }

    public void setViTri(String viTri) {
        this.viTri = viTri;
    }

    public String getMoTaTTD() {
        return moTaTTD;
    }

    public void setMoTaTTD(String moTaTTD) {
        this.moTaTTD = moTaTTD;
    }

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public String getKinhNghiem() {
        return kinhNghiem;
    }

    public void setKinhNghiem(String kinhNghiem) {
        this.kinhNghiem = kinhNghiem;
    }

    public String getNoiLamViec() {
        return noiLamViec;
    }

    public void setNoiLamViec(String noiLamViec) {
        this.noiLamViec = noiLamViec;
    }

    public String getLuong() {
        return luong;
    }

    public void setLuong(String luong) {
        this.luong = luong;
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
