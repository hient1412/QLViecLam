/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.repository.imply;


import com.vl.pojos.LoaiVL;
import com.vl.pojos.NhaTuyenDung;
import com.vl.pojos.TaiKhoan;
import com.vl.pojos.TinTuyenDung;
import com.vl.pojos.UngTuyen;
import com.vl.repository.TaiKhoanRepository;
import com.vl.repository.TinTuyenDungRepository;
import com.vl.repository.UngVienRepository;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@PropertySource("classpath:messages.properties")
public class TinTuyenDungRepositoryImply implements TinTuyenDungRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    private Environment env;


    @Override
    public List<TinTuyenDung> getTinTuyenDung(Map<String, String> params, int page) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = s.getCriteriaBuilder();
        CriteriaQuery<TinTuyenDung> query = builder.createQuery(TinTuyenDung.class);
        Root root = query.from(TinTuyenDung.class);
        query.select(root);

        List<Predicate> predicates = new ArrayList<>();

        String kw = params.get("kw");
        if (!kw.isEmpty() && kw != null) {
            Predicate p = builder.like(root.get("tenTTD").as(String.class), String.format("%%%s%%", kw));
            predicates.add(p);
        }

//        query = query.orderBy(builder.desc(root.get("maTTD")));
        query.where(predicates.toArray(new Predicate[]{})); 
        query.orderBy(builder.desc(root.get("maTTD")));
        Query q = s.createQuery(query);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            q.setMaxResults(size);
            q.setFirstResult((page - 1) * size);
        }

        return q.getResultList();
    }

    @Override
    public long countTinTuyenDung() {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        Query q = s.createQuery("Select count(*) From TinTuyenDung where trangThai = 1");
        return Long.parseLong(q.getSingleResult().toString());
    }

    @Override
    public List<TinTuyenDung> getTinTuyenDung(int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<TinTuyenDung> q = builder.createQuery(TinTuyenDung.class);
        Root root = q.from(TinTuyenDung.class);
        q.select(root);
        q.orderBy(builder.desc(root.get("maTTD")));

        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            query.setMaxResults(size);
            query.setFirstResult((page - 1) * size);
        }

        return query.getResultList();
    }

    @Override
    public boolean addTinTuyenDung(TinTuyenDung t) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(t);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public TinTuyenDung getTinTuyenDungId(int TinTuyenDungId) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(TinTuyenDung.class, TinTuyenDungId);
    }

    @Override
    public List<Object[]> getTinTuyenDungJoin(int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);

        Root rootT = q.from(TinTuyenDung.class);
        Root rootNTD = q.from(NhaTuyenDung.class);
        Root rootLVL = q.from(LoaiVL.class);

        q.where(builder.and(builder.equal(rootT.get("maNTD"), rootNTD.get("maNTD"))),
                builder.and(builder.equal(rootT.get("maLoaiVL"), rootLVL.get("maLoaiVL"))),
                builder.equal(rootT.get("trangThai"), 1));

        q.multiselect(rootT.get("maTTD"), rootT.get("tenTTD"), rootT.get("luong"), rootNTD.get("tenNTD"),
                rootT.get("noiLamViec"), rootT.get("ngayKT"), rootNTD.get("avatar"), rootNTD.get("maNTD"), rootLVL.get("tenLoaiVL"));

        q.orderBy(builder.desc(rootT.get("maTTD")));

        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            query.setMaxResults(size);
            query.setFirstResult((page - 1) * size);
        }

        return query.getResultList();
    }

    @Override
    public List<Object[]> getTinTuyenDungJoinID(int id) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);

        Root rootT = q.from(TinTuyenDung.class);
        Root rootNTD = q.from(NhaTuyenDung.class);

        q.where((builder.equal(rootT.get("maNTD"), rootNTD.get("maNTD"))));

        q.multiselect(rootT.get("maTTD"), rootT.get("tenTTD"), rootT.get("luong"), rootNTD.get("tenNTD"),
                rootT.get("noiLamViec"), rootT.get("ngayKT"), rootT.get("viTri"), rootT.get("moTaTTD"),
                rootT.get("soLuong"), rootT.get("kinhNghiem"), rootNTD.get("moTaNTD"));

        q.orderBy(builder.desc(rootT.get("maTTD")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> getTinTuyenDungJoin(Map<String, String> params, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);

        List<Predicate> predicates = new ArrayList<>();

        Root rootT = q.from(TinTuyenDung.class);
        Root rootNTD = q.from(NhaTuyenDung.class);
        Root rootLVL = q.from(LoaiVL.class);

        String kw = params.get("kw");
        if (!kw.isEmpty() && kw != null) {
            Predicate p = builder.like(rootT.get("tenTTD").as(String.class), String.format("%%%s%%", kw));
            predicates.add(p);
        }

        q.where(builder.and(builder.equal(rootT.get("maNTD"), rootNTD.get("maNTD")),
                        builder.equal(rootT.get("maLoaiVL"), rootLVL.get("maLoaiVL"))));

        q.multiselect(rootT.get("maTTD"), rootT.get("tenTTD"), rootT.get("luong"), rootNTD.get("tenNTD"),
                rootT.get("noiLamViec"), rootT.get("ngayKT"), rootNTD.get("avatar"), rootNTD.get("maNTD"), rootLVL.get("tenLoaiVL"));

        q.groupBy(rootT.get("maTTD"));
        q.orderBy(builder.desc(rootT.get("maTTD")));
        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            query.setMaxResults(size);
            query.setFirstResult((page - 1) * size);
        }

        return query.getResultList();
    }

    @Override
    public List<Object[]> getTinTuyenDungBykw(String kw, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = builder.createQuery(Object[].class);

        Root rootT = q.from(TinTuyenDung.class);
        Root rootNTD = q.from(NhaTuyenDung.class);
        Root rootLVL = q.from(LoaiVL.class);

        if (!kw.isEmpty() && kw != null) {
            q.where(builder.and(builder.equal(rootT.get("maNTD"), rootNTD.get("maNTD")),
                            builder.and(builder.equal(rootT.get("maLoaiVL"), rootLVL.get("maLoaiVL"))),
                            builder.and(builder.like(rootT.get("tenTTD").as(String.class), String.format("%%%s%%", kw))),
                            builder.equal(rootT.get("trangThai"), 1)));

            q.multiselect(rootT.get("maTTD"), rootT.get("tenTTD"), rootT.get("luong"), rootNTD.get("tenNTD"),
                    rootT.get("noiLamViec"), rootT.get("ngayKT"), rootNTD.get("avatar"), rootNTD.get("maNTD"), rootLVL.get("tenLoaiVL"));

            q.orderBy(builder.desc(rootT.get("maTTD")));
        } else {
            q.where(builder.and(builder.equal(rootT.get("maNTD"), rootNTD.get("maNTD")),
                    builder.and(builder.equal(rootT.get("maLoaiVL"), rootLVL.get("maLoaiVL"))),
                    builder.equal(rootT.get("trangThai"), 1)));

            q.multiselect(rootT.get("maTTD"), rootT.get("tenTTD"), rootT.get("luong"), rootNTD.get("tenNTD"),
                    rootT.get("noiLamViec"), rootT.get("ngayKT"), rootNTD.get("avatar"), rootNTD.get("maNTD"), rootLVL.get("tenLoaiVL"));

            q.orderBy(builder.desc(rootT.get("maTTD")));
        }
        
        
        
        Query query = session.createQuery(q);

        if (page > 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            query.setMaxResults(size);
            query.setFirstResult((page - 1) * size);
        }

        return query.getResultList();
    }

    @Override
    public List<Object[]> getTinTuyenDungByMaNTD(int maNTD, int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootT = query.from(TinTuyenDung.class);
        Root rootLVL = query.from(LoaiVL.class);
        Root rootNTD = query.from(NhaTuyenDung.class);

        query.where(builder.and(builder.equal(rootT.get("maLoaiVL"), rootLVL.get("maLoaiVL")),
                        builder.and(builder.equal(rootT.get("maNTD"), rootNTD.get("maNTD")),
                                builder.equal(rootT.get("maNTD"), maNTD))));

        query.multiselect(rootT.get("maTTD"), rootT.get("tenTTD"), rootT.get("ngayKT"), rootT.get("trangThai"),
                rootT.get("viTri"), rootT.get("luong"), rootT.get("noiLamViec"), rootT.get("soLuong"), rootT.get("kinhNghiem"),
                rootT.get("moTaTTD"), rootLVL.get("tenLoaiVL"), rootNTD.get("avatar"), rootNTD.get("tenNTD"),rootT.get("trangThai"));
        query.orderBy(builder.desc(rootT.get("maTTD")));
        Query q = session.createQuery(query);
        return q.getResultList();

    }
    
    @Override
    public boolean deleteTTD(TinTuyenDung ttd) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.delete(ttd);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateTTD(TinTuyenDung ttd) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.update(ttd);
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public List<Object[]> countTTDByLoaiVL() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);
        
        Root rootT = query.from(TinTuyenDung.class);
        Root rootLVL = query.from(LoaiVL.class);
        
        query.where(builder.equal(rootT.get("maLoaiVL"), rootLVL.get("maLoaiVL")));
        
        query.multiselect(rootLVL.get("maLoaiVL"),rootLVL.get("tenLoaiVL"),builder.count(rootT.get("maTTD")));
        
        query.groupBy(rootLVL.get("maLoaiVL"));
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

}