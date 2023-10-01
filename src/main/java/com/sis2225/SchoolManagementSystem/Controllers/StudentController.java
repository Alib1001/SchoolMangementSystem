package com.sis2225.SchoolManagementSystem.Controllers;

import com.sis2225.SchoolManagementSystem.Models.Student;
import com.sis2225.SchoolManagementSystem.DAO.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentDAO.addStudent(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@PathVariable int id, @RequestBody Student student) {
        studentDAO.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentDAO.deleteStudent(id);
    }
}
