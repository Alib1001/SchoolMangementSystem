package com.sis2225.SchoolManagementSystem.Controllers;

import com.sis2225.SchoolManagementSystem.Models.School;
import com.sis2225.SchoolManagementSystem.DAO.SchoolDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    private final SchoolDAO schoolDAO;

    @Autowired
    public SchoolController(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    @GetMapping("/schoolList")
    public List<School> listSchools() {
        return schoolDAO.getAllSchools();
    }

    @PostMapping("/addSchool")
    public ResponseEntity<Void> addSchool(@RequestBody School school) {
        try {
            schoolDAO.addSchool(school);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateSchool")
    public ResponseEntity<Void> updateSchool(@RequestBody School school) {
        try {
            schoolDAO.updateSchool(school);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @DeleteMapping("/deleteSchool/{id}")
    public ResponseEntity<Void> deleteSchool(@PathVariable int id) {
        try {
            schoolDAO.deleteSchool(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}