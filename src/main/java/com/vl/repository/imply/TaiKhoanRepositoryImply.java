/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.repository.imply;

import com.vl.pojos.TaiKhoan;
import org.springframework.stereotype.Repository;
import com.vl.repository.TaiKhoanRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class TaiKhoanRepositoryImply implements TaiKhoanRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Autowired
    private Environment env;

    @Override
    public boolean addTaiKhoan(TaiKhoan tk) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.save(tk);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateTT(TaiKhoan tk) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.update(tk);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<TaiKhoan> getTK(String tk) {
        Session s = sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<TaiKhoan> query = builder.createQuery(TaiKhoan.class);
        Root root = query.from(TaiKhoan.class);
        query.select(root);

        if (!tk.isEmpty()) {
            Predicate p = builder.equal(root.get("taiKhoan").as(String.class), tk.trim());
            query = query.where(p);
        }

        Query q = s.createQuery(query);
        return q.getResultList();
    }

    @Override
    public TaiKhoan getTKByID(int maTK) {
        Session s = sessionFactory.getObject().getCurrentSession();
        return s.get(TaiKhoan.class, maTK);
    }

    @Override
    public TaiKhoan getTKByTen(String taiKhoan) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TaiKhoan> query = builder.createQuery(TaiKhoan.class);
        Root root = query.from(TaiKhoan.class);
        query = query.select(root);

        query = query.where(builder.equal(root.get("taiKhoan").as(String.class), taiKhoan));

        Query q = session.createQuery(query);
        return (TaiKhoan) q.getSingleResult();
    }

    @Override
    public List<TaiKhoan> getLoaiTK(String loaiTK, int page, int trangThai) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TaiKhoan> query = builder.createQuery(TaiKhoan.class);
        Root root = query.from(TaiKhoan.class);
        query = query.select(root);

        query = query.where(builder.equal(root.get("loaiTK").as(String.class), loaiTK),
                builder.equal(root.get("trangThai").as(Integer.class), trangThai));

        query = query.orderBy(builder.desc(root.get("maTK")));

        Query q = session.createQuery(query);

        if (page != 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            q.setMaxResults(size);
            q.setFirstResult((page - 1) * size);
        }
        return q.getResultList();
    }

    @Override
    public List<TaiKhoan> getTK(int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TaiKhoan> query = builder.createQuery(TaiKhoan.class);
        Root root = query.from(TaiKhoan.class);
        query = query.select(root);
        query.orderBy(builder.desc(root.get("maTK")));

        Query q = session.createQuery(query);

        if (page != 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            q.setMaxResults(size);
            q.setFirstResult((page - 1) * size);
        }
        return q.getResultList();
    }

    @Override
    public boolean deleteTK(TaiKhoan tk) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.delete(tk);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
    @Override
    public boolean updateTK(TaiKhoan tk) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            s.update(tk);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Object[]> countLoaiTK() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);
        Root rootTK = q.from(TaiKhoan.class);

        q.multiselect(rootTK.get("loaiTK"), builder.count(rootTK.get("maTK")));

        q.groupBy(rootTK.get("loaiTK"));

        Query query = s.createQuery(q);

        return query.getResultList();
    }
}