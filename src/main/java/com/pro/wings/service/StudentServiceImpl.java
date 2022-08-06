package com.pro.wings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.wings.dao.StudentDao;
import com.pro.wings.entity.Student;


@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	StudentDao stdDao;

	@Override
	public boolean addStudent(Student std) {
		
		return  stdDao.addStudent(std);
	}

	@Override
	public List<Student> getList() {
		
		return stdDao.getList();
	}

	@Override
	public Student getStudentRollNum(int rollNum) {
		
		return stdDao.getStudentRollNum(rollNum);
	}

	@Override
	public boolean updateStudent(int rollNum, Student std) {
		
		return stdDao.updateStudent(rollNum, std);
	}

	@Override
	public boolean deleteStudent(int rollNum) {
		
		return stdDao.deleteStudent(rollNum);
	}

}
