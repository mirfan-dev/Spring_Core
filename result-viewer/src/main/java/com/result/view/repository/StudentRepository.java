package com.result.view.repository;

import com.result.view.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student,String> {

    //important
    Optional<Student> findByRollNumber(String rollNumber);

    Optional<Student> findByRollNumberAndDateOfBirth(String rollNumber, LocalDate dateOfBirth);
}
