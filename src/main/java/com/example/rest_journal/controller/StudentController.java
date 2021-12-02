package com.example.rest_journal.controller;

import com.example.rest_journal.model.Student;
import com.example.rest_journal.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Добавить нового ученика
    @PostMapping(value = "/students")
    public ResponseEntity<?> create(@RequestBody Student student){
        studentService.createStudent(student);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Получить список всех учеников
    @GetMapping(value= "/students")
    public ResponseEntity<List<Student>> read(){
        final List<Student> students = studentService.readAll();

        return students != null && !students.isEmpty() ?
                new ResponseEntity<>(students,HttpStatus.OK)
                :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    // Найти студента по его ID
    @GetMapping(value = "/students/{id}")
    public ResponseEntity<Student> read(@PathVariable(name = "id") int id){
        final Student student = studentService.read(id);

        return student != null ?
                new ResponseEntity<>(student, HttpStatus.OK)
                :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Изменить данные ученика
    @PutMapping(value= "/students/{id}")
    public ResponseEntity<?> update(@PathVariable(name= "id") int id, @RequestBody Student student){
        final boolean isUpdated = studentService.updateStudent(student,id);
        return isUpdated ?
                new ResponseEntity<>(HttpStatus.OK)
                :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    // Удаление данных об ученике
    @DeleteMapping(value = "/students/{id}")
    public ResponseEntity<?> delete(@PathVariable(name= "id")int id){
        final boolean isDeleted = studentService.deleteStudent(id);
        return isDeleted ?
                new ResponseEntity<>(HttpStatus.OK)
                :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
