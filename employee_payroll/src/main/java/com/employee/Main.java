package com.employee;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       
        System.out.println("Welcome to Employee Payroll Service.");
        Scanner scanner = new Scanner(System.in);
        EmployeePayrollService employeePayrollService1 = new EmployeePayrollService();

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("[1] Add a new team member");
            System.out.println("[2] Check out the current team");
            System.out.print("Enter 0 to exit: ");
            int userChoice = scanner.nextInt();
            scanner.nextLine(); 

            if (userChoice == 0) {
                break;
            } else if (userChoice == 1) {
                employeePayrollService1.recordEmployeeData(scanner);
            } else if (userChoice == 2) {
                employeePayrollService1.viewEmployees();
            } else {
                System.out.println("Please try again.");
            }
        }
    }
}


