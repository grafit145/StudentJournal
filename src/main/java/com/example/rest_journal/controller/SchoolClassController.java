package com.example.rest_journal.controller;

import com.example.rest_journal.model.SchoolClass;
import com.example.rest_journal.service.SchoolClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SchoolClassController {
    private final SchoolClassService schoolClassService;

    @Autowired
    public SchoolClassController(SchoolClassService schoolClassService) {
        this.schoolClassService = schoolClassService;
    }

    @PostMapping(value = "/classes")
    public ResponseEntity<?> create(@RequestBody SchoolClass schoolClass){
        schoolClassService.createSchoolClass(schoolClass);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/classes")
    public ResponseEntity<List<SchoolClass>> read(){
       final List<SchoolClass> classes = schoolClassService.readAll();
       return classes != null && !classes.isEmpty() ?
               new ResponseEntity<>(classes, HttpStatus.OK)
               :
               new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/classes/{id}")
    public ResponseEntity<SchoolClass> read(@PathVariable(name = "id") int id){
        final SchoolClass schoolClass = schoolClassService.read(id);
        return schoolClass != null ?
                new ResponseEntity<>(schoolClass, HttpStatus.OK)
                :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/classes/{id}")
    public ResponseEntity<?> update(@PathVariable(name = "id") int id, @RequestBody SchoolClass schoolClass){
        final boolean isUpdated = schoolClassService.updateSchoolClass(schoolClass, id);
        return isUpdated ?
                new ResponseEntity<>(HttpStatus.OK)
                :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @DeleteMapping(value = "/classes/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") int id){
        final boolean isDeleted = schoolClassService.deleteSchoolClass(id);
        return isDeleted ?
                new ResponseEntity<>(HttpStatus.OK)
                :
                new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }
}
