package com.hcmute.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.lang.String;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.hcmute.dao.StudentDao;
import com.hcmute.model.Student;


@Repository
public class StudentDaoImpl extends JdbcDaoSupport implements StudentDao {

	@Autowired
	DataSource dataSource;

	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public List<Student> getAllStudents() {
		String sql = "SELECT * FROM student";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		List<Student> result = new ArrayList<Student>();
		for (Map<String, Object> row : rows) {
			Student std = new Student();
			std.setId((String) row.get("Id"));
			std.setFullName((String) row.get("FullName"));
			std.setGender((String) row.get("Gender"));
			std.setBirthdate((String) row.get("Birthdate"));
			std.setAddress((String) row.get("Address"));
			std.setPhone((String) row.get("Phone"));
			std.setIsDelete((Boolean) row.get("IsDelete"));
			result.add(std);
		}

		return result;
	}

	@Override
	public void insertStudent(Student student) {
		String sql = "INSERT INTO student " + "(Id, FullName, Gender, Birthdate, Address, Phone, IsDelete) VALUES (?, ?, ?, ?, ?, ?, ?)";
		getJdbcTemplate().update(sql, new Object[] { student.getId(), student.getFullName(), student.getGender(), student.getBirthdate(), student.getAddress(), student.getPhone(), student.getIsDelete() });

	}
	
	@Override
	public Student getStudentById(String id) {
		String sql = "SELECT * FROM student WHERE Id = ?";		

        return getJdbcTemplate().queryForObject(sql, new Object[]{id}, new StudentRowMapper());
	}
	
	@Override
	public void editStudent(Student student, String id) {
		String sqlFullName = "UPDATE student SET FullName = IF (? IS NOT NULL, ?, FullName) WHERE  Id = ?";
		getJdbcTemplate().update(sqlFullName, new Object[] { student.getFullName(), student.getFullName(), id });
		
		String sqlGender = "UPDATE student SET Gender = IF (? IS NOT NULL, ?, Gender) WHERE  Id = ?";
		getJdbcTemplate().update(sqlGender, new Object[] { student.getGender(), student.getGender(), id });
		
		String sqlBirthday = "UPDATE student SET Birthdate = IF (? IS NOT NULL, ?, Birthdate) WHERE  Id = ?";
		getJdbcTemplate().update(sqlBirthday, new Object[] { student.getBirthdate(), student.getBirthdate(), id });
		
		String sqlAddress = "UPDATE student SET Address = IF (? IS NOT NULL, ?, Address) WHERE  Id = ?";
		getJdbcTemplate().update(sqlAddress, new Object[] { student.getAddress(), student.getAddress(), id });
		
		String sqlPhone = "UPDATE student SET Phone = IF (? IS NOT NULL, ?, Phone) WHERE  Id = ?";
		getJdbcTemplate().update(sqlPhone, new Object[] { student.getPhone(), student.getPhone(), id });
		
		String sqlIsDelete = "UPDATE student SET IsDelete = IF (? IS NOT NULL, ?, IsDelete) WHERE  Id = ?";
		getJdbcTemplate().update(sqlIsDelete, new Object[] { student.getIsDelete(), student.getIsDelete(), id });
	}
}