package main;


import com.ems.model.*;

import java.util.Scanner;
import com.ems.service.*;
public class EmployeeMgtApp {
	public static void main(String[] args) {
		
		EmployeeService service = new EmployeeService();
		
		Address a1=new Address("Erode", "TN","638052");
		
		Employee e1=new FullTimeEmployee(100,"Ramesh", Department.ADMIN,a1,5000);
		Employee e2=new PartTimeEmployee(200,"Suresh", Department.HR,a1,5, 500);
		Employee e3=new ContractEmployee(300,"Kala", Department.SALES,a1,20000);
		
		Scanner sc = new Scanner(System.in);
		int choice;
		service.addEmployee(e1);
		service.addEmployee(e2);
		service.addEmployee(e3);

		do {

			System.out.println("1. Add Employee");
			System.out.println("2. Display Employees");
			System.out.println("3. Search Employee");
			System.out.println("4. Remove Employee");
			System.out.println("5. Update Employee Name");
			System.out.println("6. Total Salary Expense");
			System.out.println("7. Highest Paid Employee");
			System.out.println("8. Department Wise Count");
			System.out.println("9. Exit");

		    System.out.print("Enter Choice: ");
		    choice = sc.nextInt();

		    switch(choice) {

		    case 1:

		        System.out.println("Choose Employee Type");
		        System.out.println("1. Full Time");
		        System.out.println("2. Part Time");
		        System.out.println("3. Contract");

		        int type = sc.nextInt();

		        System.out.print("Enter Employee ID: ");
		        int empId = sc.nextInt();

		        sc.nextLine();

		        System.out.print("Enter Employee Name: ");
		        String empName = sc.nextLine();

		        System.out.println("Select Department");
		        System.out.println("1.ADMIN  2.HR  3.SALES  4.IT");

		        int deptChoice = sc.nextInt();

		        Department dept = null;

		        switch(deptChoice) {
		            case 1:
		                dept = Department.ADMIN;
		                break;
		            case 2:
		                dept = Department.HR;
		                break;
		            case 3:
		                dept = Department.SALES;
		                break;
		            case 4:
		                dept = Department.IT;
		                break;
		            default:
		                System.out.println("Invalid Department");
		                break;
		        }

		        sc.nextLine();

		        System.out.print("Enter City: ");
		        String city = sc.nextLine();

		        System.out.print("Enter State: ");
		        String state = sc.nextLine();

		        System.out.print("Enter Pincode: ");
		        String pincode = sc.nextLine();

		        Address address = new Address(city, state, pincode);

		        Employee emp = null;

		        if(type == 1) {

		            System.out.print("Enter Monthly Salary: ");
		            double salary = sc.nextDouble();

		            emp = new FullTimeEmployee(
		                    empId,
		                    empName,
		                    dept,
		                    address,
		                    salary);

		        }
		        else if(type == 2) {

		            System.out.print("Enter Hours Worked: ");
		            int hours = sc.nextInt();

		            System.out.print("Enter Hourly Rate: ");
		            double rate = sc.nextDouble();

		            emp = new PartTimeEmployee(
		                    empId,
		                    empName,
		                    dept,
		                    address,
		                    hours,
		                    rate);

		        }
		        else if(type == 3) {

		            System.out.print("Enter Contract Amount: ");
		            double amount = sc.nextDouble();

		            emp = new ContractEmployee(
		                    empId,
		                    empName,
		                    dept,
		                    address,
		                    amount);
		        }

		        if(emp != null) {
		            service.addEmployee(emp);
		            System.out.println("Employee Added Successfully");
		        }

		        break;
		    case 2:
		        service.displayEmployees();
		        break;

		    case 3:
		        // Search Employee
		    

		        System.out.print("Enter Employee ID: ");
		        int id = sc.nextInt();

		        Employee found = service.searchEmployee(id);

		        if(found != null) {
		            System.out.println("Employee Found");
		            found.displayBasicInfo();
		            System.out.println("Salary: " + found.calcSalary());
		        }
		        else {
		            System.out.println("Employee Not Found");
		        }

		        break;
		    case 4:
		        // Remove Employee
		    	System.out.print("Enter Employee ID to Remove: ");
		        int removeId = sc.nextInt();

		        if(service.removeEmployee(removeId))
		            System.out.println("Employee Removed");
		        else
		            System.out.println("Employee Not Found");

		        break;

		    case 5:
		    	//update employee
		        System.out.print("Enter Employee ID: ");
		        int updateId = sc.nextInt();

		        sc.nextLine();

		        System.out.print("Enter New Name: ");
		        String name = sc.nextLine();

		        service.updateName(updateId,name);

		        System.out.println("Updated Successfully");

		        break;

		    case 6:
		        // Total Payroll
		    	service.totalSalaryExpense();

		        break;

		    case 7:
		        // Highest Paid
		    	Employee highest = service.highestPaidEmployee();

		        System.out.println("Highest Paid Employee");

		        highest.displayBasicInfo();
		        System.out.println("Salary : " + highest.calcSalary());

		        break;

		    case 8:
		        // Department Count
		    	service.departmentWiseCount();

		        break;

		    case 9:
		        System.out.println("Thank You!");
		        break;

		    default:
		        System.out.println("Invalid Choice");
		    }

		} while(choice != 8);
		
		
		
		
	}

}
