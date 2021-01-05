package com.hcmute.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hcmute.model.Student;
import com.hcmute.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService stdService;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> getStudents() {

		return stdService.getAllStudents();

	}

	@RequestMapping(value = "/insertstudent", method = RequestMethod.POST)
	public void insertStudent(@RequestBody Student student) {
		stdService.insertStudent(student);
	}
	
	@RequestMapping(value="/students/{id}", method = RequestMethod.GET)
	public Student getStudentById(@PathVariable("id") String id){
		return stdService.getStudentById(id);
	}
	
	@RequestMapping(value="/students/{id}", method = RequestMethod.PUT)
	public void editStudent(@PathVariable("id") String id, @RequestBody Student student){
		stdService.editStudent(student, id);
	}
}