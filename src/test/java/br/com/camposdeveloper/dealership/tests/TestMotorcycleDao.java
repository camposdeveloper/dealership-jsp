package br.com.camposdeveloper.dealership.tests;

import java.util.Collection;

import br.com.camposdeveloper.dealership.dao.MotorcycleDao;
import br.com.camposdeveloper.dealership.model.Motorcycle;

public class TestMotorcycleDao {

	public static void main(String[] args) {
		
		System.out.println("Save motorcycle 1");
		Motorcycle motorcycle1 = new Motorcycle("Dafra", "Next 250", 2013, "WCS2019");
		motorcycle1 = MotorcycleDao.save(motorcycle1);
		
		System.out.println("Save motorcycle 2");
		Motorcycle motorcycle2 = new Motorcycle("Kawasaki", "ER-6n", 2015, "WCS2020");
		motorcycle2 = MotorcycleDao.save(motorcycle2);
		
		System.out.println("Find motorcycle with id 1...");
		Motorcycle findMotorcycle1 = MotorcycleDao.find(motorcycle1.getId());
		System.out.println(findMotorcycle1);
		
		System.out.println("Find motorcycle with id 2...");
		Motorcycle findMotorcycle2 = MotorcycleDao.find(motorcycle2.getId());
		System.out.println(findMotorcycle2);
		
		System.out.println("Find all motorcycles...");
		Collection<Motorcycle> collection = MotorcycleDao.find();
		for (Motorcycle m : collection) {
			System.out.println(m);
		}

	}
	
}
