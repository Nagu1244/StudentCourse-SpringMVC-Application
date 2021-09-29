package com.learn.services;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.learn.models.Student;
import com.learn.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepo;

	public void saveStudentDetails(Student student) {

		studentRepo.save(student);

	}

	public List<Student> getListOfStudents() {
		
		List<Student> listStudents=studentRepo.findAll();
		return listStudents;
	}

}
