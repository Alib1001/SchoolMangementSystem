package com.sis2225.SchoolManagementSystem.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
@Entity
@Table(name = "students")
public class Student extends SysUser {

    private final static String ROLE = "Student";

    @Column(name = "age")
    private int age;

    public String getClas() {
        return clas;
    }

    public void setClas(String clas) {
        this.clas = clas;
    }

    @Column(name = "clas")
    private String clas;

    @Column(name = "description")
    private String description;

    public Student() {
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return clas;
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

    public void setGrade(String grade) {
        this.clas = grade;
    }

    public Student(String firstName, String lastName, int age, String clas,String username, String password) {
        super(firstName, lastName,ROLE,username,password);
        this.age = age;
        this.clas = clas;
    }
}
