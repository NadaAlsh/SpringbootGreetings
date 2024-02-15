package com.nada.SecureBankSystem.service.admin;

import com.nada.SecureBankSystem.bo.admin.CreateSuggestionRequest;
import com.nada.SecureBankSystem.entity.GuestSuggestionEntity;
import com.nada.SecureBankSystem.repository.GuestSuggestionRepository;
import com.nada.SecureBankSystem.util.enums.SuggestionsStatus;
import com.nada.SecureBankSystem.service.functionalInterface.SuggestionProcessor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GuestSuggestionService implements SuggestionService{

    private final GuestSuggestionRepository suggestionRepository;


    public GuestSuggestionService(GuestSuggestionRepository suggestionRepository) {
        this.suggestionRepository = suggestionRepository;
    }

    public List<GuestSuggestionEntity> findAllDataSuggestions() {
        List<GuestSuggestionEntity> allSuggestions = suggestionRepository.findAll();
        return allSuggestions.stream()
                .distinct()
                .collect(Collectors.toList());
    }

    public List<GuestSuggestionEntity> printAndProcessSuggestion(String suggestionText) {
        return suggestionRepository.findAll();

    }
    public List<GuestSuggestionEntity> findAllCreatedSuggestions(){
        return suggestionRepository.findBySuggestionsStatus(SuggestionsStatus.CREATE);
    }
    public List<GuestSuggestionEntity> findAllRemovedSuggestions(){
        return suggestionRepository.findBySuggestionsStatus(SuggestionsStatus.REMOVE);
    }

//    public void processSuggestion(SuggestionProcessor suggestionProcessor){
//        List<GuestSuggestionEntity> suggestions = suggestionRepository.findAll();
//        for(GuestSuggestionEntity suggestion : suggestions){
//            suggestionProcessor.suggestionProcessor(suggestion.getSuggestionText());
//        }
//    }

    public void suggestionProcessor(CreateSuggestionRequest suggestionText){
        SuggestionProcessor processSuggestion = suggestion -> {
            GuestSuggestionEntity suggestionEntity = new GuestSuggestionEntity();
            suggestionEntity.setSuggestionText(suggestionEntity.getSuggestionText());
            suggestionRepository.save(suggestionEntity);
        };
    }

//    @Override
//    public void getSuggestionRate() {
//
//    }

    @Override
    public List<GuestSuggestionEntity> getCreatedStatusSuggestions() {
        return suggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getSuggestionsStatus().equals(SuggestionsStatus.CREATE))
                .collect(Collectors.toList());
    }


    @Override
    public List<GuestSuggestionEntity> getRemovedStatusSuggestions() {
        return suggestionRepository.findAll().stream()
                .filter(suggestion -> suggestion.getSuggestionsStatus().equals(SuggestionsStatus.REMOVE))
                .collect(Collectors.toList());

    }

    @Override
    public List<GuestSuggestionEntity> getAllDistinctSuggestions() {
        List<GuestSuggestionEntity> allSuggestions = suggestionRepository.findAll();
        return allSuggestions.stream()
                .distinct()
                .collect(Collectors.toList());
    }

}
