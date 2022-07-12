package com.pro.wings.service;

import java.util.List;

import com.pro.wings.entity.Student;

public interface StudentService {
	
	public boolean addStudent(Student std);
	public List<Student> getList();

}
