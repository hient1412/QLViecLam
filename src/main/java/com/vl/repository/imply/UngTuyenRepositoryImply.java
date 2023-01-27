/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.repository.imply;

import com.vl.pojos.NhaTuyenDung;
import com.vl.pojos.TaiKhoan;
import com.vl.pojos.TinTuyenDung;
import com.vl.pojos.UngTuyen;
import com.vl.pojos.UngVien;
import com.vl.repository.TaiKhoanRepository;
import com.vl.repository.TinTuyenDungRepository;
import com.vl.repository.UngTuyenRepository;
import java.util.Date;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class UngTuyenRepositoryImply implements UngTuyenRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<UngTuyen> getUngTuyen(int maTTD) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<UngTuyen> query = builder.createQuery(UngTuyen.class);
        Root root = query.from(UngTuyen.class);
        query.select(root);

        query.where(builder.equal(root.get("maTTD"), maTTD));

        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public boolean addUngTuyen(UngTuyen ut) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        try {
            session.save(ut);
            return true;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Object[]> getUngTuyenByMaUV(int maUV) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootT = query.from(TinTuyenDung.class);
        Root rootUT = query.from(UngTuyen.class);
        Root rootUV = query.from(UngVien.class);
        Root rootNTD = query.from(NhaTuyenDung.class);

        query.where(builder.and(builder.equal(rootUT.get("maUV"), rootUV.get("maUV")),
                builder.and(builder.equal(rootUT.get("maTTD"), rootT.get("maTTD")),
                builder.and(builder.equal(rootT.get("maNTD"), rootNTD.get("maNTD")),
                builder.equal(rootUV.get("maUV"), maUV)))));

        query.multiselect(rootT.get("tenTTD"), rootNTD.get("tenNTD"), rootUT.get("ngayUT"), rootT.get("luong"));
        
        query.orderBy(builder.desc(rootUT.get("maUT")));
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

    @Override
    public List<Object[]> getUngTuyenByMaNTD(int maNTD) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> query = builder.createQuery(Object[].class);

        Root rootT = query.from(TinTuyenDung.class);
        Root rootUT = query.from(UngTuyen.class);
        Root rootUV = query.from(UngVien.class);
        Root rootNTD = query.from(NhaTuyenDung.class);

        query.where(builder.and(builder.equal(rootUT.get("maUV"), rootUV.get("maUV")),
                    builder.and(builder.equal(rootUT.get("maTTD"), rootT.get("maTTD")),
                    builder.and(builder.equal(rootT.get("maNTD"), rootNTD.get("maNTD")),
                    builder.equal(rootNTD.get("maNTD"), maNTD)))));

        query.multiselect(rootT.get("tenTTD"), rootUV.get("hoUV"), rootUV.get("tenUV"),
                rootUV.get("cv"), rootUT.get("thuGT"));
        query.orderBy(builder.desc(rootUT.get("maUT")));
        
        Query q = session.createQuery(query);
        return q.getResultList();
    }

}
