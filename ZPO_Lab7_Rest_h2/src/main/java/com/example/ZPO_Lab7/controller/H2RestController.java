package com.example.ZPO_Lab7.controller;


import com.example.ZPO_Lab7.entity.Student;
import com.example.ZPO_Lab7.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class H2RestController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public List<Student> get(Model model) {
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    public Student getById(Model model, @PathVariable("id") String id) {
        Student student = studentService.getById(Long.parseLong(id));

        if (student != null) {
            return student;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id = " + id + " not found");
        }
    }

    //@RequestParam("firstName") String firstName,@RequestParam("lastName") String lastName,@RequestParam("int") String age
    @PostMapping("/students")
    public Student post(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @PutMapping("/students/{id}")
    public Student put(@PathVariable("id") String id, @RequestBody Student student) {
        Student updateStudent = studentService.updateStudent(Long.parseLong(id), student);
        if (updateStudent != null)
            return updateStudent;
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id = " + id + " not exist");
    }

    @DeleteMapping("/students/{id}")
    public Student delete(@PathVariable("id") String id) {
        Student deleteStudent = studentService.delete(Long.parseLong(id));
        if (deleteStudent != null)
            return deleteStudent;
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student with id = " + id + " not exist");
    }


}
