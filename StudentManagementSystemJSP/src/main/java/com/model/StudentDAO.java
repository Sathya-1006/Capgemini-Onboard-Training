package com.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    // Add Student
    public int addStudent(Student s) {

        int row = 0;

        try {

            con = DBConnection.getConnection();

            String sql = "insert into student(name,email,phone,course,address,date_of_birth) values(?,?,?,?,?,?)";

            ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhone());
            ps.setString(4, s.getCourse());
            ps.setString(5, s.getAddress());
            ps.setDate(6, Date.valueOf(s.getDateOfBirth()));

            row = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    // View Students
    public List<Student> getAllStudents() {

        List<Student> list = new ArrayList<>();

        try {

            con = DBConnection.getConnection();

            ps = con.prepareStatement("select * from student");

            rs = ps.executeQuery();

            while (rs.next()) {

                Student s = new Student();

                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setCourse(rs.getString("course"));
                s.setAddress(rs.getString("address"));
                s.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());

                list.add(s);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

 // Get Student By ID
    public Student getStudentById(int id) {

        Student s = null;

        try {

            con = DBConnection.getConnection();

            ps = con.prepareStatement("select * from student where student_id=?");

            ps.setInt(1, id);

            rs = ps.executeQuery();

            if(rs.next()) {

                s = new Student();

                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setCourse(rs.getString("course"));
                s.setAddress(rs.getString("address"));
                s.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());

            }

        } catch(Exception e) {
            e.printStackTrace();
        }

        return s;
    }
    // Update Student
    public int updateStudent(Student s) {

        int row = 0;

        try {

            con = DBConnection.getConnection();

            String sql = "update student set name=?,email=?,phone=?,course=?,address=?,date_of_birth=? where student_id=?";

            ps = con.prepareStatement(sql);

            ps.setString(1, s.getName());
            ps.setString(2, s.getEmail());
            ps.setString(3, s.getPhone());
            ps.setString(4, s.getCourse());
            ps.setString(5, s.getAddress());
            ps.setDate(6, Date.valueOf(s.getDateOfBirth()));
            ps.setInt(7, s.getStudentId());

            row = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    // Delete Student
    public int deleteStudent(int id) {

        int row = 0;

        try {

            con = DBConnection.getConnection();

            ps = con.prepareStatement("delete from student where student_id=?");

            ps.setInt(1, id);

            row = ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return row;
    }

    // Search Student
    public List<Student> searchStudent(String name) {

        List<Student> list = new ArrayList<>();

        try {

            con = DBConnection.getConnection();

            ps = con.prepareStatement("select * from student where name like ?");

            ps.setString(1, "%" + name + "%");

            rs = ps.executeQuery();

            while (rs.next()) {

                Student s = new Student();

                s.setStudentId(rs.getInt("student_id"));
                s.setName(rs.getString("name"));
                s.setEmail(rs.getString("email"));
                s.setPhone(rs.getString("phone"));
                s.setCourse(rs.getString("course"));
                s.setAddress(rs.getString("address"));
                s.setDateOfBirth(rs.getDate("date_of_birth").toLocalDate());

                list.add(s);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

}