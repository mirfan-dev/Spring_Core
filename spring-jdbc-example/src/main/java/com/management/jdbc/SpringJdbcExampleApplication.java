package com.management.jdbc;

import com.management.jdbc.dao.CategoryDao;
import com.management.jdbc.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJdbcExampleApplication implements CommandLineRunner {

	@Autowired
	private CategoryDao catDao;

	public static void main(String[] args) {

		SpringApplication.run(SpringJdbcExampleApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


		// save

		Category category = new Category();
		category.setId(103);
		category.setTitle("Clothing");
		category.setDescription("Apparel and garments for men, women, and children.");
		catDao.save(category);

	}
}
