package com.example.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/home")
    public String home() {
        return "Welcome to Employee Management System";
    }

    @GetMapping("/employees")
    public String employees() {
        return "Employee List";
    }

    @GetMapping("/employee/profile")
    public String employeeProfile() {
        return "Employee Profile";
    }

    @GetMapping("/manager/reports")
    public String managerReports() {
        return "Manager Reports";
    }

    @GetMapping("/admin/users")
    public String adminUsers() {
        return "Admin User Management";
    }

    @GetMapping("/admin/delete-user")
    public String deleteUser() {
        return "Admin Delete User";
    }
}