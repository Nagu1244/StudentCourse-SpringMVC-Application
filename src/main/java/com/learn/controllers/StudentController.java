package com.learn.controllers;

import java.util.ArrayList;
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

import com.learn.models.Student;
import com.learn.models.Subjects;
import com.learn.repositories.SubjectRepository;
import com.learn.services.StudentService;
import com.learn.services.SubjectService;

@Controller
@RequestMapping("/students")
public class StudentController {
     
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SubjectRepository subrepo;
	
	/*
	 * List<String> subjects;
	 * 
	 * @ModelAttribute public void preLoad() { subjects = new ArrayList<>();
	 * subjects.add("TELUGU"); subjects.add("HINDI"); subjects.add("ENGLISH");
	 * subjects.add("MATHS"); subjects.add("BIOLOGY"); subjects.add("SOCIAL"); }
	 */

	@GetMapping("/new")
	public String home(Model model, @Valid Student student,Errors errors) {
		
		if(errors.hasErrors())
		{
			return "student/student_newform";
		}
		else
		{
			List<Subjects> listSubjects=subjectService.getAllSubjectDetails();
			model.addAttribute("listSubjects", listSubjects);
			model.addAttribute("student", student);
			return "student/student_newform";
		}
	}
	
	@PostMapping(value="/save")
	public String saveStudentDetails(@ModelAttribute("student") Student student)
	{
		
		studentService.saveStudentDetails(student);
		
		List<Subjects> subject=subrepo.findAll();
		
		for(Subjects subject1:subject)
		{
			subject1.setStudent(student);
			subrepo.save(subject1);
		}
	
		
		return "redirect:/students";
	}
  @GetMapping
  public String getAllStudents(Model model)
  {
	List<Student> listStudents=studentService.getListOfStudents();
	model.addAttribute("listStudents", listStudents);
	return "student/list_students";
  }
	
}
