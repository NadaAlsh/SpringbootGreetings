package com.nada.SecureBankSystem.service.functionalInterface;

import com.nada.SecureBankSystem.bo.admin.CreateSuggestionRequest;

@FunctionalInterface
public interface SuggestionProcessor {

    void suggestion (CreateSuggestionRequest suggestionRequest);
}
