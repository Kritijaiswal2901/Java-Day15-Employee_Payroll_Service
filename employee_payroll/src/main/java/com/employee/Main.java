package com.employee;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Employee Payroll Service.");

        EmployeePayrollService empPayrollService = new EmployeePayrollService();

        // connecting to the database
        empPayrollService.connectDatabase();

        // reading data of all the employees in the database
        ArrayList<Employee> employees = empPayrollService.getEmployeesFromDB();
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        // updating salary of Terissa to 3000000
        empPayrollService.updateSalaryInDB(3000000, "Terissa");

        // getting all employees joining between the given dates
        System.out.println("\nEmployees joining after 2023-1-1 are: ");
        ArrayList<String> emp_by_start_date = empPayrollService.getQueryDataFromDB(
                "select name, start_date from employee_payroll where start_date between cast(\"2023-1-1\" as date) and date(now());");
        for (String str : emp_by_start_date) {
            System.out.println(str);
        }

        // getting salary statistics by gender
        System.out.println("\nSalary statistics by gender are: ");
        ArrayList<String> salary_stats = empPayrollService.getStatsByGenderFromDB(
                "select gender, sum(salary), min(salary), max(salary), avg(salary) from employee_payroll group by gender; ");
        for (String str : salary_stats) {
            System.out.println(str);
        }

        // System.out.println("Welcome to Employee Payroll Service.");
        // Scanner sc = new Scanner(System.in);

        // EmployeePayrollService employeePayrollService = new
        // EmployeePayrollService("employee_data.txt");
        // employeePayrollService.addEmployeeToFile(new EmployeePayroll(100, "Jack",
        // 10000));

        // System.out.println(employeePayrollService.countEmployeesInFile());

        // employeePayrollService.addEmployeeToFile(new EmployeePayroll(200, "Joe",
        // 20000));
        // System.out.println(employeePayrollService.countEmployeesInFile());

        // System.out.println("EmployeePayroll File Data: ");
        // employeePayrollService.printEmployeesDataFromFile();

        // // Specify the file path for the Employee Payroll data
        // String filePath = "employee_data.txt";

        // // Create an instance of EmployeePayrollService
        // EmployeePayrollService empPayrollService = new
        // EmployeePayrollService(filePath);

        // // Perform analysis operations
        // while (true) {
        // System.out.println("\nChoose an analysis operation:");
        // System.out.println("[1] Print Employees from File");
        // System.out.println("[2] Sort Employees by Salary");
        // System.out.println("[3] Sort Employees by ID");
        // System.out.println("[4] Sort Employees by Name");
        // System.out.println("[5] Count Number of Employees in File");
        // System.out.print("Enter your choice (enter 0 to exit): ");

        // int choice = sc.nextInt();
        // sc.nextLine();
        // switch (choice) {
        // case 0:
        // return;

        // case 1:
        // empPayrollService.printEmployeesDataFromFile();
        // break;

        // case 2:
        // empPayrollService.sortBySalary();
        // break;

        // case 3:
        // empPayrollService.sortByID();
        // break;

        // case 4:
        // empPayrollService.sortByName();
        // break;

        // case 5:
        // System.out.println("Number of Employees in File: " +
        // empPayrollService.countEmployeesInFile());
        // break;

        // default:
        // System.out.println("Invalid choice. Please try again.");
        // }
        // }
    }
}