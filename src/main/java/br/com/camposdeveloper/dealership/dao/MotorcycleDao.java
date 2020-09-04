package br.com.camposdeveloper.dealership.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import br.com.camposdeveloper.dealership.model.Motorcycle;

public final class MotorcycleDao {
	
	private MotorcycleDao () {}
	
	private static Collection<Motorcycle> collection = new ArrayList<>();
	private static Map<Integer, Motorcycle> map = new HashMap<>();
	
	public static Motorcycle save(Motorcycle motorcycle) {
		if (motorcycle == null) throw new IllegalArgumentException("Motorcycle is null");
		if (motorcycle.getId() == null) {
			return MotorcycleDao.create(motorcycle);
		} else {
			Motorcycle registeredMotorcycle = MotorcycleDao.findById(motorcycle.getId());
			if (registeredMotorcycle == null) throw new IllegalArgumentException("Motorcycle not found.");
			registeredMotorcycle.setLicensePlate(motorcycle.getLicensePlate());
			registeredMotorcycle.setManufacturer(motorcycle.getManufacturer());
			registeredMotorcycle.setModel(motorcycle.getModel());
			registeredMotorcycle.setYear(motorcycle.getYear());
			return registeredMotorcycle;
		}
	}
	
	private static Motorcycle create(Motorcycle motorcycle) {
		try {
			Integer id = MotorcycleDao.collection.size() + 1;
			boolean containsKey = map.containsKey(id);
			while (containsKey) {
				containsKey = map.containsKey(++id);
			}
			motorcycle.setId(id);
			collection.add(motorcycle);
			map.put(id, motorcycle);
			return motorcycle;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static Collection<Motorcycle> find() {
		return MotorcycleDao.collection;
	}
	
	public static Motorcycle find(Integer id) {
		return MotorcycleDao.map.get(id);
	}

	public static Boolean delete(Integer id) {
		try {
			MotorcycleDao.map.remove(id);
			MotorcycleDao.collection.clear();
			MotorcycleDao.collection.addAll(MotorcycleDao.map.values());
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
