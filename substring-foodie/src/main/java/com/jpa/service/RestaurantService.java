package com.jpa.service;

import com.jpa.dto.RestaurantDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface RestaurantService {


    RestaurantDto saveUser(RestaurantDto user);


    public RestaurantDto updateUser(RestaurantDto restaurantDto, String userId);


    public RestaurantDto getUserById(String id);

    public List<RestaurantDto> getAllUser();


    public void deleteByUserId(String id);

    public Page<RestaurantDto> getUserWithPagination(Pageable pageable);

    public List<RestaurantDto> searchListOfUser(String keyword);

    public RestaurantDto uploadBanner(MultipartFile file, String id) throws IOException;

}
