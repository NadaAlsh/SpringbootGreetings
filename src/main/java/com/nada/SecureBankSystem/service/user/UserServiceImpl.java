package com.nada.SecureBankSystem.service.user;

import com.nada.SecureBankSystem.bo.user.UpdateUserStatusRequest;
import com.nada.SecureBankSystem.util.enums.Status;
import com.nada.SecureBankSystem.bo.user.CreateUserRequest;
import com.nada.SecureBankSystem.entity.UserEntity;
import com.nada.SecureBankSystem.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        userEntity.setStatus(Status.valueOf(createUserRequest.getStatus()));
        userRepository.save(userEntity);
    }

    @Override
    public void updateUserStatus(Long userId, UpdateUserStatusRequest updateUserStatusRequest) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow();
        if (!updateUserStatusRequest.getStatus().equals("ACTIVE") &&
                !updateUserStatusRequest.getStatus().equals("INACTIVE")) {
            throw new IllegalArgumentException("Invalid Status. Should be either Active or InActive");
        }
        userEntity.setStatus(Status.valueOf(updateUserStatusRequest.getStatus()));
        userRepository.save(userEntity);
    }

    public List<String> getAllUsersWithStrongPassword(){
        return userRepository.findAll()
                .stream().filter(e -> e.getPassword().length() > 8)
                .map(UserEntity::getName)
                .collect(Collectors.toList());
    }


//    @Override
//    public void updateStatus(Long userId, String newStatus) {
//        if (!Status.Active.name().equalsIgnoreCase(newStatus)) {
//            System.out.println("Invalid status");
//            return;
//        }
//        UserEntity userstatus = userRepository.findByID(userId);
//
//        if(userstatus != null) {
//            userstatus.setStatus(Status.valueOf(newStatus));
//            userRepository.save(userstatus);
//        } else {
//            System.out.println("User not found");
//         };
//
//    }
}
