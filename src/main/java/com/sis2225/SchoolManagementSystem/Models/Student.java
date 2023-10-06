package com.sis2225.SchoolManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
@Table(name = "students")
public class Student extends SysUser {

    private final static String ROLE = "Student";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "age")
    private int age;

    @Column(name = "grade")
    private int grade;

    @Column(name = "description")
    private String description;

    public Student() {
    }

    public int getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public int getGrade() {
        return grade;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public Student(String firstName, String lastName, int age, int grade) {
        super(firstName, lastName);
        this.age = age;
        this.grade = grade;
    }
}
