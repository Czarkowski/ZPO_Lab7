package com.example.ZPO_Lab7.service;

import com.example.ZPO_Lab7.repository.StudentRepository;
import com.example.ZPO_Lab7.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findByOrderByLastNameDesc();
    }

    public Student getById(Long id){
        Optional<Student> byId = studentRepository.findById(id);
        return byId.orElse(null);

    }

    public Student delete(Long id){
        Student student = this.getById(id);
        if (student != null) {
            studentRepository.deleteById(id);
            return student;
        }
        return null;
    }
    public Student updateStudent(Long id, Student newStudent){
        Student oldStudent = this.getById(id);
        if (oldStudent == null)
            return null;

        if (newStudent.getFirstName() != null) oldStudent.setFirstName(newStudent.getFirstName());
        if (newStudent.getLastName() != null) oldStudent.setLastName(newStudent.getLastName());
        if (newStudent.getAge() > 0) oldStudent.setAge(newStudent.getAge());
        studentRepository.save(oldStudent);
        return oldStudent;
    }

}
