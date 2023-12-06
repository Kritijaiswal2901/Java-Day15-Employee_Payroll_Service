package com.employee;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
       
        System.out.println("Welcome to Employee Payroll Service.");
        Scanner scanner = new Scanner(System.in);
        EmployeePayrollService employeePayrollService1 = new EmployeePayrollService();

        EmployeePayrollService employeePayrollService = new EmployeePayrollService("employees.txt");
        employeePayrollService.addEmployeeToFile(new EmployeePayroll(100, "Jack", 10000));

        System.out.println(employeePayrollService.countEmployeesInFile());

        employeePayrollService.addEmployeeToFile(new EmployeePayroll(200, "Joe", 20000));
        System.out.println(employeePayrollService.countEmployeesInFile());

        System.out.println("EmployeePayroll File Data: ");
        employeePayrollService.printEmployeesDataFromFile();



    }
}


