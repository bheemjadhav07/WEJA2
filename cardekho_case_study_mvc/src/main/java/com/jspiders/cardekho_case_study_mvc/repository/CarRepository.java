package com.jspiders.cardekho_case_study_mvc.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekho_case_study_mvc.pojo.CarPOJO;

@Repository
public class CarRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;

	private static void openConnection() {

		factory = Persistence.createEntityManagerFactory("bheem");
		manager = factory.createEntityManager();
		transaction = manager.getTransaction();

	}

	private static void closeConnection() {
		if (factory != null) {
			factory.close();
		}
		if (manager != null) {
			manager.close();
		}
		if (transaction != null) {
			if (transaction.isActive()) {
				transaction.commit();
			}
		}
	}

	public CarPOJO addCar(String name, String brand, String fuelType, double price) {
		openConnection();
		transaction.begin();

		CarPOJO pojo = new CarPOJO();
		pojo.setName(name);
		pojo.setBrand(brand);
		pojo.setFuelType(fuelType);
		pojo.setPrice(price);

		manager.persist(pojo);

		transaction.commit();
		closeConnection();
		return pojo;
	}

	public List<CarPOJO> getAllCars() {

		openConnection();
		transaction.begin();

		query = manager.createQuery("from CarPOJO");
		List<CarPOJO> cars = query.getResultList();

		if (cars.isEmpty() == false) {

			transaction.commit();
			closeConnection();
			return cars;

		}
		transaction.commit();
		closeConnection();
		return null;
	}

	public CarPOJO searchCar(int id) {

		openConnection();
		transaction.begin();

		CarPOJO pojo = manager.find(CarPOJO.class, id);

		if (pojo != null) {
			transaction.commit();
			closeConnection();
			return pojo;
		}

		transaction.commit();
		closeConnection();
		return null;
	}

	public CarPOJO updateCar(int id, String name, String brand, String fuelType, double price) {
		openConnection();
		transaction.begin();

		CarPOJO pojo = manager.find(CarPOJO.class, id);

		if (pojo != null) {
			pojo.setName(name);
			pojo.setBrand(brand);
			pojo.setFuelType(fuelType);
			pojo.setPrice(price);

			manager.persist(pojo);
			transaction.commit();
			closeConnection();
			return pojo;
		}

		transaction.commit();
		closeConnection();
		return null;
	}

	public CarPOJO removCar(int id) {

		openConnection();
		transaction.begin();

		CarPOJO pojo = manager.find(CarPOJO.class, id);

		if (pojo != null) {

			manager.remove(pojo);
			transaction.commit();
			closeConnection();
			return pojo;
		}

		transaction.commit();
		closeConnection();
		return null;
	}

}
