package com.pro.wings.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pro.wings.entity.Student;
import com.pro.wings.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService stdService;

	@PostMapping("/student")
	public ResponseEntity<?> saveStudent(@RequestBody Student std) {
		boolean stdSaved = stdService.addStudent(std);
		if (stdSaved)
			return ResponseEntity.ok("Student record saved successfully!!");
		else
			return ResponseEntity.ok("Student record not saved!!");
	}
	@GetMapping("/student")
	public ResponseEntity<?> getStudent(){
		//List<Student> list = stdService.getList();
		return new ResponseEntity<>(stdService.getList(),HttpStatus.OK);
		
	
	}
	@GetMapping("/student/{rollNum}")
	public ResponseEntity<?> getStudentById(@PathVariable ("rollNum") int rollNum ){
		return new ResponseEntity<>(stdService.getList(),HttpStatus.OK);
	}

	
	}
