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
    @Column(name = "grade")
    private ArrayList<String> classes;

    @Column(name = "description")
    private String description;

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

    public ArrayList<String> getClasses() {
        return classes;
    }

    public void setClasses(ArrayList<String> classes) {
        this.classes = classes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Teacher(String firstName, String lastName, int age, String subject, ArrayList<String> classes,
                   String description) {
        super(firstName, lastName, ROLE);
        this.age = age;
        this.subject = subject;
        this.classes = classes;
        this.description = description;
    }

}
