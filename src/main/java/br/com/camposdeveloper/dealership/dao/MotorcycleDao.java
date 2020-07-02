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
		try {
			Integer id = MotorcycleDao.collection.size() + 1;
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
