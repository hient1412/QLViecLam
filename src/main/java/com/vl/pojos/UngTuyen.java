/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.pojos;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "ungtuyen")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UngTuyen.findAll", query = "SELECT u FROM UngTuyen u"),
    @NamedQuery(name = "UngTuyen.findByMaUT", query = "SELECT u FROM UngTuyen u WHERE u.maUT = :maUT"),
    @NamedQuery(name = "UngTuyen.findByNgayUT", query = "SELECT u FROM UngTuyen u WHERE u.ngayUT = :ngayUT")})
public class UngTuyen implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "maUT")
    private Integer maUT;
    @Column(name = "ngayUT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayUT;
    @Column(name = "thuGT")
    private String thuGT;
    @JoinColumn(name = "maTTD", referencedColumnName = "maTTD")
    @ManyToOne
    private TinTuyenDung maTTD;
    @JoinColumn(name = "maUV", referencedColumnName = "maUV")
    @ManyToOne
    private UngVien maUV;

    public UngTuyen() {
    }

    public UngTuyen(Integer maUT) {
        this.maUT = maUT;
    }

    public Integer getMaUT() {
        return maUT;
    }

    public void setMaUT(Integer maUT) {
        this.maUT = maUT;
    }

    public Date getNgayUT() {
        return ngayUT;
    }

    public void setNgayUT(Date ngayUT) {
        this.ngayUT = ngayUT;
    }

    public TinTuyenDung getMaTTD() {
        return maTTD;
    }

    public void setMaTTD(TinTuyenDung maTTD) {
        this.maTTD = maTTD;
    }

    public UngVien getMaUV() {
        return maUV;
    }

    public void setMaUV(UngVien maUV) {
        this.maUV = maUV;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maUT != null ? maUT.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UngTuyen)) {
            return false;
        }
        UngTuyen other = (UngTuyen) object;
        if ((this.maUT == null && other.maUT != null) || (this.maUT != null && !this.maUT.equals(other.maUT))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.vl.pojos.UngTuyen[ maUT=" + maUT + " ]";
    }

    /**
     * @return the thuGT
     */
    public String getThuGT() {
        return thuGT;
    }

    /**
     * @param thuGT the thuGT to set
     */
    public void setThuGT(String thuGT) {
        this.thuGT = thuGT;
    }
    
}
