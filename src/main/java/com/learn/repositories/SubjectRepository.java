package com.learn.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.models.Subjects;

public interface SubjectRepository extends JpaRepository<Subjects, Long> {

	
}
