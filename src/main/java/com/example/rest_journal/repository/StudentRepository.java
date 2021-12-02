package com.example.rest_journal.repository;

import com.example.rest_journal.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    @Query(value = "select * from students where class_name = ?1", nativeQuery = true)
    public List<Student> getStudentByClassName(String className);

}
