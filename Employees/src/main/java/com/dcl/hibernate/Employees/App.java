package com.dcl.hibernate.Employees;

import java.util.Scanner;

import com.dcl.hibernate.Employee.Employee;
import com.dcl.hibernate.EmployeesDao.EmployeesDao;

public class App {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		EmployeesDao ed = new EmployeesDao();
		Employee emp = new Employee();
		while (true) {
			System.out.println("Select Your choice");
			System.out.println("1.Insert Employee");
			System.out.println("2.Find Employee by Id");
			System.out.println("3.Find All Employee");
			System.out.println("4.Update Employee by Id");
			System.out.println("5.Delete Employee by Id");
			int choice = scan.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Enter employee Id");
				emp.setEmpId(scan.nextInt());
				System.out.println("Enter employee Name");
				emp.seteName(scan.next());
				System.out.println("Enter employee Salary");
				emp.setSal(scan.nextInt());
				ed.insert(emp);
				break;
			case 2:
				System.out.println("Enter Id to find Employee");
				int id = scan.nextInt();
				ed.findById(id);
				break;
			case 3:
				ed.findAll();
				break;
			case 4:
				System.out.println("Enter Id to Update Salary");
				int id1 = scan.nextInt();
				System.out.println("Enter updated Salary");
				int sal = scan.nextInt();
				ed.updateById(id1,sal);
				break;
			case 5:
				System.out.println("Enter Id to Delete");
				int id2 = scan.nextInt();
				ed.deleteById(id2);
				break;
			default:
				System.out.println("Enter proper choice");
			}
		}
	}
}
