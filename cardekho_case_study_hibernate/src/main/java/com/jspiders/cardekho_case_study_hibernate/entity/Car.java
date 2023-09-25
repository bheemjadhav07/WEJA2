package com.jspiders.cardekho_case_study_hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String name ;
	private  String model ;
	private String brand ;
	private String fuelType ;
	private double price ;

}
