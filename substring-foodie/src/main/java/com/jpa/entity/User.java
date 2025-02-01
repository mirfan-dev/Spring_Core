package com.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    private String id;

    private String name;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;
//
//    @Enumerated(EnumType.STRING)
//    private Role role; // ADMIN, CUSTOMER, DELIVERY_BOY

    private Boolean isAvailable=true;

    private LocalDate createDate;

    private boolean enabled=true;



    // feel free to add more fields ad required

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<RoleEntity> roleEntities = new ArrayList<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Restaurant> restaurants = new ArrayList<>();



    @PrePersist
    public void preSave(){
        this.createDate=LocalDate.now();
    }


    @PostPersist
    public void postSave(){
        this.createDate=LocalDate.now();
    }


    public User(String id, String name, String email, String password, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;


    }







}
