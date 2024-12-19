package com.jpa.entity;

import com.jpa.dto.UserType;
import jakarta.persistence.*;

@Entity
@Table(name = "jpa_user")
public class User {

    @Id
    @Column(name = "jpa_user_id")
    private int userId;
    @Column(name = "jpa_user_name", nullable = false)
    private String name;
    private String email;
    private int age;
    private boolean isActive;

    @Transient
    private String userExtraInformation;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private UserType type=UserType.STUDENT;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserType getType() {
        return type;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public String getUserExtraInformation() {
        return userExtraInformation;
    }

    public void setUserExtraInformation(String userExtraInformation) {
        this.userExtraInformation = userExtraInformation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
