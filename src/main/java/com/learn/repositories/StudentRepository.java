package com.learn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
