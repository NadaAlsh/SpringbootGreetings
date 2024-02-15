package com.nada.SecureBankSystem.service.admin;

import com.nada.SecureBankSystem.entity.GuestSuggestionEntity;
import com.nada.SecureBankSystem.entity.UserEntity;
import com.nada.SecureBankSystem.repository.UserRepository;
import com.nada.SecureBankSystem.util.enums.SuggestionsStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService{

    private final UserRepository userRepository;

    public AdminServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<UserEntity> getAllUsers() {
        return null;
    }

}
