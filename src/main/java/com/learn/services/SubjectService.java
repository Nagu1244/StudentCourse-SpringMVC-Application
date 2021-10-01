package com.learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learn.models.Subjects;
import com.learn.repositories.SubjectRepository;
@Service
public class SubjectService {
    
	@Autowired
	private SubjectRepository subrepo;
	public void saveStudentSubjects(Subjects subject) {
		
		subrepo.save(subject);
		
	}
	public List<Subjects> getAllSubjectDetails() {
		
		return subrepo.findAll();
		
	}

	
}
