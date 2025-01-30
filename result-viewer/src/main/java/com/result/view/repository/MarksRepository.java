package com.result.view.repository;

import com.result.view.entity.Mark;
import com.result.view.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MarksRepository extends JpaRepository<Mark,Integer> {

    List<Mark> findByStudent(Student student);
}
