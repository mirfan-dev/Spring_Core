package com.jpa.mapper;

import com.jpa.dto.UserDto;
import com.jpa.entity.User;

public class UserMapper {


    public static UserDto mapUserToUserDto(User user) {
        return new UserDto(
                user.getId(),         // Ensure User has a String id
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getRole()


        );
    }

    public static User mapUserDtoToUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getEmail(),
                userDto.getPassword(),
                userDto.getAddress(),
                userDto.getPhoneNumber(),
                userDto.getRole()


        );
    }
}
