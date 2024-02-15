package com.nada.SecureBankSystem.controller.suggestionController;

import com.nada.SecureBankSystem.bo.admin.CreateSuggestionRequest;
import com.nada.SecureBankSystem.entity.GuestSuggestionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import com.nada.SecureBankSystem.service.admin.GuestSuggestionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/suggestions")
public class SuggestionController {
    private final GuestSuggestionService suggestionService;

    @Autowired
    public SuggestionController(GuestSuggestionService suggestionService){
        this.suggestionService = suggestionService;
    }

    @PostMapping("/suggest")
    public ResponseEntity<List<GuestSuggestionEntity>> handleSuggestions(@RequestBody CreateSuggestionRequest suggestionRequest){
        List<GuestSuggestionEntity> suggestionList = suggestionService.printAndProcessSuggestion(suggestionRequest.getSuggestionText());
        return ResponseEntity.ok(suggestionList);
    }
    @PostMapping("/createSuggestion")
    public ResponseEntity<String> suggestionProcessor(CreateSuggestionRequest suggestionText){
        suggestionService.suggestionProcessor(suggestionText);
        return ResponseEntity.ok("Thank you for your suggestions!");
    }

}
