package com.nada.SecureBankSystem.controller.UserController;

import com.nada.SecureBankSystem.bo.Status;
import com.nada.SecureBankSystem.bo.user.CreateUserRequest;
import com.nada.SecureBankSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest){
        userService.saveUser(createUserRequest);
        return ResponseEntity.ok("User created successfully");
    }
    @PostMapping("/updateStatus")
    public ResponseEntity<String> updateStatus(@RequestParam Long userId, String newStatus){
         userService.updateStatus(userId, newStatus);
        return ResponseEntity.ok("Status updated successfully");
    }
}
