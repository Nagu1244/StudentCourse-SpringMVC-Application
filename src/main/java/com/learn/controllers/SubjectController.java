package com.learn.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.models.Subjects;
import com.learn.services.SubjectService;

@Controller
@RequestMapping("/subjects")
public class SubjectController {
      
	@Autowired
	private SubjectService subjectService;
	
	@GetMapping("/new")
	public String getSubjectForm(Subjects subject,Model model)
	{
		
		model.addAttribute("subject", subject );
		return "subject/subject-form";
		}
	
	@PostMapping("/save")
	public String saveStudentSubject(@ModelAttribute("subject") Subjects subject)
	{
		subjectService.saveStudentSubjects(subject);
		
		return "redirect:/subjects/new";
	}
	
	
	@GetMapping
	public List<Subjects> getAllSubject()
	{
		 List<Subjects> listSubjects=subjectService.getAllSubjectDetails();
		 return listSubjects;
	}
	
	
}
