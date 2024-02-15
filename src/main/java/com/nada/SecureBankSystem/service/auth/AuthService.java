package com.nada.SecureBankSystem.service.auth;

import com.nada.SecureBankSystem.bo.auth.AuthenticationResponse;
import com.nada.SecureBankSystem.bo.auth.CreateLoginRequest;
import com.nada.SecureBankSystem.bo.auth.CreateSignupRequest;
import com.nada.SecureBankSystem.bo.auth.LogoutResponse;

public interface AuthService {

    void signup(CreateSignupRequest createSignupRequest);

    AuthenticationResponse login(CreateLoginRequest authenticationRequest);

    void logout(LogoutResponse logoutResponse);
}