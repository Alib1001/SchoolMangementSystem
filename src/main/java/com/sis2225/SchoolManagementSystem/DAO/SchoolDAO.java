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
}
