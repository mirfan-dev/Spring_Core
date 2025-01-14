package com.jpa.controller;


import com.jpa.dto.RestaurantDto;
import com.jpa.service.RestaurantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v2/restaurant")
public class RestaurantController {

    @Autowired
    private RestaurantService service;

    @PostMapping
    public ResponseEntity<RestaurantDto> saveUser(@Valid @RequestBody RestaurantDto restaurantDto){

        RestaurantDto userDto1=service.saveUser(restaurantDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<RestaurantDto> getEmployeeById(@PathVariable String id){
        RestaurantDto userDto=service.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAllRestaurant(){

        List<RestaurantDto> userDtos=service.getAllUser();
        return new ResponseEntity<>(userDtos,HttpStatus.OK);
    }

    @PutMapping("{employeeId}")
    public ResponseEntity<RestaurantDto> updatedRestaurant(@RequestBody RestaurantDto restaurantDto,@PathVariable String id){

        RestaurantDto restaurantDto1=service.updateUser(restaurantDto,id);
        return new ResponseEntity<>(restaurantDto1,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String userId){

        service.deleteByUserId(userId);
        return ResponseEntity.ok("EmployeeDto Deleted Successfully");
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<RestaurantDto>> getRestaurantWithPagination(@RequestParam(value = "pageNumber", defaultValue = "1") int page
            , @RequestParam(value = "pageSize", defaultValue = "5") int size
            , @RequestParam(value = "sortBy",defaultValue ="id" ) String sortBy
            , @RequestParam(value = "sortDir",defaultValue ="id" ) String sortDir){

        Sort sort=sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() :Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page,size,sort);

        return ResponseEntity.ok(service.getUserWithPagination(pageable));
    }
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<RestaurantDto>> searchRestaurantWithField(@PathVariable String keyword){
        List<RestaurantDto> restaurantDto=service.searchListOfUser(keyword);
        return new ResponseEntity<>(restaurantDto,HttpStatus.OK);
    }
}
