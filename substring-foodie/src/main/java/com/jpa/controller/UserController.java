package com.jpa.controller;


import com.jpa.dto.UserDto;
import com.jpa.entity.User;
import com.jpa.service.UserService;
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
@RequestMapping("/api/v1/users")
public class UserController {


    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<UserDto> saveUser(@Valid @RequestBody UserDto userDto){

        UserDto userDto1=service.saveUser(userDto);
        return new ResponseEntity<>(userDto1, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> getEmployeeById(@PathVariable String id){
        UserDto userDto=service.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllEmployees(){

        List<UserDto> userDtos=service.getAllUser();
        return new ResponseEntity<>(userDtos,HttpStatus.OK);
    }

    @PutMapping("{employeeId}")
    public ResponseEntity<UserDto> updatedEmployee(@RequestBody UserDto userDto,@PathVariable String id){

        UserDto userDto1=service.updateUser(userDto,id);
        return new ResponseEntity<>(userDto1,HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String userId){

        service.deleteByUserId(userId);
        return ResponseEntity.ok("EmployeeDto Deleted Successfully");
    }

    @GetMapping("/pagination")
    public ResponseEntity<Page<UserDto>> getEmployeeWithPagination(@RequestParam(value = "pageNumber", defaultValue = "1") int page
            , @RequestParam(value = "pageSize", defaultValue = "5") int size
            , @RequestParam(value = "sortBy",defaultValue ="id" ) String sortBy
            , @RequestParam(value = "sortDir",defaultValue ="id" ) String sortDir){

        Sort sort=sortDir.equalsIgnoreCase("asc") ? Sort.by(sortBy).ascending() :Sort.by(sortBy).descending();
        Pageable pageable= PageRequest.of(page,size,sort);

        return ResponseEntity.ok(service.getUserWithPagination(pageable));
    }
    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<UserDto>> searchEmployee(@PathVariable String keyword){
        List<UserDto> userDtos=service.searchListOfUser(keyword);
        return new ResponseEntity<>(userDtos,HttpStatus.OK);
    }
}
