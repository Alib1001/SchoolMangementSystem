package com.sis2225.SchoolManagementSystem.Controllers;

import com.sis2225.SchoolManagementSystem.School;
import com.sis2225.SchoolManagementSystem.DAO.SchoolDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SchoolController {
    private final SchoolDAO schoolDAO;

    @Autowired
    public SchoolController(SchoolDAO schoolDAO) {
        this.schoolDAO = schoolDAO;
    }

    // Отобразить список всех школ
    @GetMapping("/schoolList")
    public List<School> listSchools() {
        return schoolDAO.getAllSchools();
    }


}
