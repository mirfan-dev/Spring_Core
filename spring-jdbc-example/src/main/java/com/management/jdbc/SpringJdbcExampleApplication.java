package com.management.jdbc;

import com.management.jdbc.dao.CategoryDao;
import com.management.jdbc.dao.CourseDao;
import com.management.jdbc.entity.Category;
import com.management.jdbc.entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class SpringJdbcExampleApplication implements CommandLineRunner {

	@Autowired
	private Category category;

	@Autowired
	private CategoryDao categoryDao;

	@Autowired
	private Course course;

	@Autowired
	private CourseDao courseDao;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// 1. insert category

//		category.setId(103);
//		category.setTitle("live Batches");
//		category.setDescription("Live batches is going on ");
//
//		categoryDao.insert(category);


		// 2. get All Category

//		List<Category> categories=categoryDao.getAllCategory();
//
//		categories.forEach(category1 -> {
//			System.out.println(category1.getId()+" \t "+category1.getTitle()+ "\t" +category1.getDescription());
//		});



		// 3. update Category


//		category.setTitle("Java");
//		category.setDescription("It is platform Independent language");
//
//		categoryDao.update(102,category);


		// 4. get by id

//		Category category1=categoryDao.getById(101);
//		System.out.println(category1.getId()+" \t "+category1.getTitle()+ "\t" +category1.getDescription());

		// delete category

//		categoryDao.delete(103);

		// search category base on title

//		List<Category> categories=categoryDao.search("Java");
//		categories.forEach(category1 -> {
//			System.out.println(category1.getId()+" \t "+category1.getTitle()+ "\t" +category1.getDescription());
//		});

		// count category

//		int count=categoryDao.count();
//		System.out.println("The total no. of rows are "+count);


		// search category based on title and description

//		List<Category> categories=categoryDao.searchByTitleAndDescription("lcwd");
//		categories.forEach(category1 -> {
//			System.out.println(category1.getId()+" \t "+category1.getTitle()+ "\t" +category1.getDescription());
//		});



		// insert course

//		course.setId(101);
//		course.setName("Java Programming");
//		course.setDescription("This course cover core and advance java concepts");
//
//		courseDao.insert(course);


		// get all course

//		List<Course> courses=courseDao.getAllCourse();
//		courses.forEach(course1 -> {
//			System.out.println(course1.getId()+ "\t " +course1.getName()+ "\t "+course1.getDescription());
//		});

		// get by id

//		Course course1=courseDao.getById(101);
//		System.out.println(course1.getId()+ "\t " +course1.getName()+ "\t "+course1.getDescription());

		// update course

//		course.setName("Java Programming");
//		course.setDescription("This course cover core and advance java concepts");
//		courseDao.update(101,course);


		// delete course

//		courseDao.delete(101);


		// search course base on name

//		List<Course> courses=courseDao.search("data");
//		courses.forEach(course1 -> {
//			System.out.println(course1.getId()+ "\t " +course1.getName()+ "\t "+course1.getDescription());
//		});


		// count course

//		int rowCount=courseDao.count();
//		System.out.println("The total no. of rows are: "+rowCount);


		// search based on name and description

		List<Course> courses=courseDao.searchByNameAndDescription("programming");
		courses.forEach(course1 -> {
			System.out.println(course1.getId()+ "\t " +course1.getName()+ "\t "+course1.getDescription());
		});


	}
}
