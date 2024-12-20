package com.jpa.entity;

import com.jpa.dto.UserType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity

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



    @Enumerated(EnumType.STRING)
    private UserType type=UserType.STUDENT;

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Laptop laptop;

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(UserType type) {
        this.type = type;
    }

    public void setUserExtraInformation(String userExtraInformation) {
        this.userExtraInformation = userExtraInformation;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return isActive;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public String getName() {
        return name;
    }

    public UserType getType() {
        return type;
    }

    public String getUserExtraInformation() {
        return userExtraInformation;
    }

    public int getUserId() {
        return userId;
    }
}
