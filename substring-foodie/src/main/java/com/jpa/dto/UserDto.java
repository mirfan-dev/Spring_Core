package com.jpa.dto;


import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {


    private String id;

    private String name;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private List<RoleEntityDto> roleEntities=new ArrayList<>();


//    private Role role;




    



   // ADMIN, CUSTOMER, DELIVERY_BOY

}
