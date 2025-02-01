package com.jpa.controller;


import com.jpa.dto.JwtResponse;
import com.jpa.dto.LoginRequest;
import com.jpa.dto.RefreshTokenRequest;
import com.jpa.dto.UserDto;
import com.jpa.repository.UserRepository;
import com.jpa.security.JwtService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
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
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(loginRequest.email(), loginRequest.password());
        //authenticating
        authenticationManager.authenticate(authentication);


        //getting userdetail
        UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.email());

        UserDto userDto =modelMapper.map( userRepo.findByEmail(userDetails.getUsername()).get(),UserDto.class);

        String jwtToken = jwtService.generateToken(userDto.getEmail(),true);
        String refreshToken = jwtService.generateToken(userDto.getEmail(),false);
        //

        JwtResponse build = JwtResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .user(userDto).build();
        return ResponseEntity.ok(build);

    }

    @PostMapping("/refresh-token")

    public ResponseEntity<?> refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){



        if(jwtService.validateToken(refreshTokenRequest.getRefreshToken()) && jwtService.isRefreshToken(refreshTokenRequest.getRefreshToken())){

            String usernameFromRefreshToken=jwtService.getUsername(refreshTokenRequest.getRefreshToken());

            UserDto userDto=modelMapper.map(userRepo.findByEmail(usernameFromRefreshToken).get(),UserDto.class);

            String accessToken= jwtService.generateToken(userDto.getEmail(),true);
            String refreshToken= jwtService.generateToken(userDto.getEmail(), false);

            JwtResponse build = JwtResponse.builder()
                    .accessToken(accessToken)
                    .refreshToken(refreshToken)
                    .user(userDto).build();
            return ResponseEntity.ok(build);

        }else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Refresh Token");
        }


    }

}