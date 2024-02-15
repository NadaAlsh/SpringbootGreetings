package com.nada.SecureBankSystem.controller.suggestionController;

import com.nada.SecureBankSystem.entity.GuestSuggestionEntity;
import com.nada.SecureBankSystem.service.admin.GuestSuggestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suggestionStatus")
public class SuggestionStatusController {
    private final GuestSuggestionService suggestionService;

    @Autowired
    public SuggestionStatusController(GuestSuggestionService suggestionService){
        this.suggestionService = suggestionService;
    }

    @GetMapping("/get")
    public List<GuestSuggestionEntity> getAllDistinctSuggestions(){
        return suggestionService.findAllDataSuggestions();
    }

    @GetMapping("/create")
    public List<GuestSuggestionEntity> getCreatedSuggestions(){
        return suggestionService.findAllCreatedSuggestions();
    }

    @GetMapping("/remove")
    public List<GuestSuggestionEntity> getRemovedSuggestions(){
        return suggestionService.findAllRemovedSuggestions();
    }

}
