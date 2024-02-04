package com.nada.SecureBankSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CodedController {
    private List<Contact> contacts = new ArrayList<>();

    @GetMapping("/sayHi")
    public String sayHi() {
        return "Welcome";
    }

    @GetMapping("/greet")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return "Hello, " + name + "!";

    }

    @PostMapping("/farewell")
    public String farewell(@RequestBody Fields requestBody){
        String name = requestBody.getName();
        return "Goodbye, " +name+ "!";
    }

    @PostMapping("/addContact")
    public ResponseEntity<String> addContact(@RequestBody Contact contact) {
        if (contactExists(contact.getEmail())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Contact already exists with this email!");
        }
        contacts.add(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body("Contact added successfully!");
    }
        private boolean contactExists(String email) {
            return contacts.stream().anyMatch(c-> c.getEmail().equals(email));
        }

    @GetMapping("/getContactDetails")
    public ResponseEntity<Object> getContactDetails(@RequestParam String name) {
        Optional<Contact> foundContact = contacts.stream()
                .filter(c -> c.getName().equals(name))
                .findFirst();

        if(foundContact.isPresent()){
           return ResponseEntity.ok(foundContact.get());
        } else{
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Contact not found");
        }

    }
}
