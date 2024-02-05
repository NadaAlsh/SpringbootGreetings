package com.nada.SecureBankSystem.service;

import com.nada.SecureBankSystem.bo.Status;
import com.nada.SecureBankSystem.bo.user.CreateUserRequest;
import com.nada.SecureBankSystem.entity.UserEntity;
import com.nada.SecureBankSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(CreateUserRequest createUserRequest) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(createUserRequest.getName());
        userEntity.setEmail(createUserRequest.getEmail());
        userEntity.setPhoneNumber(createUserRequest.getPhone());
        userRepository.save(userEntity);
    }

    @Override
    public void updateStatus(Long userId, String newStatus) {
        if (!Status.Active.name().equalsIgnoreCase(newStatus)) {
            System.out.println("Invalid status");
            return;
        }
        UserEntity userstatus = userRepository.findByID(userId);

        if(userstatus != null) {
            userstatus.setStatus(Status.valueOf(newStatus));
            userRepository.save(userstatus);
        } else {
            System.out.println("User not found");
         };

    }
}
