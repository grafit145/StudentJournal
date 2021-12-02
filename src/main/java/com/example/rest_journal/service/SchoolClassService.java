package com.example.rest_journal.service;

import com.example.rest_journal.model.SchoolClass;
import com.example.rest_journal.model.Student;

import java.util.List;

public interface SchoolClassService {
    void createSchoolClass(SchoolClass schoolClass);

    List<SchoolClass> readAll();

    SchoolClass read(int id);

    boolean updateSchoolClass(SchoolClass schoolClass, int id);

    boolean deleteSchoolClass(int id);

    List<Student> readAllFromClass(String className);
}
