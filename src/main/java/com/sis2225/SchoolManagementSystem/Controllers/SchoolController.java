package com.sis2225.SchoolManagementSystem.Controllers;

import com.sis2225.SchoolManagementSystem.Models.School;
import com.sis2225.SchoolManagementSystem.DAO.SchoolDAO;
import org.springframework.beans.factory.annotation.Autowired;
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


}
