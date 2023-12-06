package com.employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    private List<EmployeePayroll> employees;

    public EmployeePayrollService() {
        this.employees = new ArrayList<>();
    }

    public List<EmployeePayroll> getEmployees() {
        return this.employees;
    }

    public void addEmployee(EmployeePayroll employee) {
        this.employees.add(employee);
    }

    public void recordEmployeeData(Scanner inputScanner) {
        System.out.print("\nEmployee Id: ");
        int id = inputScanner.nextInt();
        inputScanner.nextLine();

        System.out.print("Employee Name: ");
        String name = inputScanner.nextLine();

        System.out.print("Employee Salary: ");
        double salary = inputScanner.nextDouble();
        inputScanner.nextLine();

        this.addEmployee(new EmployeePayroll(id, name, salary));
        System.out.println("Employee details have been recorded successfully.\n");
    }

    public void viewEmployees() {
        System.out.println("\nList of employees: \n" + this);
    }

    @Override
    public String toString() {
        StringBuilder data = new StringBuilder();
        for (EmployeePayroll employee : this.employees) {
            data.append(employee.toString()).append("\n");
        }
        return data.toString();
    }
}
