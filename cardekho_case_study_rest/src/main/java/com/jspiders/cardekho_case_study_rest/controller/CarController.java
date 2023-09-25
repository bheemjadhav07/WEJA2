package com.jspiders.cardekho_case_study_rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekho_case_study_rest.pojo.CarPOJO;
import com.jspiders.cardekho_case_study_rest.response.CarResponse;
import com.jspiders.cardekho_case_study_rest.service.CarService;

@RestController
public class CarController {

	@Autowired
	private CarService service;

	@PostMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> addCar(@RequestBody CarPOJO pojo) {

		CarPOJO car = service.addCar(pojo);

		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car details added successfully.", car, null),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car details not added.", null, null),
				HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping(path = "/search/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> searchCar(@PathVariable int id) {

		CarPOJO car = service.searchCar(id);

		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car details found successfully.", car, null),
					HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car details not found.", null, null),
				HttpStatus.NOT_FOUND);
	}

	@GetMapping(path = "/searchAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> searchAllCar() {

		List<CarPOJO> cars = service.searchAllCar();

		if (cars.isEmpty() == false) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car details found successfully.", null, cars),
					HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car details not found.", null, null),
				HttpStatus.NOT_FOUND);
	}

	@PutMapping(path = "/update", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> updateCar(@RequestBody CarPOJO pojo) {

		CarPOJO car = service.updateCar(pojo);

		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car details updated successfully.", car, null),
					HttpStatus.ACCEPTED);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car details not updated.", null, null),
				HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path = "/remove/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CarResponse> removeCar(@PathVariable int id) {

		CarPOJO car = service.removeCar(id);

		if (car != null) {
			return new ResponseEntity<CarResponse>(new CarResponse("Car details removed successfully.", car, null),
					HttpStatus.FOUND);
		}
		return new ResponseEntity<CarResponse>(new CarResponse("Car details not removed.", null, null),
				HttpStatus.BAD_REQUEST);
	}

}
