package com.nada.SecureBankSystem.service;

import com.nada.SecureBankSystem.bo.Status;
import com.nada.SecureBankSystem.bo.user.CreateUserRequest;

public interface UserService {
    void saveUser(CreateUserRequest createUserRequest);

    void updateStatus(Long userId, String newStatus);


}
