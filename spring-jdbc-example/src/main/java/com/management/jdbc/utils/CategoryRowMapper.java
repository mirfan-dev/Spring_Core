package com.management.jdbc.utils;

import com.management.jdbc.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class CategoryRowMapper implements RowMapper<Category> {




    @Override
    public Category mapRow(ResultSet rs, int rowNum) throws SQLException {

        Category category=new Category();
        // table se data nakalna hai aur category mein set karna hai.
        category.setId(rs.getInt("id"));
        category.setTitle(rs.getString("title"));
        category.setDescription(rs.getString("description"));

        return category;
    }


}
