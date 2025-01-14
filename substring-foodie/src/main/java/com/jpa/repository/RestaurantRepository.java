package com.jpa.repository;

import com.jpa.entity.Restaurant;
import com.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RestaurantRepository extends JpaRepository<Restaurant,String> {


    @Query("SELECT u FROM Restaurant u WHERE " +
            "LOWER(u.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR " +
            "LOWER(u.address) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    public List<Restaurant> searchUser(String keyword);
}
