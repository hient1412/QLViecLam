/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.pojos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author DELL
 */
@Entity
@Table(name = "admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByMaAdmin", query = "SELECT a FROM Admin a WHERE a.maAdmin = :maAdmin"),
    @NamedQuery(name = "Admin.findByHoAdmin", query = "SELECT a FROM Admin a WHERE a.hoAdmin = :hoAdmin"),
    @NamedQuery(name = "Admin.findByTenAdmin", query = "SELECT a FROM Admin a WHERE a.tenAdmin = :tenAdmin")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maAdmin")
    private Integer maAdmin;
    @Size(max = 20)
    @Column(name = "hoAdmin")
    private String hoAdmin;
    @Size(max = 10)
    @Column(name = "tenAdmin")
    private String tenAdmin;
    @Size(max = 50)
    @Column(name = "email")
    private String email;
    @Size(max = 15)
    @Column(name = "soDT")
    private String soDT;
    @JoinColumn(name = "maTK", referencedColumnName = "maTK")
    @OneToOne
    private TaiKhoan maTK;
    
    public Admin() {
    }

    public Admin(Integer maAdmin) {
        this.maAdmin = maAdmin;
    }

    public Integer getMaAdmin() {
        return maAdmin;
    }

    public void setMaAdmin(Integer maAdmin) {
        this.maAdmin = maAdmin;
    }

    public String getHoAdmin() {
        return hoAdmin;
    }

    public void setHoAdmin(String hoAdmin) {
        this.hoAdmin = hoAdmin;
    }

    public String getTenAdmin() {
        return tenAdmin;
    }

    public void setTenAdmin(String tenAdmin) {
        this.tenAdmin = tenAdmin;
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
        hash += (maAdmin != null ? maAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.maAdmin == null && other.maAdmin != null) || (this.maAdmin != null && !this.maAdmin.equals(other.maAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vl.pojo.Admin[ maAdmin=" + maAdmin + " ]";
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the soDT
     */
    public String getSoDT() {
        return soDT;
    }

    /**
     * @param soDT the soDT to set
     */
    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    
    
}
