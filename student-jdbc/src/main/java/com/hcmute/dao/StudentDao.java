package com.hcmute.dao;

import java.util.List;
import java.lang.String;

import com.hcmute.model.Student;

public interface StudentDao {
	List<Student> getAllStudents();
	void insertStudent(Student student);
	Student getStudentById(String id);
	void editStudent(Student student, String id);
}