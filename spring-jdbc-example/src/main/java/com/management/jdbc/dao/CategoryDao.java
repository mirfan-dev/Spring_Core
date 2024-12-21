package com.management.jdbc.dao;

import com.management.jdbc.entity.Category;
import com.management.jdbc.util.CategoryRowMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Create Table

    @PostConstruct
    public void init(){
        String createTable="create table if not EXISTS category(id int primary key,title varchar(100) not null,description varchar(500))";
        jdbcTemplate.update(createTable);
        System.out.println("Table is created");
    }

    //save category
    public Category save(Category category) {
        //parameterized query
        String query = "insert into category (id,title,description) values (?,?,?)";
        int rows = jdbcTemplate.update(query, category.getId(), category.getTitle(), category.getDescription());
        System.out.println(rows + " row effected");
        return category;
    }


    //update category
    public Category update(int categoryId, Category newCat) {
        String query = "update category set title= ? , description=? WHERE id = ?";
        int update = jdbcTemplate.update(query, newCat.getTitle(), newCat.getDescription(), categoryId);
        System.out.println("updated " + update);
        newCat.setId(categoryId);
        return newCat;
    }


    // get all category

    public List<Category> getAll() {
        String query = "select * from category";

        List<Category> categories = jdbcTemplate.query(query, new CategoryRowMapper());
        return categories;
    }


    // get single category by id


    public Category get(int categoryId) {
        String query = "select * from category where id = ?";
//        return jdbcTemplate.queryForObject(query, Category.class, categoryId);
        return jdbcTemplate.queryForObject(query, new CategoryRowMapper(), categoryId);
    }


    // delete category

    public void delete(int categoryId) {
        String query = "delete from category where id =?";
        jdbcTemplate.update(query, categoryId);
    }
}
