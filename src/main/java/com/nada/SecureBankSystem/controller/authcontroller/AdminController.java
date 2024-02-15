//package com.nada.SecureBankSystem.controller.authcontroller;
//
//import com.nada.SecureBankSystem.bo.Contact;
//import com.nada.SecureBankSystem.bo.auth.CreateSignupRequest;
//import com.nada.SecureBankSystem.service.auth.AuthService;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/v1/auth")
//public class AdminController {
//
//    private final AuthService authService;
//    private List<Contact> guestList = new ArrayList<>();
//
//    public AuthController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    public AdminController(AuthService authService) {
//        this.authService = authService;
//    }
//
//    @GetMapping("/guests")
//    public ResponseEntity<Object> guestList(@RequestParam String name) {
//        for (int i = 0; i < guestList.size(); i++) {
//            if (guestList.get(i).getName().equals(name)) {
//                return ResponseEntity.ok(guestList.get(i));
//            }
//        }
//        return ResponseEntity.badRequest().body("Guests names not found");
//
//    }
//}
//
//
//
