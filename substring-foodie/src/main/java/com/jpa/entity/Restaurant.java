package com.jpa.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Restaurant {

    @Id

    private String id;

    private String name;

    @Lob
    private String description;

    private String address;


    private LocalTime openTime;


    private LocalTime closeTime;

    private Boolean open;

    private LocalDateTime createdDateTime;

    private String banner;



    @ManyToOne
    private  User user;




}
