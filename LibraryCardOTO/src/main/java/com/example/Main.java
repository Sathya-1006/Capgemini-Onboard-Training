package com.example;

import java.time.LocalDate;

import com.example.dao.StudentDAO;
import com.example.entity.LibraryCard;
import com.example.entity.Student;

public class Main {

    public static void main(String[] args) {

        StudentDAO dao = new StudentDAO();

        // SAVE

        LibraryCard card = new LibraryCard(
                LocalDate.now(),
                LocalDate.now().plusYears(3));

        Student student = new Student(
                "Rahul",
                "rahul@gmail.com",
                LocalDate.of(2003, 5, 10),
                card);

        dao.save(student);

        // GET BY ID

        Student s = dao.getById(1);

        System.out.println("Student Name : " + s.getName());
        System.out.println("Card ID : " + s.getLibraryCard().getCardId());

        // UPDATE EXPIRY DATE

        dao.updateExpiryDate(1,
                LocalDate.now().plusYears(5));

        // DELETE STUDENT

        // dao.deleteStudent(1);

    }

}