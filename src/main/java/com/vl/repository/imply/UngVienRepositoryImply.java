/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.repository.imply;

import com.vl.pojos.TaiKhoan;
import com.vl.pojos.UngVien;
import com.vl.repository.UngVienRepository;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class UngVienRepositoryImply implements UngVienRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<UngVien> getUngVien() {
        Session s = sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("From UngVien");
        return q.getResultList();
    }

    @Override
    public UngVien getUngVienID(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(UngVien.class, id);
    }

    @Override
    public boolean addUV(UngVien uv) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(uv);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public UngVien getUVByMaTK(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UngVien> query = builder.createQuery(UngVien.class);
        Root root = query.from(UngVien.class);
        query = query.select(root);

        query = query.where(builder.equal(root.join("maTK").get("maTK").as(Integer.class), id));

        Query q = session.createQuery(query);
        return (UngVien) q.getSingleResult();
    }

    @Override
    public boolean updateUV(UngVien uv) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            UngVien u = this.getUngVienID(uv.getMaUV());
            u.setHoUV(uv.getHoUV());
            u.setTenUV(uv.getTenUV());
            u.setNgaySinh(uv.getNgaySinh());
            u.setGioiTinh(uv.getGioiTinh());
            u.setDiaChi(uv.getDiaChi());
            u.setQueQuan(uv.getQueQuan());
            u.setNoiLamViec(uv.getNoiLamViec());
            u.setEmail(uv.getEmail());
            u.setMoTaUV(uv.getMoTaUV());
            u.setCv(uv.getCv());
            s.update(u);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean deleteUV(UngVien uv) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.delete(uv);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public UngVien getUVByTen(String tenUV) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UngVien> query = builder.createQuery(UngVien.class);
        Root root = query.from(UngVien.class);
        query = query.select(root);

        query = query.where(builder.equal(root.get("tenUV").as(String.class), tenUV));

        Query q = session.createQuery(query);
        return (UngVien) q.getSingleResult();
    }
}
