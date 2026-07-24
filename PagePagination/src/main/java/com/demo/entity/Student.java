package com.demo.entity;

import jakarta.persistence.*;

@Entity
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int roll;
	String name;
	String course;
	float marks;
	
	public int getRoll() {
		return roll;
	}
	public void setRoll(int roll) {
		this.roll = roll;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	public Student(String name, String course, float marks) {
		super();		
		this.name = name;
		this.course = course;
		this.marks = marks;
	}
	public Student() {
	}

}
