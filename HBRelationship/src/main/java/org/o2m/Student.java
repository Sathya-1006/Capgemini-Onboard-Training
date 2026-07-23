package org.o2m;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name="studento2m")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roll;
	private String name;
	private int age;
	@ManyToOne
	@JoinColumn(name="dept_id")
	private Department department;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


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

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
}

@Entity
@Table(name = "department")
class Department{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int deptId;
	private String dname;
	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL,
			fetch = FetchType.LAZY)
	//mappedby - used to specify relationship 
	//cascade  - changes made in parent table will reflect in child table
	//fetch    - how to fetch data (lazy -  retrieves parent data only -> we have to manually retrieve child data, eager -  both parent and child data can be reteived)
	private List<Student> students = new ArrayList<Student>();//one dept can have many student -> one to many
	public Department() {
		// TODO Auto-generated constructor stub
	}
	public Department(String dname) {
		super();
		this.dname = dname;
	}
	public int getDeptId() {
		return deptId;
	}
	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	// utility method -  adds student
	public void addStudent(Student student) {
		students.add(student);
		student.setDepartment(this);
	}
}
