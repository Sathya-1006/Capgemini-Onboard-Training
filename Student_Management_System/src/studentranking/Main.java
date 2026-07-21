package studentranking;

import java.util.*;


public class Main {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentOperations obj = new StudentOperations();

        System.out.print("Enter number of students : ");
        int n = sc.nextInt();

        for(int i=1;i<=n;i++) {

            System.out.println("\nStudent " + i);

            System.out.print("Roll No : ");
            int roll = sc.nextInt();

            sc.nextLine();

            System.out.print("Name : ");
            String name = sc.nextLine();

            System.out.print("Marks : ");
            int marks = sc.nextInt();

            sc.nextLine();

            System.out.print("Department : ");
            String dept = sc.nextLine();

            obj.addStudent(new Student(roll, name, marks, dept));

        }

        while(true) {

            System.out.println("\n------ MENU ------");
            System.out.println("1.Display Students");
            System.out.println("2.Sort by Marks");
            System.out.println("3.Sort by Name");
            System.out.println("4.Sort by Roll No");
            System.out.println("5.Top 5 Students");
            System.out.println("6.Department Wise Topper");
            System.out.println("7.Count Above 80");
            System.out.println("8.Exit");

            System.out.print("Enter choice : ");
            int choice = sc.nextInt();

            switch(choice) {

            case 1:
                obj.displayStudents();
                break;

            case 2:
                obj.sortByMarks();
                break;

            case 3:
                obj.sortByName();
                break;

            case 4:
                obj.sortByRollNo();
                break;

            case 5:
                obj.topFiveStudents();
                break;

            case 6:
                obj.departmentTopper();
                break;

            case 7:
                obj.countAbove80();
                break;

            case 8:
                System.exit(0);

            default:
                System.out.println("Invalid Choice");
            }

        }

    }
}
