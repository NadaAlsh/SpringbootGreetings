package com.nada.SecureBankSystem.repository;

import com.nada.SecureBankSystem.entity.GuestSuggestionEntity;
import com.nada.SecureBankSystem.util.enums.SuggestionsStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GuestSuggestionRepository extends JpaRepository<GuestSuggestionEntity, Long>{

    List<GuestSuggestionEntity> findBySuggestionsStatus(SuggestionsStatus status);
}
