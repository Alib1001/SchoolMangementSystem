package com.sis2225.SchoolManagementSystem.Models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "learn_classes")
public class LearnClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "school_id")
    private School school;

    @ManyToMany
    @JoinTable(
            name = "learn_class_subject",
            joinColumns = @JoinColumn(name = "learn_class_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private List<LearnSubject> subjects = new ArrayList<>();


    public List<LearnSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<LearnSubject> subjects) {
        this.subjects = subjects;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public School getSchool() {
        return school;
    }
    public void setSchool(School school) {
        this.school = school;
    }

}