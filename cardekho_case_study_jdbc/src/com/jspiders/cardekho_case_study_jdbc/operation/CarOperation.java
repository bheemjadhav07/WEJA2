package com.jspiders.cardekho_case_study_jdbc.operation;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import com.jspiders.cardekho_case_study_jdbc.entity.Car;

public class CarOperation {
	
	private static Connection connection ;
	private static PreparedStatement preparedStatement ;
	private static ResultSet resultSet;
	private static int result ;
	private static Properties properties = new Properties() ;
	private static FileInputStream file ;
	private static String filePath = "D:\\QSpiders\\WEJA2\\jdbc\\resources\\db_info.properties";
	private static String query ;
	private static Scanner sc = new Scanner(System.in) ;
	
	private static void openConnection() {
		
		try {
			file = new FileInputStream(filePath) ;
			properties.load(file);
			
			Class.forName(properties.getProperty("driverPath")) ;
			
			connection = DriverManager.getConnection(properties.getProperty("dburl"), properties);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	private static void closeConnection() {
	
	try {
		
			if(connection != null) {
			connection.close();
			}
			if (preparedStatement != null) {
				preparedStatement.close();				
			}
			if (resultSet != null) {
				resultSet.close();					
			}
			if (file != null) {
				file.close();					
			}
			
			if(result != 0) {
				result = 0 ;
			}
			
		
		} catch (Exception e) {
		e.printStackTrace();
		}	
	}
	public void addCarDetails() {
		
		try {
			openConnection();
			query = "insert into car values (?,?,?,?,?,?)" ;
			
			preparedStatement = connection.prepareStatement(query) ;
			System.out.println("Enter How many Cars you want to Add :");
			int choice = sc.nextInt();
			
			for(int i = 1; i<=choice ;i++) {
				ArrayList<Integer> id = new ArrayList<>() ;
				resultSet = preparedStatement.executeQuery("select * from car") ;
				while(resultSet.next()) {
					id.add(resultSet.getInt(1)) ;
				}
				System.out.println("Already Taken ids are :" +id);
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
				
				preparedStatement.setInt(1,car.getId() );
				preparedStatement.setString(2, car.getName());
				preparedStatement.setString(3, car.getModel());
				preparedStatement.setString(4, car.getBrand());
				preparedStatement.setString(5, car.getFuelType());
				preparedStatement.setDouble(6,car.getPrice());
				
				result = preparedStatement.executeUpdate() ;
				System.out.println(car.getName()+ " Car Added Succesfully.");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
	}
	
	public void getAllCars() {
		try {
			
			openConnection();
			query = "select * from Car" ;
			preparedStatement = connection.prepareStatement(query) ;
			resultSet = preparedStatement.executeQuery() ;
			System.out.println("Id \t\t Name \t\t Model \t\t Brand \t\tFuelType \t Price");
			while(resultSet.next()) {
				
				System.out.println(resultSet.getInt(1) + "\t\t"
								  +resultSet.getString(2)+ "\t\t"
								  +resultSet.getString(3)+ "\t\t"
								  +resultSet.getString(4)+ "\t\t"
								  +resultSet.getString(5)+ "\t\t"
								  +resultSet.getDouble(6));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		
	}
	public void searchByName() {
		try {
			openConnection();
			query = "select * from Car where name = ?" ;
			preparedStatement = connection.prepareStatement(query) ;
			System.out.println("Enter Name : ");
			
			preparedStatement.setString(1, sc.next());
			resultSet = preparedStatement.executeQuery() ;
			
			System.out.println("Id \t\t Name \t\t Model \t\t Brand \t\tFuelType \t Price");
			while(resultSet.next()) {
				
				System.out.println(resultSet.getInt(1) + "\t\t"
								  +resultSet.getString(2)+ "\t\t"
								  +resultSet.getString(3)+ "\t\t"
								  +resultSet.getString(4)+ "\t\t"
								  +resultSet.getString(5)+ "\t\t"
								  +resultSet.getDouble(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		
	}
	public void searchByBrand() {
		try {
			
			openConnection();
			query = "select * from Car where brand = ?" ;
			preparedStatement = connection.prepareStatement(query) ;
			System.out.println("Enter Brand : ");
			
			preparedStatement.setString(1, sc.next());
			resultSet = preparedStatement.executeQuery() ;
			
			System.out.println("Id \t\t Name \t\t Model \t\t Brand \t\tFuelType \t Price");
			while(resultSet.next()) {
				
				System.out.println(resultSet.getInt(1) + "\t\t"
								  +resultSet.getString(2)+ "\t\t"
								  +resultSet.getString(3)+ "\t\t"
								  +resultSet.getString(4)+ "\t\t"
								  +resultSet.getString(5)+ "\t\t"
								  +resultSet.getDouble(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		
	}
	public void searchByFuelType() {
		try {
			
			openConnection();
			query = "select * from Car where fuelType = ?" ;
			preparedStatement = connection.prepareStatement(query) ;
			System.out.println("Enter FuelType : ");
			
			preparedStatement.setString(1, sc.next());
			resultSet = preparedStatement.executeQuery() ;
			
			System.out.println("Id \t\t Name \t\t Model \t\t Brand \t\tFuelType \t Price");
			while(resultSet.next()) {
				
				System.out.println(resultSet.getInt(1) + "\t\t"
								  +resultSet.getString(2)+ "\t\t"
								  +resultSet.getString(3)+ "\t\t"
								  +resultSet.getString(4)+ "\t\t"
								  +resultSet.getString(5)+ "\t\t"
								  +resultSet.getDouble(6));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		
	}
	public void updateCarDetails() {
		try {
			
			getAllCars();
			openConnection();
			System.out.println("Enter id to update car details : ");
			int id = sc.nextInt();
			
			System.out.println("What you want to Update :\n"
					+ "1. Name\n"
					+ "2. Model\n"
					+ "3. Brand\n"
					+ "4. FuelType\n"
					+ "5. Price\n"
					+ "6. Go Back");
			int choice = sc.nextInt() ;
			switch (choice) {
			case 1:
				System.out.println("Enter new car Name : ");
				String name = sc.next() ;
				query = "update car set name =? where id =?  " ;
				preparedStatement = connection.prepareStatement(query) ;
				preparedStatement.setString(1, name);
				preparedStatement.setInt(2, id);
				result = preparedStatement.executeUpdate() ;
				if(result != 0) {
					System.out.println("Car details updated Succesfully.");
				}else {
					System.out.println("Enter valid Data....!!!");
				}
				break;
			case 2:
				System.out.println("Enter new car model : ");
				String model = sc.next() ;
				query = "update car set model =? where id =?  " ;
				preparedStatement = connection.prepareStatement(query) ;
				preparedStatement.setString(1, model);
				preparedStatement.setInt(2, id);
				result = preparedStatement.executeUpdate() ;
				if(result != 0) {
					System.out.println("Car details updated Succesfully.");
				}else {
					System.out.println("Enter valid Data....!!!");
				}
				break;
			case 3:
				System.out.println("Enter new car brand : ");
				String brand = sc.next() ;
				query = "update car set brand =? where id =?  " ;
				preparedStatement = connection.prepareStatement(query) ;
				preparedStatement.setString(1, brand);
				preparedStatement.setInt(2, id);
				result = preparedStatement.executeUpdate() ;
				if(result != 0) {
					System.out.println("Car details updated Succesfully.");
				}else {
					System.out.println("Enter valid Data....!!!");
				}
				break;
			case 4:
				System.out.println("Enter new car fuelType : ");
				String fuelType = sc.next() ;
				query = "update car set name =? where id =?  " ;
				preparedStatement = connection.prepareStatement(query) ;
				preparedStatement.setString(1, fuelType);
				preparedStatement.setInt(2, id);
				result = preparedStatement.executeUpdate() ;
				if(result != 0) {
					System.out.println("Car details updated Succesfully.");
				}else {
					System.out.println("Enter valid Data....!!!");
				}
				break;
			case 5:
				System.out.println("Enter new car price : ");
				double price = sc.nextDouble() ;
				query = "update car set name =? where id =?  " ;
				preparedStatement = connection.prepareStatement(query) ;
				preparedStatement.setDouble(1, price);
				preparedStatement.setInt(2, id);
				result = preparedStatement.executeUpdate() ;
				if(result != 0) {
					System.out.println("Car details updated Succesfully.");
				}else {
					System.out.println("Enter valid Data....!!!");
				}
				break;
			case 6:
				updateCarDetails();
				break;
		
			default:
				System.out.println("Enter Valid Choice...!!!");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}
		
	}
	public void removeCarDetails() {
		try {
			getAllCars();
			openConnection();
			query = "delete from car where id=?" ;
			preparedStatement = connection.prepareStatement(query) ;
			System.out.println("Enter id to delete Car : ");
			preparedStatement.setInt(1,sc.nextInt());
			
			result = preparedStatement.executeUpdate() ;
			if (result >0) {
				System.out.println("Details deleted Succesfully.");
			}
			else {
				System.out.println("Enter Valid Data.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			closeConnection();
		}

	}

}
