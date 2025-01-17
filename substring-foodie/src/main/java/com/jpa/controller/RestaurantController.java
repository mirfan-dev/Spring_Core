package com.jpa.controller;


import com.jpa.dto.FileData;
import com.jpa.dto.RestaurantDto;
import com.jpa.service.FileService;
import com.jpa.service.RestaurantService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/v2/restaurant")
public class RestaurantController {

    private Logger logger= LoggerFactory.getLogger(RestaurantController.class);



    @Value("${restaurant-file-path}")
    private String bannerFolderPath;



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

    @PostMapping("/upload-banner/{id}")
    public ResponseEntity<RestaurantDto> uploadFile(@RequestParam("banner")MultipartFile banner, @PathVariable String id) throws IOException {

        logger.info("Received file: {}", banner.getOriginalFilename());
        logger.info("Content type: {}", banner.getContentType());
        logger.info("File size: {}", banner.getSize());

        RestaurantDto restaurantDto=service.uploadBanner(banner,id);

        return ResponseEntity.ok(restaurantDto);


    }

    @GetMapping("/{id}/banner")
    public ResponseEntity<Resource> serveFile(@PathVariable String id) throws IOException{

        RestaurantDto restaurantDto=service.getUserById(id);
        String fullPath=bannerFolderPath + restaurantDto.getBanner();
        Path filePath= Paths.get(fullPath);

        Resource resource=new UrlResource(filePath.toUri());

        if(resource.exists()){
            return ResponseEntity.ok()
                    .contentType(MediaType.IMAGE_PNG)
                    .body(resource);
        }else {
            throw new FileNotFoundException("File Not found");
        }

    }
}
