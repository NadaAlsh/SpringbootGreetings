package com.nada.SecureBankSystem.controller;

public class Contact {

    private String name;
    private String email;
    private int phone;

    public String getEmail() {
        return email;
    }

    public int getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }
}
