package com.hcmute.service;

import java.util.List;
import java.lang.String;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcmute.dao.StudentDao;
import com.hcmute.model.Student;
import com.hcmute.service.StudentService;
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;

	public List<Student> getAllStudents() {
		List<Student> students = studentDao.getAllStudents();
		return students;
	}

	@Override
	public void insertStudent(Student student) {
		studentDao.insertStudent(student);
	}
	
	@Override
	public Student getStudentById(String id) {
		Student std = studentDao.getStudentById(id);
		return std;
    }
	
	@Override
	public void editStudent(Student student, String id) {
		studentDao.editStudent(student, id);
	}

}