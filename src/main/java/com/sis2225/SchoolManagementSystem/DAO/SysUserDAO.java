package com.sis2225.SchoolManagementSystem.DAO;

import com.sis2225.SchoolManagementSystem.Models.School;
import com.sis2225.SchoolManagementSystem.Models.Student;
import com.sis2225.SchoolManagementSystem.Models.SysUser;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    public List<SysUser> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM SysUser", SysUser.class).list();
        }
    }

    public SysUser getUserById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(SysUser.class, id);
        }
    }
}
