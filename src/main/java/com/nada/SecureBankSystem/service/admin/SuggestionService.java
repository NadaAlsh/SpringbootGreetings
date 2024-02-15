package com.nada.SecureBankSystem.service.admin;

import com.nada.SecureBankSystem.bo.admin.CreateSuggestionRequest;
import com.nada.SecureBankSystem.entity.GuestSuggestionEntity;

import java.util.List;

public interface SuggestionService {
//    List<UserEntity> getAllUsers();
    //void suggestionProcessor(CreateSuggestionRequest suggestionText);


    //void getSuggestionRate ();
    List<GuestSuggestionEntity> getCreatedStatusSuggestions();
    List<GuestSuggestionEntity> getRemovedStatusSuggestions();
    List<GuestSuggestionEntity> getAllDistinctSuggestions();

    List<GuestSuggestionEntity> printAndProcessSuggestion(String suggestionText);


}
