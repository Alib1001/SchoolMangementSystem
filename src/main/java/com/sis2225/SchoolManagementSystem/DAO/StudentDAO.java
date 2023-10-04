package com.sis2225.SchoolManagementSystem.DAO;

import com.sis2225.SchoolManagementSystem.Models.Student;
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
public class StudentDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public StudentDAO(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Student> getAllStudents() {
        Session session = sessionFactory.openSession();
        return session.createQuery("FROM Student", Student.class).getResultList();
    }

    public Student getStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    public Student login(String username, String password) {
        try (Session session = sessionFactory.openSession()) {
            Query<Student> query = session.createQuery("FROM Student WHERE username = :username AND password = :password", Student.class);
            query.setParameter("username", username);
            query.setParameter("password", password);

            Student student = query.uniqueResult();
            return student;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}