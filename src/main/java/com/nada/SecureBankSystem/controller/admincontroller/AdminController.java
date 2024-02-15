package com.nada.SecureBankSystem.controller.admincontroller;

import com.nada.SecureBankSystem.entity.UserEntity;
import com.nada.SecureBankSystem.service.admin.AdminService;
import com.nada.SecureBankSystem.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    private final UserService userService;
    private final AdminService adminService;


    public AdminController(UserService userService, AdminService adminService) {

        this.userService = userService;
        this.adminService = adminService;
    }

    public ResponseEntity<List<String>> getAllUsersWithStrongPassword(){
        List<String> getAllUsers = userService.getAllUsersWithStrongPassword();
        return ResponseEntity.ok(getAllUsers);
    }
    @GetMapping("/getAllUsers")
    public List<UserEntity> getAllUsers(){
        return adminService.getAllUsers();
    }
}
