package com.sis2225.SchoolManagementSystem.DAO;

import com.sis2225.SchoolManagementSystem.Models.School;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SchoolDAO {
    private final SessionFactory sessionFactory;

    @Autowired
    public SchoolDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<School> getAllSchools() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM School", School.class).list();
        }
    }

    public void addSchool(School school) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(school);
            session.getTransaction().commit();
        }
    }
    public void updateSchool(School school) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(school);
            session.getTransaction().commit();
        }
    }

    public void deleteSchool(int id) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            School school = session.get(School.class, id);
            if (school != null) {
                session.delete(school);
            }
            session.getTransaction().commit();
        }
    }




}
