package com.jpa.service;

import com.jpa.dto.RestaurantDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantService {


    RestaurantDto saveUser(RestaurantDto user);


    public RestaurantDto updateUser(RestaurantDto restaurantDto, String userId);


    public RestaurantDto getUserById(String id);

    public List<RestaurantDto> getAllUser();


    public void deleteByUserId(String id);

    public Page<RestaurantDto> getUserWithPagination(Pageable pageable);

    public List<RestaurantDto> searchListOfUser(String keyword);

}
