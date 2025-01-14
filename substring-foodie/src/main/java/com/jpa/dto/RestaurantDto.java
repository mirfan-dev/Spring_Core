package com.jpa.dto;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantDto {

    private String id;

    private String name;

    private String description;

    private String address;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss a")
    private LocalTime openTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm:ss a")
    private LocalTime closeTime;

    private Boolean open = true;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss a")
    private LocalDateTime createdDateTime;


}
