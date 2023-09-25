package com.jspiders.cardekho_case_study.operation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.jspiders.cardekho_case_study.entity.Car;

public class CarOperation {
	private List<Car> cars = new ArrayList<Car>() ;
	
	public void addCarDetails() {
		System.out.println("How Many Cars You Want to Add ??");
		Scanner sc = new Scanner(System.in) ;
		int choice = sc.nextInt() ;
		for (int i = 0; i < choice; i++) {
			Car car = new Car() ;
			System.out.println("Enter Car id :");
			car.setId(sc.nextInt());
			System.out.println("Enter Car Name :");
			car.setName(sc.next());
			System.out.println("Enter Car Model :");
			car.setModel(sc.next());
			System.out.println("Enter Car Brand :");
			car.setBrand(sc.next());
			System.out.println("Enter Car Fuel Type :");
			car.setFuelType(sc.next());
			System.out.println("Enter Car Price :");
			car.setPrice(sc.nextDouble());
			cars.add(car) ;
			System.out.println("\n\n"+car.getName()+" is sdded successfully.");			
		}
		getAllCars() ;
		
	}
	public void removeCarDetails() {
			getAllCars() ;
			if (cars.isEmpty()==false) {
				Scanner sc = new Scanner(System.in) ;
				System.out.println("Enter Car id to Remove Car :");
				int choice = sc.nextInt();
				Car car1 = null ;
				for(Car car : cars) {
					if(car.getId()==choice) {
						car1 = car ;
					}
					}
				if(car1 != null) {
					System.out.println(car1.getName()+" is Removed Successfully.");
					cars.remove(car1) ;
				}
				else {
					System.out.println("Inavlid Id. Enter Correct Id.");
					removeCarDetails() ;
					}
				}
	}
	public void searchByName() {
		if (cars.isEmpty()) {
			getAllCars() ;
		}
		else {
			Scanner sc = new Scanner(System.in) ;
			System.out.println("Enetr Name to Search Cars : ");
			String choice = sc.next();
			List<Car> cars1 = new ArrayList<Car>();
			for (Car car : cars) {
				if(car.getName().equalsIgnoreCase(choice)) {
					cars1.add(car) ;
				}				
			}
			if(cars1.isEmpty()) {
				System.out.println("Enter Valid Name!!!!");
			}
			else {
				System.out.println("Total Cars to Display: "+cars1.size());
				System.out.println("Id\t Name\t Model\t Brand\t Fuel Type\t Price");
				System.out.println("============================================================");
				for (Car car :cars1) {
					System.out.println(car.getId()+"\t "+car.getName()+"\t "+car.getModel()+"\t "+car.getBrand()+"\t "+car.getFuelType()+"\t\t "+car.getPrice());
				}
			}
		}
	}
	public void searchByBrand() {

		if (cars.isEmpty()) {
			getAllCars() ;
		}
		else {
			Scanner sc = new Scanner(System.in) ;
			System.out.println("Enetr Brand to Search Cars : ");
			String choice = sc.next();
			List<Car> cars1 = new ArrayList<Car>();
			for (Car car : cars) {
				if(car.getBrand().equalsIgnoreCase(choice)) {
					cars1.add(car) ;
				}				
			}
			if(cars1.isEmpty()) {
				System.out.println("Enter Valid Brand!!!!");
			}
			else {
				System.out.println("Total Cars to Display: "+cars1.size());
				System.out.println("Id\t Name\t Model\t Brand\t Fuel Type\t Price");
				System.out.println("============================================================");
				for (Car car :cars1) {
					System.out.println(car.getId()+"\t "+car.getName()+"\t "+car.getModel()+"\t "+car.getBrand()+"\t "+car.getFuelType()+"\t\t "+car.getPrice());
				}
			}
		}		
	}
	public void searchByFuelType() {
		if (cars.isEmpty()) {
			getAllCars() ;
		}
		else {
			Scanner sc = new Scanner(System.in) ;
			System.out.println("Enetr Fuel Type to Search Cars : ");
			String choice = sc.next();
			List<Car> cars1 = new ArrayList<Car>();
			for (Car car : cars) {
				if(car.getFuelType().equalsIgnoreCase(choice)) {
					cars1.add(car) ;
				}				
			}
			if(cars1.isEmpty()) {
				System.out.println("Enter Valid Fuel Type!!!!");
				searchByFuelType();
			}
			else {
				System.out.println("Total Cars to Display: "+cars1.size());
				System.out.println("Id\t Name\t Model\t Brand\t Fuel Type\t Price");
				System.out.println("============================================================");
				for (Car car :cars1) {
					System.out.println(car.getId()+"\t "+car.getName()+"\t "+car.getModel()+"\t "+car.getBrand()+"\t "+car.getFuelType()+"\t\t "+car.getPrice());
				}
			}
		}				
	}
	public void updateCarDetails() {
		if (cars.isEmpty()) {
			getAllCars() ;
		}	
		else {
			Scanner sc = new Scanner(System.in) ;
			System.out.println("Enter Car id to Update Car Details:");
			int choice = sc.nextInt() ;
			Car car1 = null ;
			for(Car car :cars) {
				if(car.getId()==choice) {
					car1 = car ;
				}
			}
			if(car1 !=null) {
				System.out.println("Enter Car New Name :");
				car1.setName(sc.next());
				System.out.println("Enter Car New Model :");
				car1.setModel(sc.next());
				System.out.println("Enter Car New Brand :");
				car1.setBrand(sc.next());
				System.out.println("Enter Car New Fuel Type :");
				car1.setFuelType(sc.next());
				System.out.println("Enter Car New Price :");
				car1.setPrice(sc.nextDouble());
				
				System.out.println("Car Deatils Updated Successfully.");
			}
			else {
				System.out.println("Enter Valid  Car Id.!!!!");
			}
		}
	}
		
	public void getAllCars() {
		if(cars.isEmpty()) {
			System.out.println("No Cars to Display!!!");
		}
		else {
			System.out.println("Total Cars to Display: "+cars.size());
			System.out.println("Id\t Name\t Model\t Brand\t Fuel Type\t Price");
			System.out.println("============================================================");
			for (Car car: cars) {
				System.out.println(car.getId()+"\t "+car.getName()+"\t "+car.getModel()+"\t "+car.getBrand()+"\t "+car.getFuelType()+"\t\t "+car.getPrice());
				}
			}
		}
	}

