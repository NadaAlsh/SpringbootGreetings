package com.nada.SecureBankSystem.controller.UserController;

import com.nada.SecureBankSystem.bo.user.CreateUserRequest;
import com.nada.SecureBankSystem.bo.user.UpdateUserStatusRequest;
import com.nada.SecureBankSystem.service.user.UserService;
import com.nada.SecureBankSystem.service.admin.GuestSuggestionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    private final UserService userService;

    private final GuestSuggestionService suggestionService;


    public UserController(UserService userService, GuestSuggestionService suggestionService) {

        this.userService = userService;
        this.suggestionService = suggestionService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest createUserRequest) {
        try {
            userService.saveUser(createUserRequest);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Status should be either ACTIVE or INACTIVE");
        }
        return ResponseEntity.ok("User created successfully");
    }
    @PutMapping("/updateStatus")
    public ResponseEntity<String> updateUserStatus(@RequestParam Long userId, @RequestBody UpdateUserStatusRequest updateUserStatusRequest){
        try {
            userService.updateUserStatus(userId, updateUserStatusRequest);
        }catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Error in updating your status");
        }
         return ResponseEntity.ok("Status updated successfully");
    }
}
