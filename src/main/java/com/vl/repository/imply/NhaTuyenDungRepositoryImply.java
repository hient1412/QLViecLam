/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.repository.imply;


import com.vl.pojos.BinhLuan;
import com.vl.pojos.NhaTuyenDung;
import com.vl.repository.NhaTuyenDungRepository;
import com.vl.repository.TaiKhoanRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class NhaTuyenDungRepositoryImply implements NhaTuyenDungRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Override
    public List<NhaTuyenDung> getNhaTuyenDung(String kw) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<NhaTuyenDung> query = builder.createQuery(NhaTuyenDung.class);
        Root root = query.from(NhaTuyenDung.class);
        query.select(root);

        if (!kw.isEmpty() && kw != null) {
            Predicate p = builder.like(root.get("tenNTD").as(String.class), String.format("%%s%%", kw));
            query = query.where(p);
        }
        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<NhaTuyenDung> getNhaTuyenDung() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From NhaTuyenDung");
        return q.getResultList();
    }

    @Override
    public NhaTuyenDung getNhaTuyenDungID(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(NhaTuyenDung.class, id);
    }

    @Override
    public List<BinhLuan> getBinhLuan(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<BinhLuan> query = builder.createQuery(BinhLuan.class);
        Root root = query.from(BinhLuan.class);
        query.select(root);

        query.where(builder.equal(root.get("maNTD"), id));

        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    public BinhLuan addBinhLuan(String bl, int ntdID) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        BinhLuan b = new BinhLuan();
        b.setBinhLuan(bl);
        b.setMaNTD(this.getNhaTuyenDungID(ntdID));
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        b.setMaTK(this.taiKhoanRepository.getTKByTen(auth.getName()));
        b.setNgayBinhLuan(new Date());

        s.save(b);

        return b;
    }

    @Override
    public boolean addNTD(NhaTuyenDung ntd) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(ntd);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public NhaTuyenDung getNTDByMaTK(int maTK) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NhaTuyenDung> query = builder.createQuery(NhaTuyenDung.class);
        Root root = query.from(NhaTuyenDung.class);
        query = query.select(root);

        query = query.where(builder.equal(root.join("maTK").get("maTK").as(Integer.class), maTK));

        Query q = session.createQuery(query);
        return (NhaTuyenDung) q.getSingleResult();
    }

    @Override
    public boolean updateNTD(NhaTuyenDung ntd) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            NhaTuyenDung n = this.getNhaTuyenDungID(ntd.getMaNTD());
            n.setDiaChi(ntd.getDiaChi());
            n.setEmail(ntd.getEmail());
            n.setMoTaNTD(ntd.getMoTaNTD());
            n.setSoDT(ntd.getSoDT());
            n.setTenNTD(ntd.getTenNTD());
            n.setAvatar(ntd.getAvatar());
            s.update(n);
            
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteNTD(NhaTuyenDung ntd) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.delete(ntd);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public NhaTuyenDung getNTDByMaTTD(int maTTD) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<NhaTuyenDung> query = builder.createQuery(NhaTuyenDung.class);
        Root root = query.from(NhaTuyenDung.class);
        query = query.select(root);

        query = query.where(builder.equal(root.join("tinTuyenDungSet").get("maTTD").as(Integer.class), maTTD));

        Query q = session.createQuery(query);
        return (NhaTuyenDung) q.getSingleResult();
    }


}
