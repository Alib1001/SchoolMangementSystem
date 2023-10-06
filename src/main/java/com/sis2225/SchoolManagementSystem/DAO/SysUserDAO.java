package com.sis2225.SchoolManagementSystem.DAO;

import com.sis2225.SchoolManagementSystem.Models.SysUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SysUserDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public SysUserDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public SysUser login(String username, String password) {
        try (Session session = sessionFactory.openSession()) {
            Query<SysUser> query = session.createQuery("FROM SysUser WHERE username = :username AND password = :password", SysUser.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            SysUser user = query.uniqueResult();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
