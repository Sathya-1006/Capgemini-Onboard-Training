package org.examples;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "student_mtm")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int sid;
	private String name;
	@ManyToMany(
			cascade = CascadeType.ALL)
	@JoinTable(name = "Student_Course",
	joinColumns = @JoinColumn(name = "student_id"), //col name to be present in 3rd table
	inverseJoinColumns = @JoinColumn(name= "course_id"))

	private List<Course> courses = new ArrayList<>(); // many student can register to many courses
	public Student(String name) {
		super();
		
		this.name = name;
		
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	public Student() {
	}
	
	public void addCourse(Course c) {
		courses.add(c);
		c.getStudents().add(this);
	}
	
	
}

@Entity
@Table(name = "course_mtm")
class Course{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int courseId;
	private String courseName;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students = new ArrayList<>();

	public Course() {
	}

	public Course(String courseName) {
		super();
		
		this.courseName = courseName;
		
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	
	
	
	
}