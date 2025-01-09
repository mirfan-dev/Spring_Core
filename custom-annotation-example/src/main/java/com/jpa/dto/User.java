package com.jpa.dto;

import com.jpa.utils.ValidGender;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @Pattern(regexp = "^[a-zA-Z\\s]{3,20}$", message = "Name must be alphabetic and contain 3 to 20 characters")
    private String name;


    @Pattern(regexp = "^[a-zA-Z\\s]{3,20}$", message = "Name must be alphabetic and contain 3 to 20 characters")

    private String city;

    @Email
    private String email;

    @ValidGender(message = "Only 'male' and 'female' are allowed")
    private String gender;

    public @Pattern(regexp = "^[a-zA-Z\\s]{3,20}$", message = "Name must be alphabetic and contain 3 to 20 characters") String getCity() {
        return city;
    }

    public void setCity(@Pattern(regexp = "^[a-zA-Z\\s]{3,20}$", message = "Name must be alphabetic and contain 3 to 20 characters") String city) {
        this.city = city;
    }

    public @Email String getEmail() {
        return email;
    }

    public void setEmail(@Email String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public @Pattern(regexp = "^[a-zA-Z\\s]{3,20}$", message = "Name must be alphabetic and contain 3 to 20 characters") String getName() {
        return name;
    }

    public void setName(@Pattern(regexp = "^[a-zA-Z\\s]{3,20}$", message = "Name must be alphabetic and contain 3 to 20 characters") String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
