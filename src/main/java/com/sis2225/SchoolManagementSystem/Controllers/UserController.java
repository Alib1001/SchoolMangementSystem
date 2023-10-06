    package com.sis2225.SchoolManagementSystem.Controllers;

    import com.sis2225.SchoolManagementSystem.DAO.SysUserDAO;
    import com.sis2225.SchoolManagementSystem.Models.Student;
    import com.sis2225.SchoolManagementSystem.DAO.StudentDAO;
    import com.sis2225.SchoolManagementSystem.Models.SysUser;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.http.HttpStatus;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    import java.util.List;
    @RestController
    @RequestMapping("/api/users")
    public class UserController {
        private final SysUserDAO sysUserDAO;

        @Autowired
        public UserController(SysUserDAO sysUserDAO) {
            this.sysUserDAO = sysUserDAO;
        }

        @PostMapping("/login")
        public ResponseEntity<SysUser> login(@RequestBody SysUser user) {
            SysUser authenticatedUser = sysUserDAO.login(user.getUsername(), user.getPassword());

            if (authenticatedUser != null) {
                return ResponseEntity.ok(authenticatedUser);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
            }
        }
    }

