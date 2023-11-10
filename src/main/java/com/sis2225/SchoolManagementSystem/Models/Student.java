package com.sis2225.SchoolManagementSystem.Models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "students")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Student extends SysUser {

    private final static String ROLE = "Student";

    @Column(name = "age")
    private int age;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "class_id")

    private LearnClass learnClass;

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private List<Mark> marks = new ArrayList<>();


    public Student() {
    }

    public LearnClass getLearnClass() {
        return learnClass;
    }

    public void setLearnClass(LearnClass learnClass) {
        this.learnClass = learnClass;
    }

    public List<Mark> getMarks() {
        return marks;
    }

    public void setMarks(List<Mark> marks) {
        this.marks = marks;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole(){
        return ROLE;
    }



    public Student(String firstName, String lastName, String description, int age, String clas,String username, String password) {
        super(firstName, lastName ,ROLE, description, username,password);
        this.age = age;

    }
}