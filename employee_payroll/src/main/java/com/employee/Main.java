package com.employee;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       
        System.out.println("Welcome to Employee Payroll Service.");
        Scanner sc = new Scanner(System.in);

        EmployeePayrollService employeePayrollService = new EmployeePayrollService("employee_data.txt");
        employeePayrollService.addEmployeeToFile(new EmployeePayroll(100, "Jack", 10000));

        System.out.println(employeePayrollService.countEmployeesInFile());

        employeePayrollService.addEmployeeToFile(new EmployeePayroll(200, "Joe", 20000));
        System.out.println(employeePayrollService.countEmployeesInFile());

        System.out.println("EmployeePayroll File Data: ");
        employeePayrollService.printEmployeesDataFromFile();

     // Specify the file path for the Employee Payroll data
          String filePath = "employee_data.txt";

     // Create an instance of EmployeePayrollService
     EmployeePayrollService empPayrollService = new EmployeePayrollService(filePath);

     // Perform analysis operations
     while (true) {
         System.out.println("\nChoose an analysis operation:");
         System.out.println("[1] Print Employees from File");
         System.out.println("[2] Sort Employees by Salary");
         System.out.println("[3] Sort Employees by ID");
         System.out.println("[4] Sort Employees by Name");
         System.out.println("[5] Count Number of Employees in File");
         System.out.print("Enter your choice (enter 0 to exit): ");

         int choice = sc.nextInt();
         sc.nextLine();
         switch (choice) {
             case 0:
                 return;

             case 1:
                 empPayrollService.printEmployeesDataFromFile();
                 break;

             case 2:
                 empPayrollService.sortBySalary();
                 break;

             case 3:
                 empPayrollService.sortByID();
                 break;

             case 4:
                 empPayrollService.sortByName();
                 break;

             case 5:
                 System.out.println("Number of Employees in File: " + empPayrollService.countEmployeesInFile());
                 break;
             
             default:
                 System.out.println("Invalid choice. Please try again.");
         }
     }
 }
}