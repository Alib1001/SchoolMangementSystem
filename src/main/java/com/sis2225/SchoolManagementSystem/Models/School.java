package com.sis2225.SchoolManagementSystem.Models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "schools")
public class School {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schoolid")
    private int id;
    @Column(name = "rating")
    private int rating;
    @Column(name = "name")
    private String name;
    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "focus")
    private String focus;

    @Column(name = "address")
    private String address;

    @Column(name = "review")
    private ArrayList<String> review;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<LearnClass> learnClasses = new ArrayList<>();

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SysUser> users = new ArrayList<>();

    @Column (name = "imguri")
    private String imguri;


    public void setId(int id) {
        this.id = id;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<LearnClass> getLearnClasses() {
        return learnClasses;
    }

    public void setLearnClasses(List<LearnClass> learnClasses) {
        this.learnClasses = learnClasses;
    }

    public String getImguri() {
        return imguri;
    }

    public void setImguri(String imguri) {
        this.imguri = imguri;
    }

    public School() {
    }

    public List<SysUser> getUsers() {
        return users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String getFocus() {
        return focus;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getReview() {
        return review;
    }

    public void setReview(ArrayList<String> review) {
        this.review = review;
    }
    public School(int rating, String name, String description, String focus, String address, String imguri) {
        this.rating = rating;
        this.name = name;
        this.description = description;
        this.focus = focus;
        this.address = address;
        this.imguri = imguri;
    }

    public void addUser(SysUser user) {
        users.add(user);
        user.setSchool(this);
    }

    public void removeUser(SysUser user) {
        users.remove(user);
        user.setSchool(null);
    }


    @Override
    public String toString() {
        return "School [id=" + id + ", rating=" + rating + ", schoolName=" + name + ", description=" + description + "," +
                " focus=" + focus + ", address=" + address + "imageURI=" + imguri +"]" ;
    }
}