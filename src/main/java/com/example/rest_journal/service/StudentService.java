package com.example.rest_journal.service;

import com.example.rest_journal.model.Student;

import java.util.List;

public interface StudentService {
    void createStudent(Student student);

    List<Student> readAll();

    Student read(int id);

    boolean updateStudent(Student student, int id);

    boolean deleteStudent(int id);

}
