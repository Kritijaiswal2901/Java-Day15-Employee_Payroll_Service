package com.employee;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    private List<EmployeePayroll> employees;
    private String filePath;

    public EmployeePayrollService(String filePath) {
        this.filePath = filePath;
        FileOperations.createEmptyFile(filePath);
    }

    public String getFilePath() {
        return this.filePath;
    }

    public EmployeePayrollService() {
        this.employees = new ArrayList<>();
    }

    public List<EmployeePayroll> getEmployees() {
        return this.employees;
    }

    // method to add new employee to the file
    public void addEmployeeToFile(EmployeePayroll employee) {
        FileOperations.writeDataToFile(filePath, employee.toString());
    }

    // method to count number of employees in file
    public int countEmployeesInFile() {
        return FileOperations.countLines(this.filePath);
    }

    public void printEmployeesDataFromFile() {
        System.out.println(FileOperations.readFileContent(this.filePath));
    }

    // Method to print employees after sorting them by salary
    public void sortBySalary() {
        System.out.println("Employees sorted by salary:");
        List<EmployeePayroll> sortedList = new ArrayList<>(this.employees);
        sortedList.sort(Comparator.comparing(EmployeePayroll::getEmployeeSalary));
        sortedList.forEach(System.out::println);
    }

    // Method to print employees after sorting them by Id
    public void sortByID() {
        System.out.println("Employees sorted by ID:");
        List<EmployeePayroll> sortedList = new ArrayList<>(this.employees);
        sortedList.sort(Comparator.comparing(EmployeePayroll::getEmployeeId));
        sortedList.forEach(System.out::println);
    }

    // Method to print employees after sorting them by Name
    public void sortByName() {
        System.out.println("Employees sorted by name:");
        List<EmployeePayroll> sortedList = new ArrayList<>(this.employees);
        sortedList.sort(Comparator.comparing(EmployeePayroll::getEmployeeName));
        sortedList.forEach(System.out::println);
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
