package com.jpa.service.impl;


import com.jpa.dto.FileData;
import com.jpa.dto.RestaurantDto;
import com.jpa.entity.Restaurant;
import com.jpa.exception.ResourceNotFoundException;
import com.jpa.repository.RestaurantRepository;
import com.jpa.service.FileService;
import com.jpa.service.RestaurantService;
import com.jpa.utils.Helper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {


    @Autowired
    private FileService fileService;

    @Autowired
    private RestaurantRepository repository;

    @Autowired
    private ModelMapper mapper;

    @Value("${restaurant-file-path}")
    private String bannerFolderPath;


    @Override
    public RestaurantDto saveUser(RestaurantDto restaurantDto) {
        restaurantDto.setId(Helper.generateRandomUserId());
        restaurantDto.setCreatedDateTime(LocalDateTime.now());
        Restaurant restaurant= mapper.map(restaurantDto,Restaurant.class);
        Restaurant saveRestaurant= repository.save(restaurant);
        return mapper.map(saveRestaurant,RestaurantDto.class);
    }

    @Override
    public RestaurantDto updateUser(RestaurantDto restaurantDto, String userId) {
         Restaurant restaurant=repository.findById(userId)
                .orElseThrow(()->new ResourceNotFoundException("RestaurantDto not found with id "+userId));

        restaurant.setName(restaurantDto.getName());
        restaurant.setAddress(restaurantDto.getAddress());
        restaurant.setCloseTime(restaurantDto.getCloseTime());
        restaurant.setCloseTime(restaurantDto.getCloseTime());
        restaurant.setDescription(restaurantDto.getDescription());

        Restaurant updatedRestaurantObject=repository.save(restaurant);

        return mapper.map(updatedRestaurantObject,RestaurantDto.class);
    }

    @Override
    public RestaurantDto getUserById(String id) {
        Restaurant restaurant=repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("User not found with id "+id));
        return mapper.map(restaurant,RestaurantDto.class);
    }

    @Override
    public List<RestaurantDto> getAllUser() {
        List<Restaurant> restaurants=repository.findAll();
        return restaurants.stream().map((restaurant) -> mapper.map(restaurant,RestaurantDto.class))
                .toList();
    }

    @Override
    public void deleteByUserId(String id) {

        Restaurant restaurant=repository.findById(id)
                .orElseThrow(() ->new ResourceNotFoundException("Restaurant not found with id "+id));

        repository.delete(restaurant);
    }

    @Override
    public Page<RestaurantDto> getUserWithPagination(Pageable pageable) {
        Page<Restaurant> restaurantPage=repository.findAll(pageable);

        return restaurantPage.map((restaurant) ->mapper.map(restaurant,RestaurantDto.class));
    }

    @Override
    public List<RestaurantDto> searchListOfUser(String keyword) {
        List<Restaurant> restaurants=  repository.searchUser(keyword);

        return restaurants.stream().map((restaurant) -> mapper.map(restaurant,RestaurantDto.class))
                .toList();
    }

    @Override
    public RestaurantDto uploadBanner(MultipartFile file, String id) throws IOException {

        String fileName=file.getOriginalFilename();

        String fileExtension=fileName.substring(fileName.lastIndexOf("."));

        String newFileName=new Date().getTime()+fileExtension;

        FileData fileData=fileService.uploadFile(file, bannerFolderPath + newFileName);

        Restaurant restaurant=repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("Restaurant not found with id "+id));
        restaurant.setBanner(fileData.fileName());
        repository.save(restaurant);
        return mapper.map(restaurant,RestaurantDto.class);
    }
}
