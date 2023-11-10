package com.sis2225.SchoolManagementSystem.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.ArrayList;

@Entity
@Table(name = "Teacher")
public class Teacher extends SysUser {
    private final static String ROLE = "Teacher";
    @Column(name = "age")
    private int age;
    @Column(name = "subject")
    private String subject;

    public Teacher() {

    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Teacher(String firstName, String lastName, int age, String subject,
                   String description,String username, String password) {
        super(firstName, lastName, ROLE, description,username,password);
        this.age = age;
        this.subject = subject;

    }

}