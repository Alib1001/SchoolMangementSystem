package com.sis2225.SchoolManagementSystem.Controllers;

import com.sis2225.SchoolManagementSystem.Models.Student;
import com.sis2225.SchoolManagementSystem.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentDAO studentDAO;
    @Autowired
    public StudentController(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @GetMapping("/studentsList")
    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentDAO.getStudentById(id);
    }
    @PostMapping("/login")
    public ResponseEntity<Student> login(@RequestBody Student user) {
        Student authenticatedStudent = studentDAO.login(user.getUsername(), user.getPassword());

        if (authenticatedStudent != null) {
            return ResponseEntity.ok(authenticatedStudent);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
}
