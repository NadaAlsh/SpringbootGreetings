package com.nada.SecureBankSystem.service.admin;

import com.nada.SecureBankSystem.bo.admin.CreateSuggestionRequest;
import com.nada.SecureBankSystem.entity.GuestSuggestionEntity;
import com.nada.SecureBankSystem.entity.UserEntity;

import java.util.List;

public interface AdminService {
    //    public void processSuggestion(SuggestionProcessor suggestionProcessor){
    //        List<GuestSuggestionEntity> suggestions = suggestionRepository.findAll();
    //        for(GuestSuggestionEntity suggestion : suggestions){
    //            suggestionProcessor.suggestionProcessor(suggestion.getSuggestionText());
    //        }
    //    }
//    void suggestionProcessor(CreateSuggestionRequest suggestionText);

    //    @Override
    //    public void getSuggestionsRate() {
    //
    //    }
//    List<GuestSuggestionEntity> getCreateStatusSuggestions();
//
//    List<GuestSuggestionEntity> getRemovedStatusSuggestions();
//
    public List<UserEntity> getAllUsers();
}
