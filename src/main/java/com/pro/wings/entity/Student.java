package com.pro.wings.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int rollNum;
	String name;
	int marks;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int rollNum, String name, int marks) {
		super();
		this.rollNum = rollNum;
		this.name = name;
		this.marks = marks;
	}
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", name=" + name + ", marks=" + marks + "]";
	}
	
	

}
