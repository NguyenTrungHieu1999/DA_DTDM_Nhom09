package com.hcmute.dao;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import com.hcmute.model.Student;

public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

    	Student std = new Student();
    	std.setId(rs.getString("id"));
    	std.setFullName(rs.getString("fullName"));
    	std.setGender(rs.getString("gender"));
    	std.setBirthdate(rs.getString("birthdate"));
    	std.setAddress(rs.getString("address"));    	
    	std.setPhone(rs.getString("phone"));
    	std.setIsDelete(rs.getBoolean("isDelete"));
    	
        return std;
    }
}