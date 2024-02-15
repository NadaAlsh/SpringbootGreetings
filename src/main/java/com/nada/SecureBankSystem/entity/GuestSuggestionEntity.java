package com.nada.SecureBankSystem.entity;

import com.nada.SecureBankSystem.util.enums.SuggestionsStatus;

import javax.persistence.*;

@Entity
@Table(name = "Guest")
public class GuestSuggestionEntity {
    @Id // this indicates that I assigned the id to be my primary key
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rate",nullable = false)
    private String rate;

    @Column(name = "suggestionText",nullable = false)
    private String suggestionText; // title

    @Column(name = "suggestion_status",nullable = false)
    private SuggestionsStatus suggestionsStatus;

    public GuestSuggestionEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getSuggestionText() {
        return suggestionText;
    }

    public void setSuggestionText(String suggestionText) {
        this.suggestionText = suggestionText;
    }

    public SuggestionsStatus getSuggestionsStatus() {
        return suggestionsStatus;
    }

    public void setSuggestionsStatus(SuggestionsStatus suggestionsStatus) {
        this.suggestionsStatus = suggestionsStatus;
    }
}
