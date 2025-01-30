package com.jpa.controller;


import com.jpa.dto.JwtResponse;
import com.jpa.dto.LoginRequest;
import com.jpa.dto.UserDto;
import com.jpa.repository.UserRepository;
import com.jpa.security.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {


    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtService jwtService;

    private UserRepository userRepo;

    private ModelMapper modelMapper;

    public AuthController(AuthenticationManager authenticationManager, UserDetailsService userDetailsService, JwtService jwtService, UserRepository userRepo, ModelMapper modelMapper) {
        this.authenticationManager = authenticationManager;
        this.userDetailsService = userDetailsService;
        this.jwtService = jwtService;
        this.userRepo = userRepo;
        this.modelMapper = modelMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {


        //created authentication
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword());
        //authenticating
        authenticationManager.authenticate(authentication);

        //getting token
        String jwtToken = jwtService.generateToken(loginRequest.getEmail());
        //getting userdetail
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getEmail());

        UserDto userDto =modelMapper.map( userRepo.findByEmail(userDetails.getUsername()).get(),UserDto.class);

        JwtResponse build = JwtResponse.builder().token(jwtToken).user(userDto).build();
        return ResponseEntity.ok(build);

    }

}