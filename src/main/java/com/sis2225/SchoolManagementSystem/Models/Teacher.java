package com.sis2225.SchoolManagementSystem.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "teachers")
public class Teacher {

    private final static String role = "Teacher";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "subject")
    private String subject;
    @Column (name = "description")
    private String description;

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getSubject() {
        return subject;
    }

    public String getRole() {
        return role;
    }




    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher() {
    }

    public Teacher(String firstName, String lastName, int age, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Teacher [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", subject=" + subject + "]";
    }
}