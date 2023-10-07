    package com.sis2225.SchoolManagementSystem.Controllers;

    import com.sis2225.SchoolManagementSystem.DAO.SysUserDAO;
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

        @GetMapping("/userList")
        public List<SysUser> getAllStudents() {
            return sysUserDAO.getAllUsers();
        }

        @GetMapping("/{id}")
        public SysUser getStudentById(@PathVariable int id) {
            return sysUserDAO.getUserById(id);
        }

        @PostMapping("/addUser")
        public ResponseEntity<Void> addUser(@RequestBody SysUser user) {
            try {
                sysUserDAO.addUser(user);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        @PutMapping("/updateUser/{id}")
        public ResponseEntity<Void> updateUser(@PathVariable int id, @RequestBody SysUser updatedUser) {
            try {
                SysUser existingUser = sysUserDAO.getUserById(id);
                if (existingUser != null) {
                    updatedUser.setId(id);
                    sysUserDAO.updateUser(updatedUser);
                    return ResponseEntity.ok().build();
                } else {
                    return ResponseEntity.notFound().build();
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        @DeleteMapping("/deleteUser/{id}")
        public ResponseEntity<Void> deleteUser(@PathVariable int id) {
            try {
                SysUser existingUser = sysUserDAO.getUserById(id);
                if (existingUser != null) {
                    sysUserDAO.deleteUser(id);
                    return ResponseEntity.ok().build();
                } else {
                    return ResponseEntity.notFound().build();
                }
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
    }

