/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.vl.repository.imply;

import com.vl.pojos.Admin;
import com.vl.repository.AdminRepository;
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
public class AdminRepositoryImply implements AdminRepository{

    @Autowired
    private LocalSessionFactoryBean sessionFactory;
    
    @Override
    public Admin getAdminByMaTK(int maTK) {
        Session session = this.sessionFactory.getObject().getCurrentSession();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Admin> query = builder.createQuery(Admin.class);
        Root root = query.from(Admin.class);
        query = query.select(root);

        query = query.where(builder.equal(root.join("maTK").get("maTK").as(Integer.class), maTK));

        Query q = session.createQuery(query);
        return (Admin) q.getSingleResult();
    }

    @Override
    public Admin getAdminID(int id) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        return s.get(Admin.class, id);
    }
    
    @Override
    public boolean updateAdmin(Admin ad) {
        Session s = this.sessionFactory.getObject().getCurrentSession();
        try {
            Admin admin = this.getAdminID(ad.getMaAdmin());
            admin.setEmail(ad.getEmail());
            admin.setHoAdmin(ad.getHoAdmin());
            admin.setTenAdmin(ad.getTenAdmin());
            admin.setSoDT(ad.getSoDT());
            s.update(admin);
            
            return true;
        } catch (HibernateException ex) {
            System.err.println(ex.getMessage());
        }
        return false;
    }
    
}
