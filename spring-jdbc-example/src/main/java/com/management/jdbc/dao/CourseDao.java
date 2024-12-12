package com.management.jdbc.dao;

import com.management.jdbc.entity.Category;
import com.management.jdbc.entity.Course;
import com.management.jdbc.utils.CourseRowMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    // create table

    @PostConstruct
    public void init(){

        String createTableQuery="create table if not EXISTS course(id int primary key, name varchar(100) not null, description varchar (500) not null)";
        jdbcTemplate.update(createTableQuery);
        System.out.println("course Table created");
    }

    // insert course

    public Course insert(Course course){

        String insertQuery="insert into course(id,name,description) value(?,?,?)";
        int row=jdbcTemplate.update(insertQuery,course.getId(),course.getName(),course.getDescription());
        System.out.println(row+" row effected");
        return course;

    }

    // get all course

    public List<Course> getAllCourse(){

        String getAllQuery="select * from course";
        List<Course> courses=jdbcTemplate.query(getAllQuery,new CourseRowMapper());
        return courses;
    }

    // get by id

    public Course getById(int courseId){
        String getByIdQuery="select * from course where id=?";
        Course course=jdbcTemplate.queryForObject(getByIdQuery,new CourseRowMapper(),courseId);
        return course;
    }

    // update course

    public Course update(int courseId, Course newCourse){

        String updateQuery="update course set name=?, description=? where id=?";
        int row =jdbcTemplate.update(updateQuery,newCourse.getName(),newCourse.getDescription(),courseId);
        System.out.println(row+" row updated");
        newCourse.setId(courseId);
        return newCourse;

    }

    // delete course

    public void delete(int courseId){
        String deleteQuery="delete from course where id=?";
        jdbcTemplate.update(deleteQuery,courseId);
        System.out.println("1 row deleted");
    }

    // search course base on name

    public List<Course> search(String name){

        String searchQuery="select * from course where name like ?";
        List<Course> courses=jdbcTemplate.query(searchQuery,new Object[]{"%" +name+ "%"},new CourseRowMapper());
        return courses;

    }

    // count course

    public int count(){

        String countQuery="select count(*) from course";
        Integer rowCount=jdbcTemplate.queryForObject(countQuery,Integer.class);
        return rowCount !=null ? rowCount :0;
    }


}
