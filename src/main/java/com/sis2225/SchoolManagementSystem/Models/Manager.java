package com.sis2225.SchoolManagementSystem.Models;
import jakarta.persistence.*;

@Entity
@Table(name = "Manager")
public class Manager extends SysUser{
    private final static String ROLE = "Manager";
    private final static String username = "admin";
    private final static String password = "admin";

    public Manager() {
        super(username,password,ROLE);
    }

}