package com.jspiders.cardekho_case_study_rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekho_case_study_rest.pojo.CarPOJO;
import com.jspiders.cardekho_case_study_rest.repository.CarRepository;

@Service
public class CarService {

	@Autowired
	private CarRepository repository ;
	public CarPOJO addCar(CarPOJO pojo) {
		
		CarPOJO car = repository.addCar(pojo) ;
		return car;
	}
	public CarPOJO searchCar(int id) {
		CarPOJO car = repository.searchCar(id) ;
		return car;
	}
	public List<CarPOJO> searchAllCar() {
		
		List<CarPOJO> cars = repository.searchAllCar();
		return cars;
	}
	public CarPOJO updateCar(CarPOJO pojo) {
		
		CarPOJO car = repository.updateCar(pojo) ;
		return car;
	}
	public CarPOJO removeCar(int id) {
		CarPOJO car = repository.removeCar(id) ;
		return car;
	}

}
