package com.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity

public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String model;

    private String about;

    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public void setAbout(String about) {
        this.about = about;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAbout() {
        return about;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public User getUser() {
        return user;
    }
}
