package com.pro.wings.dao;

import java.util.List;

import com.pro.wings.entity.Student;

public interface StudentDao {
	
	public boolean addStudent(Student entity);
	
	public List<Student> getList();
	
}
