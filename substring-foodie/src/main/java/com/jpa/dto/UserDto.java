package com.jpa.dto;

import com.jpa.entity.Role;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {


    private String id;

    private String name;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;


    private Role role;




    



   // ADMIN, CUSTOMER, DELIVERY_BOY

}
