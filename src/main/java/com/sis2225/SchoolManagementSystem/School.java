package com.sis2225.SchoolManagementSystem;

import jakarta.persistence.*;

@Entity
@Table(name = "schools")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "rating")
    private int rating;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

    @Column(name = "focus")
    private String focus;

    @Column(name = "address")
    private String address;


    public String getImguri() {
        return imguri;
    }

    public void setImguri(String imguri) {
        this.imguri = imguri;
    }

    @Column (name = "imguri")
    private String imguri;

    public School() {
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
    public School(int rating, String name, String description, String focus, String address, String imguri) {
        this.rating = rating;
        this.name = name;
        this.description = description;
        this.focus = focus;
        this.address = address;

        this.imguri = imguri;
    }

    @Override
    public String toString() {
        return "School [id=" + id + ", rating=" + rating + ", schoolName=" + name + ", description=" + description + "," +
                " focus=" + focus + ", address=" + address + "imageURI=" + imguri +"]" ;
    }
}
