package com.jpa.service;

import com.jpa.entity.User; // Make sure the User entity is imported correctly
import com.jpa.exception.ResourceNotFoundException;
import com.jpa.repository.UserRepository;
import com.jpa.security.CustomUserDetail;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username)
                .orElseThrow(() -> new ResourceNotFoundException("User Not found"));

        CustomUserDetail customUserDetail = new CustomUserDetail(user);
        return customUserDetail;
    }
}
