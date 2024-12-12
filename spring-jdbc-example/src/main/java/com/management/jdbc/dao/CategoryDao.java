package com.management.jdbc.dao;

import ch.qos.logback.core.testUtil.CoreTestConstants;
import com.management.jdbc.entity.Category;
import com.management.jdbc.entity.Course;
import com.management.jdbc.utils.CategoryRowMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // create table of category

    @PostConstruct
    public void init(){
        String createTableQuery="create table if not EXISTS category(id int primary key, title varchar(100) not null, description varchar (500) not null )";

        int rows=jdbcTemplate.update(createTableQuery);
        System.out.println("Category Table created");
    }

    // insert Category

    public Category insert(Category category){

        String insertQuery= "insert into category(id,title,description) value(?,?,?)";
;        int rows=jdbcTemplate.update(insertQuery,category.getId(),category.getDescription(),category.getTitle());
        System.out.println(rows +" row effected");
        return category;

    }

    // get all category

    public List<Category> getAllCategory(){
        String selectQuery="select * from category";
        List<Category> categories=jdbcTemplate.query(selectQuery,new CategoryRowMapper());
        return categories;
    }

    // update Category

    public Category update(int categoryId, Category newCat){

        String updateQuery="update category set title=?, description=? where id=?";
        int row=jdbcTemplate.update(updateQuery,newCat.getTitle(),newCat.getDescription(),categoryId);
        System.out.println(row+ " row updated");
        newCat.setId(categoryId);
        return newCat;
    }

    // get by id

    public Category getById(int categoryId){
        String selectQuery="select * from category where id=?";
        return jdbcTemplate.queryForObject(selectQuery,new CategoryRowMapper(),categoryId);
    }

    // delete category

    public void delete(int categoryId){
        String deleteQuery="delete from category where id=?";
        jdbcTemplate.update(deleteQuery,categoryId);
        System.out.println("1 row deleted");
    }

    // search category base on title

    public List<Category> search(String title){
        String searchQuery="select * from category where title like ?";
        List<Category> categories=jdbcTemplate.query(searchQuery,new Object[]{"%" +title+ "%"},new CategoryRowMapper() );
        return categories;
    }

    // count category

    public int count(){
        String countQuery ="select count(*) from category";
        Integer rowCount=jdbcTemplate.queryForObject(countQuery,Integer.class);
        return rowCount != null ? rowCount :0;
    }


    // search category based on title and description

    public List<Category> searchByTitleAndDescription(String key){

        String searchQuery="select * from category where title like ? or description like ?";

        List<Category> categories=jdbcTemplate.query(searchQuery,new Object[]{"%" +key+ "%", "%"  +key+ "%"},new CategoryRowMapper());
        return categories;
    }



}
