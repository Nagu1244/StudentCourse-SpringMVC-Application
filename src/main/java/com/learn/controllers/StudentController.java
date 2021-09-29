package com.learn.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learn.models.Student;
import com.learn.services.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
     
	@Autowired
	private StudentService studentService;
	List<String> courses;

	@ModelAttribute
	public void preLoad() {
		courses = new ArrayList<>();
		courses.add("CORE JAVA");
		courses.add("SPRING CORE");
		courses.add("SPRING MVC");
		courses.add("ANGULAR");
		courses.add("NODE JS");
	}

	@GetMapping("/new")
	public String home(Model model, @Valid Student student,BindingResult result) {
		model.addAttribute("courses", courses);
		model.addAttribute("student", student);
		if(result.hasErrors())
		{
			return "student_newform";
		}
		return "student_newform";
	}
	
	@PostMapping(value="/save")
	public String saveStudentDetails(@ModelAttribute("student") Student student)
	{
		
		studentService.saveStudentDetails(student);
		
		return "redirect:/students";
	}
  @GetMapping
  public String getAllStudents(Model model)
  {
	List<Student> listStudents=studentService.getListOfStudents();
	model.addAttribute("listStudents", listStudents);
	return "list_students";
  }
	
}
