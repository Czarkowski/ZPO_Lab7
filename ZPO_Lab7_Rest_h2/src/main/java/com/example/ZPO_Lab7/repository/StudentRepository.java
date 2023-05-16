package com.example.ZPO_Lab7.repository;


import com.example.ZPO_Lab7.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByOrderByLastNameDesc();
}

