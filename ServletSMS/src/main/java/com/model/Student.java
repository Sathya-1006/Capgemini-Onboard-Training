package com.model;

import java.time.LocalDate;

public class Student {

    private int studentId;
    private String name;
    private String email;
    private String phone;
    private String course;
    private String address;
    private LocalDate dateOfBirth;

    public Student() {

    }

    public Student(int studentId, String name, String email, String phone,
            String course, String address, LocalDate dateOfBirth) {

        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public Student(String name, String email, String phone,
            String course, String address, LocalDate dateOfBirth) {

        this.name = name;
        this.email = email;
        this.phone = phone;
        this.course = course;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}