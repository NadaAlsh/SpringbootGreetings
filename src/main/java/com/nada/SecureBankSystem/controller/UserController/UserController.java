package com.nada.SecureBankSystem.controller.UserController;

import com.nada.SecureBankSystem.bo.user.CreateUserRequest;
import com.nada.SecureBankSystem.bo.user.UpdateUserStatusRequest;
import com.nada.SecureBankSystem.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest) {
        try {
            userService.saveUser(createUserRequest);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok("User created successfully");
    }
    @PutMapping("/updateStatus")
    public ResponseEntity<String> updateUserStatus(@RequestParam Long userId, @RequestBody UpdateUserStatusRequest updateUserStatusRequest){
        try {
            userService.updateUserStatus(userId, updateUserStatusRequest);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
         return ResponseEntity.ok("Status updated successfully");
    }
}
