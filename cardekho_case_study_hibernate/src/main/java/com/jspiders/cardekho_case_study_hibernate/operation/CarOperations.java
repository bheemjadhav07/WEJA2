package com.jspiders.cardekho_case_study_hibernate.operation;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.cardekho_case_study_hibernate.entity.Car;

public class CarOperations {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	private static EntityTransaction entityTransaction;
	private static Scanner sc = new Scanner(System.in);

	private static void openConnection() {

		entityManagerFactory = Persistence.createEntityManagerFactory("bheem");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();

	}

	private static void closeConnection() {

		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager != null) {
			entityManager.close();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}

	public void addCarDetails() {
		openConnection();
		entityTransaction.begin();
		
		System.out.println("How Many Cars you Want to add ??");
		int choice = sc.nextInt();
		for (int i=1;i<=choice;i++) {
			
			Car car = new Car();
			System.out.println("Enter Car Name : ");
			car.setName(sc.next());
			System.out.println("Enter Car Model : ");
			car.setModel(sc.next());
			System.out.println("Enter Car Brand : ");
			car.setBrand(sc.next());
			System.out.println("Enter Car FuelType : ");
			car.setFuelType(sc.next());
			System.out.println("Enter Car Price : ");
			car.setPrice(sc.nextDouble());
			
			entityManager.persist(car);
			
			System.out.println(car.getName()+" car added successfully.");
		}

		entityTransaction.commit();
		closeConnection();
	}
	
	public void getAllCars() {
		
		openConnection();
		entityTransaction.begin();
		
		Query query = entityManager.createQuery("SELECT car FROM Car car") ;
		@SuppressWarnings("unchecked")
		List<Car> cars = query.getResultList();
		for(Car car : cars) {
			
			System.out.println(car.getId()+"\t"+car.getName()+"\t"+car.getModel()+"\t"+car.getBrand()+"\t"+car.getFuelType()+"\t"+car.getPrice());
		}
		
		entityTransaction.commit();
		closeConnection();
	}
	
	public void removeCarDetails() {
		
		openConnection();
		entityTransaction.begin();
		
		getAllCars();
		System.out.println("Enter id to Remove Car Details : ");
		
		int id = sc.nextInt() ;
		Car car = entityManager.find(Car.class, id);
		entityManager.remove(car);	
		
		System.out.println(car.getName()+"car Removed Successfully.");
		
		entityTransaction.commit();
		closeConnection();		
	}
	
	public void searchByName() {
		
		openConnection();
		entityTransaction.begin();
		
		System.out.println("Enter Name to Search : ");
		String choice = sc.next() ;
		
		Query query = entityManager.createQuery("Select car from Car car where name = '"+choice+"'") ;
		@SuppressWarnings("unchecked")
		List<Car> cars = query.getResultList();
		for(Car car : cars) {
			System.out.println(car.getId()+"\t"+car.getName()+"\t"+car.getModel()+"\t"+car.getBrand()+"\t"+car.getFuelType()+"\t"+car.getPrice());
		}
		
		entityTransaction.commit();
		closeConnection();
		
	}
	
	public void searchByBrand() {
		
		openConnection();
		entityTransaction.begin();
		
		System.out.println("Enter Brand to Search : ");
		String choice = sc.next() ;
		
		Query query = entityManager.createQuery("Select car from Car car where brand = '"+choice+"'") ;
		@SuppressWarnings("unchecked")
		List<Car> cars = query.getResultList();
		for(Car car : cars) {
			System.out.println(car.getId()+"\t"+car.getName()+"\t"+car.getModel()+"\t"+car.getBrand()+"\t"+car.getFuelType()+"\t"+car.getPrice());
		}
		
		entityTransaction.commit();
		closeConnection();
		
	}
	
	public void searchByFuelType() {
		
		openConnection();
		entityTransaction.begin();
		
		System.out.println("Enter Fueltype to Search : ");
		String choice = sc.next() ;
		
		Query query = entityManager.createQuery("Select car from Car car where fueltype = '"+choice+"'") ;
		@SuppressWarnings("unchecked")
		List<Car> cars = query.getResultList();
		for(Car car : cars) {
			
			System.out.println(car.getId()+"\t"+car.getName()+"\t"+car.getModel()+"\t"+car.getBrand()+"\t"+car.getFuelType()+"\t"+car.getPrice());
			
		}
		
		entityTransaction.commit();
		closeConnection();
		
	}
	
	public void updateCarDetails() {
		
		openConnection();
		entityTransaction.begin();
		
		getAllCars();
		
		System.out.println("Enter id to Update Car Details : ");
		int id = sc.nextInt() ;
		Car car = entityManager.find(Car.class, id);
		
		System.out.println("Enter new Car Name : ");
		car.setName(sc.next());
		System.out.println("Enter new Car Model : ");
		car.setModel(sc.next());
		System.out.println("Enter new Car Brand : ");
		car.setBrand(sc.next());
		System.out.println("Enter new Car FuelType : ");
		car.setFuelType(sc.next());
		System.out.println("Enter new Car Price : ");
		car.setPrice(sc.nextDouble());
		
		System.out.println(car.getName()+ " car Updated Succesfully.");
		
		
		entityTransaction.commit();
		closeConnection();
		
	}

}
