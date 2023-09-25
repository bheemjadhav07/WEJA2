package com.jspiders.cardekho_case_study.main;
import java.util.Scanner ;

import com.jspiders.cardekho_case_study.operation.CarOperation ;

public class CarDekhoMenu {
	private static CarOperation operation = new CarOperation() ;
	public static void main(String[] args) {
		while (true) {
			menu() ;
		}		
	}
	public static void menu(){
		Scanner sc = new Scanner(System.in) ;
			System.out.println("========== MENU ==========\n"
					+ "1. Add/Remove Car Deatails\n"
					+ "2. Search Car Details\n"
					+ "3. Update Car Deatails\n"
					+ "4. Exit");
			System.out.println("Enter Your Choice: ");
			int choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("========== MENU ==========\n"
						+ "1. Add Car Details\n"
						+ "2. Remove Car Details\n"
						+ "3. Go Back ");
				int choice2 = sc.nextInt();
				switch (choice2) {
				case 1:
					operation.addCarDetails() ;
					break;
				case 2:
					operation.removeCarDetails() ;
					break ;
				case 3:
					menu() ;
					break ;
				default:
					System.out.println("Enter Valid Choice");
					break;
				}
				break;
			case 2:
				System.out.println("========== MENU ==========\n"
						+ "1. Search Car by Name\n"
						+ "2. Search Car by Brand\n"
						+ "3. Search Car by FuelType\n"
						+ "4. Search All Cars\n"
						+ "5. Go Back ");
				int choice3 = sc.nextInt();
				switch (choice3) {
				case 1:
					operation.searchByName() ;
					break;
				case 2:
					operation.searchByBrand() ;
					break;
				case 3:
					operation.searchByFuelType() ;
					break;
				case 4:
					operation.getAllCars() ;
					break ;
				case 5:
					menu() ;

				default:
					System.out.println("Enter Valid Input");
					break;
				}
				break ;
			case 3:
				operation.updateCarDetails() ;
				break ;
			case 4:
				System.out.println("Thank You!!!!");
				sc.close();
				System.exit(0) ;
			default:
			System.out.println("Enter Valid Choice....");
			}
	}

}

