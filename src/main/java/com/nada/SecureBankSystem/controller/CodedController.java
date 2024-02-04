package com.nada.SecureBankSystem.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class CodedController {
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
}
