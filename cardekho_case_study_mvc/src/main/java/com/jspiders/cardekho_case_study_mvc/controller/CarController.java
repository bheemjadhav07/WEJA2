package com.jspiders.cardekho_case_study_mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.jspiders.cardekho_case_study_mvc.pojo.AdminPOJO;
import com.jspiders.cardekho_case_study_mvc.pojo.CarPOJO;
import com.jspiders.cardekho_case_study_mvc.service.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService service;

	@GetMapping("/home")
	public String home(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Home";
		}
		map.addAttribute("msg", "Session inactive. Please Login to proceed...!!!");
		return "Login";
	}

	@GetMapping("/add")
	public String addPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.getAllCars();
			map.addAttribute("cars", cars);
			return "Add";
		}
		map.addAttribute("msg", "Session inactive. Please Login to proceed...!!!");
		return "Login";
	}

	// Add Car Controller
	@PostMapping("/add")
	public String addStudent(@RequestParam String name, @RequestParam String brand, @RequestParam String fuelType,
			@RequestParam double price, @SessionAttribute(name = "login", required = false) AdminPOJO admin,
			ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.addCar(name, brand, fuelType, price);

			// Success
			if (pojo != null) {
				List<CarPOJO> cars = service.getAllCars();
				map.addAttribute("cars", cars);
				map.addAttribute("msg", "Data inserted Successfully.");
				return "Add";
			}
			// Failure
			List<CarPOJO> cars = service.getAllCars();
			map.addAttribute("cars", cars);
			map.addAttribute("msg", "Data not inserted.");
			return "Add";
		}
		map.addAttribute("msg", "Session inactive. Please Login to proceed...!!!");
		return "Login";
	}

	@GetMapping("/remove")
	public String removePage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.getAllCars();
			if (cars.isEmpty() == false) {
				map.addAttribute("cars", cars);
			}
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive. Please Login to proceed...!!!");
		return "Login";
	}

	@PostMapping("/remove")
	public String removeStudent(@RequestParam int id,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {

		if (admin != null) {

			CarPOJO pojo = service.removeCar(id);
			// Success
			if (pojo != null) {
				map.addAttribute("msg", "Data removed Successfully...!!");
			}
			// Failure
			else {
				map.addAttribute("msg", "Data does not exists...!!");
			}
			List<CarPOJO> cars = service.getAllCars();
			map.addAttribute("cars", cars);
			return "Remove";
		}
		map.addAttribute("msg", "Session inactive. Please Login to proceed...!!!");
		return "Login";
	}

	@GetMapping("/search")
	public String searchPage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			return "Search";
		}
		map.addAttribute("msg", "Session inactive. Please Login to proceed...!!!");
		return "Login";
	}

	@PostMapping("/search")
	public String searchStudent(@RequestParam int id,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.searchCar(id);
			if (pojo != null) {
				map.addAttribute("car", pojo);
				map.addAttribute("msg", "Car Data Found....!!!");
				return "Search";
			}
			map.addAttribute("msg", "Car Data not Found....!!!");
			return "Search";
		}
		map.addAttribute("msg", "Session inactive. Please Login to proceed...!!!");
		return "Login";
	}

	@GetMapping("/update")
	public String updatePage(@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			List<CarPOJO> cars = service.getAllCars();
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Please Login to proceed...!!!");
		return "Login";
	}

	@PostMapping("/update")
	public String getStudent(@RequestParam int id, @SessionAttribute(name = "login", required = false) AdminPOJO admin,
			ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.searchCar(id);

			if (pojo != null) {
				map.addAttribute("car", pojo);
				return "Update";
			}
			map.addAttribute("msg", "Student Data not Found....!!!");
			List<CarPOJO> cars = service.getAllCars();
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Please Login to proceed...!!!");
		return "Login";
	}

	@PostMapping("/updateCar")
	public String updateStudent(@RequestParam int id, @RequestParam String name, @RequestParam String brand,
			@RequestParam String fuelType, @RequestParam double price,
			@SessionAttribute(name = "login", required = false) AdminPOJO admin, ModelMap map) {
		if (admin != null) {
			CarPOJO pojo = service.updateCar(id, name, brand, fuelType, price);

			// Success
			if (pojo != null) {

				map.addAttribute("msg", "Car data updated successfully...!!");
				List<CarPOJO> cars = service.getAllCars();
				map.addAttribute("cars", cars);
				return "Update";

			}
			// Failure
			map.addAttribute("msg", "Car data not updated...!!");
			List<CarPOJO> cars = service.getAllCars();
			map.addAttribute("cars", cars);
			return "Update";
		}
		map.addAttribute("msg", "Session inactive. Please Login to proceed...!!!");
		return "Login";
	}

}
