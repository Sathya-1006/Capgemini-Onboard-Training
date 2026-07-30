package com.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	

	    public static void main(String[] args) {

	        ApplicationContext context =
	                new ClassPathXmlApplicationContext("spring.xml");

	        EmployeeDAO dao = (EmployeeDAO) context.getBean("dao");

	        Scanner sc = new Scanner(System.in);
//
//	        while (true) {
//
//	            System.out.println("\n========== EMPLOYEE MANAGEMENT ==========");
//	            System.out.println("1. Insert Employee");
//	            System.out.println("2. Update Salary");
//	            System.out.println("3. Update Department");
//	            System.out.println("4. Delete Employee");
//	            System.out.println("5. Search Employee");
//	            System.out.println("6. Display All Employees");
//	            System.out.println("7. Display IT Employees");
//	            System.out.println("8. Display Salary > 50000");
//	            System.out.println("9. Total Employees");
//	            System.out.println("10. Maximum Salary");
//	            System.out.println("11. Minimum Salary");
//	            System.out.println("12. Average Salary");
//	            System.out.println("13. Search By Name");
//	            System.out.println("14. Sort Salary");
//	            System.out.println("15. Exit");
//
//	            System.out.print("\nEnter Choice : ");
//	            int choice = sc.nextInt();

//	            switch (choice) {
//
//	            case 1:
//
//	                Employee emp = new Employee();
//
//	                System.out.print("Enter Employee ID : ");
//	                emp.setEmpId(sc.nextInt());
//
//	                sc.nextLine();
//
//	                System.out.print("Enter Employee Name : ");
//	                emp.setEmpName(sc.nextLine());
//
//	                System.out.print("Enter Department : ");
//	                emp.setDepartment(sc.nextLine());
//
//	                System.out.print("Enter Salary : ");
//	                emp.setSalary(sc.nextDouble());
//
//	                sc.nextLine();
//
//	                System.out.print("Enter Email : ");
//	                emp.setEmail(sc.nextLine());
//
//	                System.out.print("Enter Mobile : ");
//	                emp.setMobile(sc.nextLine());
//
//	                System.out.print("Enter City : ");
//	                emp.setCity(sc.nextLine());
//
//	                dao.insertEmployee(emp);
//	                break;
//
//	            case 2:
//
//	                System.out.print("Enter Employee ID : ");
//	                int id = sc.nextInt();
//
//	                System.out.print("Enter New Salary : ");
//	                double salary = sc.nextDouble();
//
//	                dao.updateSalary(id, salary);
//	                break;
//
//	            case 3:
//
//	                System.out.print("Enter Employee ID : ");
//	                int id1 = sc.nextInt();
//
//	                sc.nextLine();
//
//	                System.out.print("Enter New Department : ");
//	                String dept = sc.nextLine();
//
//	                dao.updateDepartment(id1, dept);
//	                break;
//
//	            case 4:
//
//	                System.out.print("Enter Employee ID : ");
//	                int deleteId = sc.nextInt();
//
//	                dao.deleteEmployee(deleteId);
//	                break;
//
//	            case 5:
//
//	                System.out.print("Enter Employee ID : ");
//	                int searchId = sc.nextInt();
//
//	                Employee e = dao.searchEmployee(searchId);
//
//	                if (e != null)
//	                    System.out.println(e);
//	                else
//	                    System.out.println("Employee Not Found");
//
//	                break;
//
//	            case 6:
//
//	                List<Employee> list = dao.displayAll();
//
//	                list.forEach(System.out::println);
//
//	                break;
//
//	            case 7:
//
//	                dao.displayITEmployees()
//	                        .forEach(System.out::println);
//
//	                break;
//
//	            case 8:
//
//	                dao.salaryGreaterThan50000()
//	                        .forEach(System.out::println);
//
//	                break;
//
//	            case 9:
//
//	                System.out.println("Total Employees : "
//	                        + dao.totalEmployees());
//
//	                break;
//
//	            case 10:
//
//	                System.out.println("Maximum Salary : "
//	                        + dao.maximumSalary());
//
//	                break;
//
//	            case 11:
//
//	                System.out.println("Minimum Salary : "
//	                        + dao.minimumSalary());
//
//	                break;
//
//	            case 12:
//
//	                System.out.println("Average Salary : "
//	                        + dao.averageSalary());
//
//	                break;
//
//	            case 13:
//
//	                sc.nextLine();
//
//	                System.out.print("Enter Employee Name : ");
//	                String name = sc.nextLine();
//
//	                dao.searchByName(name)
//	                        .forEach(System.out::println);
//
//	                break;
//
//	            case 14:
//
//	                dao.sortSalary()
//	                        .forEach(System.out::println);
//
//	                break;
//
//	            case 15:
//
//	                System.out.println("Thank You...");
//	                sc.close();
//	                System.exit(0);
//
//	            default:
//
//	                System.out.println("Invalid Choice");
//	            }
	            
	            
	            // ----BATCH INSERT ----
	            List<Employee> list = new ArrayList<>();
	            
	            Employee e1 = new Employee(201, "Sathya", "IT", 65000,
	                    "sathya@gmail.com", "9876543210", "Erode");

	            Employee e2 = new Employee(202, "Rahul", "HR", 45000,
	                    "rahul@gmail.com", "9876543211", "Chennai");

	            Employee e3 = new Employee(203, "Priya", "Finance", 70000,
	                    "priya@gmail.com", "9876543212", "Coimbatore");

	            list.add(e1);
	            list.add(e2);
	            list.add(e3);

	        //    dao.batchInsert(list);
	            
	            
	            //BeanPropertyRowMapper -> getEmployeeById()
//	            System.out.print("Enter Employee ID: ");
//	            int id = sc.nextInt();
//
//	            Employee emp = dao.getEmployeeById(id);
//	            System.out.println(emp);
//	            
	            
//	            //NamedParameter --->  insertNP()
//	            Employee emp = new Employee(
//	                    205,
//	                    "Sarah",
//	                    "Finance",
//	                    37000,
//	                    "sarah@gmail.com",
//	                    "9876543210",
//	                    "Erode"
//	            );
//
//	            dao.insertNP(emp);
	            
	            
	            //Service class call
	            EmployeeService service = (EmployeeService) context.getBean("service");

	            service.updateTwoEmployees();
	            
//	        }
	    }
	

}
