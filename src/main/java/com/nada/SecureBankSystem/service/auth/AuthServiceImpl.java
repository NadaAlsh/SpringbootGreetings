package com.nada.SecureBankSystem.service.auth;

import com.nada.SecureBankSystem.bo.auth.AuthenticationResponse;
import com.nada.SecureBankSystem.bo.auth.CreateLoginRequest;
import com.nada.SecureBankSystem.bo.auth.CreateSignupRequest;
import com.nada.SecureBankSystem.bo.auth.LogoutResponse;
import com.nada.SecureBankSystem.bo.customUserDetails.CustomUserDetails;
import com.nada.SecureBankSystem.config.JWTUtil;
import com.nada.SecureBankSystem.entity.RoleEntity;
import com.nada.SecureBankSystem.entity.UserEntity;
import com.nada.SecureBankSystem.exception.BodyGuardException;
import com.nada.SecureBankSystem.exception.UserNotFoundException;
import com.nada.SecureBankSystem.repository.RoleRepository;
import com.nada.SecureBankSystem.repository.UserRepository;
import com.nada.SecureBankSystem.util.enums.Roles;
import com.nada.SecureBankSystem.util.enums.Status;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
//
//import static org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction.authentication;
@Service
public class AuthServiceImpl implements AuthService{

    private final AuthenticationManager authenticationManager;

    private final CustomUserDetailService userDetailService;

    private final JWTUtil jwtUtil;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    private final RoleRepository roleRepository;

    private final UserRepository userRepository;

    public AuthServiceImpl(AuthenticationManager authenticationManager, CustomUserDetailService userDetailService,
                           JWTUtil jwtUtil, BCryptPasswordEncoder bCryptPasswordEncoder, RoleRepository roleRepository,
                           UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userDetailService = userDetailService;
        this.jwtUtil = jwtUtil;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }


    @Override
    public void signup(CreateSignupRequest createSignupRequest) {
        RoleEntity roleEntity = roleRepository.findRoleEntityByTitle(Roles.user.name())
                .orElseThrow(() -> new BodyGuardException("no Roles Found"));;
        roleEntity.setTitle(Roles.user);
        roleRepository.save(roleEntity);
        UserEntity user = new UserEntity();
        user.setName(createSignupRequest.getName());
        user.setPhoneNumber(createSignupRequest.getPhoneNumber());
        user.setEmail(createSignupRequest.getEmail());
        user.setStatus(Status.ACTIVE);
        user.setRoles(roleEntity);
        user.setPassword(bCryptPasswordEncoder.encode(createSignupRequest.getPassword()));
        userRepository.save(user);
    }

    @Override
    public void logout(LogoutResponse logoutResponse) {
        requiredNonNull(logoutResponse.getToken(),"token");
    }

    private void requiredNonNull(Object obj, String name) {
        if (obj == null || obj.toString().isEmpty()){
            throw new BodyGuardException(name + " can't be empty");
        }
    }

    @Override
    public AuthenticationResponse login(CreateLoginRequest createLoginRequest) {
        requiredNonNull(createLoginRequest.getUsername(), "username");
        requiredNonNull(createLoginRequest.getPassword(), "password");

        String username = createLoginRequest.getUsername().toLowerCase();
        String password = createLoginRequest.getPassword();
        authentication(username, password);

        CustomUserDetails userDetails = userDetailService.loadUserByUsername(username);
        String accessToken = jwtUtil.generateToken(userDetails);

        AuthenticationResponse response = new AuthenticationResponse();
        response.setId(userDetails.getId());
        response.setUsername(userDetails.getUsername());
        response.setRole(userDetails.getRole());
        response.setToken("Bearer " + accessToken);

        return response;
    }



    private void authentication(String username, String password){
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        }catch (BodyGuardException e){
            throw new BodyGuardException("Incorrect password");
        }catch (AuthenticationServiceException e){
            throw new UserNotFoundException("Incorrect username");
        }
    }

}

