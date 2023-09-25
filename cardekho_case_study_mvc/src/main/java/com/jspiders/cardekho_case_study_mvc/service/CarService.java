package com.jspiders.cardekho_case_study_mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekho_case_study_mvc.pojo.CarPOJO;
import com.jspiders.cardekho_case_study_mvc.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository;

	public CarPOJO addCar(String name, String brand, String fuelType, double price) {
		CarPOJO pojo = repository.addCar(name, brand, fuelType, price);
		return pojo;
	}

	public List<CarPOJO> getAllCars() {
		List<CarPOJO> cars = repository.getAllCars();
		return cars;
	}

	public CarPOJO searchCar(int id) {
		CarPOJO pojo = repository.searchCar(id);
		return pojo;
	}

	public CarPOJO updateCar(int id, String name, String brand, String fuelType, double price) {
		CarPOJO pojo = repository.updateCar(id, name, brand, fuelType, price);
		return pojo;
	}

	public CarPOJO removeCar(int id) {
		CarPOJO pojo = repository.removCar(id);
		return pojo;
	}

}
