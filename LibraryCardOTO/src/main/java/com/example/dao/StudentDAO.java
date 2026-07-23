package com.example.dao;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Student;
import com.example.util.HBUtil;

public class StudentDAO {

    public void save(Student student) {

        Session session = HBUtil.getSessionFactory().openSession();

        Transaction tr = session.beginTransaction();

        session.persist(student);

        tr.commit();

        session.close();
    }

    public Student getById(int id) {

        Session session = HBUtil.getSessionFactory().openSession();

        Student student = session.get(Student.class, id);

        session.close();

        return student;
    }

    public void updateExpiryDate(int studentId, LocalDate newDate) {

        Session session = HBUtil.getSessionFactory().openSession();

        Transaction tr = session.beginTransaction();

        Student student = session.get(Student.class, studentId);

        student.getLibraryCard().setExpiryDate(newDate);

        tr.commit();

        session.close();

    }

    public void deleteStudent(int id) {

        Session session = HBUtil.getSessionFactory().openSession();

        Transaction tr = session.beginTransaction();

        Student student = session.get(Student.class, id);

        session.remove(student);

        tr.commit();

        session.close();

    }

}