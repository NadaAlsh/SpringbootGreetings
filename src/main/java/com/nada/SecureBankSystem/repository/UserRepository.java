package com.nada.SecureBankSystem.repository;

import com.nada.SecureBankSystem.util.enums.Status;
import com.nada.SecureBankSystem.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {

   Optional<UserEntity> findByUsername(String username);
}
