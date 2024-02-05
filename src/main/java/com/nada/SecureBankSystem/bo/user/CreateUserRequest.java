package com.nada.SecureBankSystem.bo.user;

import com.nada.SecureBankSystem.bo.Status;

public class CreateUserRequest {

    private String name;
    private String email;
    private String phone;
    private String status;

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {return status; }

    public void setStatus(String status) {this.status = status; }
}


