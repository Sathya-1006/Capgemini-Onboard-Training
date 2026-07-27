package org.examples;

import jakarta.persistence.*;

@Entity
@Table(name = "studentdetails")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int id;
	private String name;
	private String city;
	private float marks;
	
	public Student(String name, String city, float marks) {
		this.name = name;
		this.city = city;
		this.marks = marks;
	}
	public Student() {
	}
	
	
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", city=" + city + ", marks=" + marks + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public float getMarks() {
		return marks;
	}
	public void setMarks(float marks) {
		this.marks = marks;
	}
	
	

}
