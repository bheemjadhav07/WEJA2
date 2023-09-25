package com.jspiders.cardekho_case_study_rest.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekho_case_study_rest.pojo.AdminPOJO;

@Repository
public class AdminRepository {

	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;

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
				transaction.rollback();
			}
		}
	}

	public AdminPOJO createAccount(AdminPOJO pojo) {

		openConnection();
		transaction.begin();

		manager.persist(pojo);

		transaction.commit();
		closeConnection();
		return pojo;
	}

	public AdminPOJO login(AdminPOJO pojo) {

		openConnection();
		transaction.begin();

		AdminPOJO admin = manager.find(AdminPOJO.class, pojo.getUsername());

		if (pojo.getPassword().equals(admin.getPassword())) {
			transaction.commit();
			closeConnection();
			return admin;
		}

		transaction.commit();
		closeConnection();
		return null;
	}

}
