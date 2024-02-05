package com.nada.SecureBankSystem.repository;

import com.nada.SecureBankSystem.bo.Status;
import com.nada.SecureBankSystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

    UserEntity findByStatus(Status status);
    UserEntity findByID(Long id);
}
