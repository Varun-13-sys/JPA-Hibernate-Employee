package com.dcl.hibernate.EmployeesDao;

import java.sql.ResultSet;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.dcl.hibernate.Employee.Employee;

import java.util.List;

public class EmployeesDao {
	Scanner scan = new Scanner(System.in);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql-config");

	public void insert(Employee emp) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(emp);
		et.commit();
		System.out.println("Object Inserted");
		em.close();
	}

	public void findById(int id) {
		EntityManager em = emf.createEntityManager();
		Employee emp = em.find(Employee.class, id);
		System.out.println(emp);
		em.close();
	}

	public void findAll() {
		EntityManager em = emf.createEntityManager();
		String jpql = "select e from Employee e"; 
		List<Employee> emp = em.createQuery(jpql,Employee.class).getResultList();
		
		for (Employee employee : emp) {
			System.out.println(employee);
		}
	}

	public void updateById(int id,int sal) {
		EntityManager em = emf.createEntityManager();
		Employee emp = em.find(Employee.class, id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		if (emp != null) {
			emp.setSal(sal);
			em.merge(emp);
			et.commit();
		} else
			System.err.println("Can't Update");
		em.close();
	}

	public void deleteById(int id) {
		EntityManager em = emf.createEntityManager();
		Employee emp = em.find(Employee.class, id);
		EntityTransaction et = em.getTransaction();
		et.begin();
		if (emp != null) {
			em.remove(emp);
			et.commit();
		} else
			System.err.println("No data to delete");
		em.close();
	}
}
