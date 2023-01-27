/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.pojos;

import java.io.Serializable;
import java.util.Set;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "loaivl")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "LoaiVL.findAll", query = "SELECT l FROM LoaiVL l"),
    @NamedQuery(name = "LoaiVL.findByMaLoaiVL", query = "SELECT l FROM LoaiVL l WHERE l.maLoaiVL = :maLoaiVL"),
    @NamedQuery(name = "LoaiVL.findByTenLoaiVL", query = "SELECT l FROM LoaiVL l WHERE l.tenLoaiVL = :tenLoaiVL")})
public class LoaiVL implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "maLoaiVL")
    private Integer maLoaiVL;
    @Size(max = 100)
    @Column(name = "tenLoaiVL")
    private String tenLoaiVL;
    @OneToMany(mappedBy = "maLoaiVL")
    private Set<TinTuyenDung> tinTuyenDungSet;
    public LoaiVL() {
    }

    public LoaiVL(Integer maLoaiVL) {
        this.maLoaiVL = maLoaiVL;
    }

    public Integer getMaLoaiVL() {
        return maLoaiVL;
    }

    public void setMaLoaiVL(Integer maLoaiVL) {
        this.maLoaiVL = maLoaiVL;
    }

    public String getTenLoaiVL() {
        return tenLoaiVL;
    }

    public void setTenLoaiVL(String tenLoaiVL) {
        this.tenLoaiVL = tenLoaiVL;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maLoaiVL != null ? maLoaiVL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoaiVL)) {
            return false;
        }
        LoaiVL other = (LoaiVL) object;
        if ((this.maLoaiVL == null && other.maLoaiVL != null) || (this.maLoaiVL != null && !this.maLoaiVL.equals(other.maLoaiVL))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vl.pojos.LoaiVL[ maLoaiVL=" + maLoaiVL + " ]";
    }

    /**
     * @return the tinTuyenDungSet
     */
    public Set<TinTuyenDung> getTinTuyenDungSet() {
        return tinTuyenDungSet;
    }

    /**
     * @param tinTuyenDungSet the tinTuyenDungSet to set
     */
    public void setTinTuyenDungSet(Set<TinTuyenDung> tinTuyenDungSet) {
        this.tinTuyenDungSet = tinTuyenDungSet;
    }

    
    
}
