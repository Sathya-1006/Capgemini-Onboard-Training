# Employee Management System

This project was created to understand how an employee management system works in a real-world scenario and to apply Core Java concepts in a practical way. The main objective is to manage employee records through a simple console application, where users can add, display, search, update, and remove employees, along with calculating salary details and viewing department-wise employee counts.

## Features

- Add new employees
- Display all employees
- Search employee by ID
- Update employee name
- Remove employee by ID
- Calculate total salary expense
- Find the highest-paid employee
- Display department-wise employee count

## Employee Types

The system supports three types of employees:

### Full-Time Employee

- Receives a fixed monthly salary

### Part-Time Employee

- Salary is calculated based on hours worked and hourly rate

### Contract Employee

- Receives a fixed contract amount

## Technologies Used

- Java
- Eclipse IDE
- Collections Framework (ArrayList, HashMap)
- Object-Oriented Programming

## Project Structure

```text
src
│
├── main
│   └── EmployeeMgtApp.java
│
├── com.ems.model
│   ├── Employee.java
│   ├── FullTimeEmployee.java
│   ├── PartTimeEmployee.java
│   ├── ContractEmployee.java
│   ├── Address.java
│   └── Department.java
│
└── com.ems.service
    └── EmployeeService.java
```

## Concepts Demonstrated

### Inheritance

Different employee types inherit from the base Employee class.

### Abstraction

Common employee behavior is defined in the abstract Employee class.

### Polymorphism

Salary calculation is implemented differently for each employee type using method overriding.

### Encapsulation

Employee data is protected through controlled access methods.

### Collections

Employee records are managed using an ArrayList.

### Enums

Departments are represented using an enum.

### Records

Address information is implemented using Java Records.

## Sample Menu

```text
===== Employee Management System =====

1. Add Employee
2. Display Employees
3. Search Employee
4. Remove Employee
5. Update Employee Name
6. Total Salary Expense
7. Highest Paid Employee
8. Department Wise Count
9. Exit
```

## Future Enhancements

- File handling for data persistence
- Custom exceptions
- Employee sorting options
- Salary reports
- Database integration using JDBC
- Spring Boot REST API version

## Author

Sathya P

This project was created as part of Java learning and hands-on practice to strengthen Core Java fundamentals.
