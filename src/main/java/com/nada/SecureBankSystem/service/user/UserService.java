package com.nada.SecureBankSystem.service.user;

import com.nada.SecureBankSystem.bo.user.CreateUserRequest;
import com.nada.SecureBankSystem.bo.user.UpdateUserStatusRequest;

import java.util.List;

public interface UserService {
    void saveUser(CreateUserRequest createUserRequest);

    //void updateStatus(Long userId, String newStatus);

    void updateUserStatus(Long userId, UpdateUserStatusRequest updateUserRequest);

    List<String> getAllUsersWithStrongPassword();
}
