package com.sis2225.SchoolManagementSystem.DAO;

import com.sis2225.SchoolManagementSystem.Models.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
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
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Student", Student.class).getResultList();
    }

    public Student getStudentById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Transactional
    public void addStudent(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Transactional
    public void updateStudent(int id, Student student) {
        Session session = sessionFactory.getCurrentSession();
        Student existingStudent = session.get(Student.class, id);
        if (existingStudent != null) {
            existingStudent.setFirstName(student.getFirstName());
            existingStudent.setLastName(student.getLastName());
            existingStudent.setAge(student.getAge());
            existingStudent.setId(student.getId());
            existingStudent.setGrade(student.getGrade());
            existingStudent.setDescription(student.getDescription());
        }
    }

    @Transactional
    public void deleteStudent(int id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.get(Student.class, id);
        if (student != null) {
            session.delete(student);
        }
    }
}