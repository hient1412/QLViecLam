/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "binhluan")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BinhLuan.findAll", query = "SELECT b FROM BinhLuan b"),
    @NamedQuery(name = "BinhLuan.findByMaBinhLuan", query = "SELECT b FROM BinhLuan b WHERE b.maBinhLuan = :maBinhLuan"),
    @NamedQuery(name = "BinhLuan.findByBinhLuan", query = "SELECT b FROM BinhLuan b WHERE b.binhLuan = :binhLuan"),
    @NamedQuery(name = "BinhLuan.findByNgayBinhLuan", query = "SELECT b FROM BinhLuan b WHERE b.ngayBinhLuan = :ngayBinhLuan")})
public class BinhLuan implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maBinhLuan")
    private Integer maBinhLuan;
    @Size(max = 100)
    @Column(name = "binhLuan")
    private String binhLuan;
    @Column(name = "ngayBinhLuan")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayBinhLuan;
    @JsonIgnore
    @JoinColumn(name = "maNTD", referencedColumnName = "maNTD")
    @ManyToOne
    private NhaTuyenDung maNTD;
    @JoinColumn(name = "maTK", referencedColumnName = "maTK")
    @ManyToOne
    @JsonProperty("taiKhoan")
    private TaiKhoan maTK;

    public BinhLuan() {
    }

    public BinhLuan(Integer maBinhLuan) {
        this.maBinhLuan = maBinhLuan;
    }

    public Integer getMaBinhLuan() {
        return maBinhLuan;
    }

    public void setMaBinhLuan(Integer maBinhLuan) {
        this.maBinhLuan = maBinhLuan;
    }

    public String getBinhLuan() {
        return binhLuan;
    }

    public void setBinhLuan(String binhLuan) {
        this.binhLuan = binhLuan;
    }

    public Date getNgayBinhLuan() {
        return ngayBinhLuan;
    }

    public void setNgayBinhLuan(Date ngayBinhLuan) {
        this.ngayBinhLuan = ngayBinhLuan;
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
        hash += (maBinhLuan != null ? maBinhLuan.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BinhLuan)) {
            return false;
        }
        BinhLuan other = (BinhLuan) object;
        if ((this.maBinhLuan == null && other.maBinhLuan != null) || (this.maBinhLuan != null && !this.maBinhLuan.equals(other.maBinhLuan))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vl.pojo.BinhLuan[ maBinhLuan=" + maBinhLuan + " ]";
    }

    /**
     * @return the maTK
     */
    public TaiKhoan getMaTK() {
        return maTK;
    }

    /**
     * @param maTK the maTK to set
     */
    public void setMaTK(TaiKhoan maTK) {
        this.maTK = maTK;
    }
    
}
