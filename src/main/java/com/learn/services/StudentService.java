package com.learn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.models.Student;
import com.learn.repositories.StudentRepository;

@Service
public class StudentService {
@Autowired
	private StudentRepository studentRepo;
 
    public void saveStudentDetails(Student student)
    {
    	 studentRepo.save(student);
    	
    }
    
}
