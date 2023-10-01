package com.sis2225.SchoolManagementSystem;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {

    private final static String ROLE = "Student";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "studentIDNumber")
    private String studentId;

    @Column(name = "grade")
    private int grade;



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

    public String getStudentId() {
        return studentId;
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


    public Student() {
    }

    public Student(String firstName, String lastName, int age, String studentId, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.studentId = studentId;
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "Student [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", studentId=" + studentId + ", grade=" + grade + "]";
    }
}
