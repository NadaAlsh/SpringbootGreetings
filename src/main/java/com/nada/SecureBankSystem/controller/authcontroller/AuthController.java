package com.nada.SecureBankSystem.controller.authcontroller;

import com.nada.SecureBankSystem.bo.auth.AuthenticationResponse;
import com.nada.SecureBankSystem.bo.auth.CreateLoginRequest;
import com.nada.SecureBankSystem.bo.auth.CreateSignupRequest;
import com.nada.SecureBankSystem.bo.auth.LogoutResponse;
import com.nada.SecureBankSystem.service.auth.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    public ResponseEntity<String> createUser(@RequestBody CreateSignupRequest createSignupRequest){
        try {
            authService.signup(createSignupRequest);
            return ResponseEntity.status(HttpStatus.CREATED).body("User Created Successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Error while creating the account");
        } }


    @PostMapping("/login")
    public  ResponseEntity<AuthenticationResponse> login(@RequestBody CreateLoginRequest createLoginRequest){
        AuthenticationResponse response = authService.login(createLoginRequest);
        HttpStatus status = HttpStatus.OK;
        if(response == null){
            status = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(response, status);
        }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(@RequestBody LogoutResponse logoutResponse){
        authService.logout(logoutResponse);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}