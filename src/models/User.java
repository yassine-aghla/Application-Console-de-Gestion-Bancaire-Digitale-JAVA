package models;

import java.util.UUID;

public class User {
    private UUID id;
    private String fullName;
    private String email;
    private String address;
    private String password;

    public User(String fullName, String email, String address, String password) {
        this.id = UUID.randomUUID();
        this.fullName = fullName;
        this.email = email;
        this.address = address;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPassword() {
        return password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setFullName(String fullName){
        this.fullName=fullName;
    }
}


