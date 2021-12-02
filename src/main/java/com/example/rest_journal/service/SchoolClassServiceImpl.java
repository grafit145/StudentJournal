package com.example.rest_journal.service;
import com.example.rest_journal.model.SchoolClass;
import com.example.rest_journal.model.Student;
import com.example.rest_journal.repository.SchoolClassRepository;
import com.example.rest_journal.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SchoolClassServiceImpl implements SchoolClassService{

    private final SchoolClassRepository schoolClassRepository;
    private final StudentRepository studentRepository;
    public SchoolClassServiceImpl(SchoolClassRepository repository, StudentRepository studentRepository) {
        this.schoolClassRepository = repository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void createSchoolClass(SchoolClass schoolClass) {
        schoolClassRepository.save(schoolClass);
    }

    @Override
    public List<SchoolClass> readAll() {
       return schoolClassRepository.findAll();
    }

    @Override
    public SchoolClass read(int id) {
        return schoolClassRepository.getById(id);
    }

    @Override
    public List<Student> readAllFromClass(String className) {
        return studentRepository.getStudentByClassName(className);
    }

    @Override
    public boolean updateSchoolClass(SchoolClass schoolClass, int id) {
        if(schoolClassRepository.existsById(id)){
            schoolClass.setId(id);
            schoolClassRepository.save(schoolClass);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteSchoolClass(int id) {
        if (schoolClassRepository.existsById(id)){
            schoolClassRepository.deleteById(id);
            return true;
        }
        return false;
    }


}
