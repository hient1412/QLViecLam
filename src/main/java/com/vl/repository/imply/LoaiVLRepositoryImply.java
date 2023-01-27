/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.repository.imply;

import com.vl.pojos.LoaiVL;
import com.vl.repository.LoaiVLRepository;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author DELL
 */
@Repository
@Transactional
public class LoaiVLRepositoryImply implements LoaiVLRepository {

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    @Autowired
    Environment env;
    
    @Override
    public List<LoaiVL> getLoaiVL(int page) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LoaiVL> q = builder.createQuery(LoaiVL.class);
        Root root = q.from(LoaiVL.class);
        q.select(root);
        
        Query query = session.createQuery(q);

        if (page != 0) {
            int size = Integer.parseInt(env.getProperty("page.size").toString());
            query.setMaxResults(size);
            query.setFirstResult((page - 1) * size);
        }

        return query.getResultList();
    }
    
    public List<LoaiVL> getLoaiVL() {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LoaiVL> q = builder.createQuery(LoaiVL.class);
        Root root = q.from(LoaiVL.class);
        q.select(root);
        
        Query query = session.createQuery(q);


        return query.getResultList();
    }

    @Override
    public LoaiVL getLoaiVLByID(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(LoaiVL.class,id);
    }

    @Override
    public boolean deleteLoaiVL(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            LoaiVL vl = s.get(LoaiVL.class,id);
            s.delete(vl);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean updateLoaiVL(LoaiVL vl) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try{
            s.update(vl);
            return true;
        } catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean addLoaiVL(LoaiVL vl) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try{
            s.save(vl);
            return true;
        } catch(HibernateException ex){
            System.err.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public LoaiVL getLVLByMaTTD(int maTTD) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<LoaiVL> query = builder.createQuery(LoaiVL.class);
        Root root = query.from(LoaiVL.class);
        query = query.select(root);

        query = query.where(builder.equal(root.join("tinTuyenDungSet").get("maTTD").as(Integer.class), maTTD));

        Query q = session.createQuery(query);
        return (LoaiVL) q.getSingleResult();
    }
    
}
