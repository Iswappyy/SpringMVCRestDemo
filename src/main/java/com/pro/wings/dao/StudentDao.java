package com.pro.wings.dao;

import java.util.List;

import com.pro.wings.entity.Student;

public interface StudentDao {

	public boolean addStudent(Student entity);

	public List<Student> getList();

	public Student getStudentRollNum(int rollNum);

	public boolean updateStudent(int rollNum, Student std);

	public boolean deleteStudent(int rollNum);

}
