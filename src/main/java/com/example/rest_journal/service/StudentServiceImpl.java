package com.example.rest_journal.service;

import com.example.rest_journal.model.Student;
import com.example.rest_journal.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void createStudent(Student student){
        studentRepository.save(student);
    }

    @Override
    public List<Student> readAll(){
        return studentRepository.findAll();
    }


    @Override
    public Student read(int id){
        return studentRepository.getById(id);
    }

    @Override
    public boolean updateStudent(Student student, int id){
        if(studentRepository.existsById(id)){
            student.setId(id);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteStudent(int id) {
        if(studentRepository.existsById(id)){
            studentRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
