package com.nada.SecureBankSystem.service;

import com.nada.SecureBankSystem.bo.user.CreateUserRequest;
import com.nada.SecureBankSystem.bo.user.UpdateUserStatusRequest;

public interface UserService {
    void saveUser(CreateUserRequest createUserRequest);

    //void updateStatus(Long userId, String newStatus);

    void updateUserStatus(Long userId, UpdateUserStatusRequest updateUserRequest);

}
