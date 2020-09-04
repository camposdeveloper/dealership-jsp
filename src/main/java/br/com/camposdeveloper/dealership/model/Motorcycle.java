package br.com.camposdeveloper.dealership.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

public class Motorcycle {
	
	private Integer id;
	private String manufacturer;
	private String model;
	private Integer year;
	private String licensePlate;
	
	public Motorcycle(Integer id, String manufacturer, String model, Integer year, String licensePlate) {
		super();
		this.id = id;
		this.manufacturer = manufacturer;
		this.model = model;
		this.year = year;
		this.licensePlate = licensePlate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}

	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
		result = prime * result + ((manufacturer == null) ? 0 : manufacturer.hashCode());
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Motorcycle other = (Motorcycle) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (licensePlate == null) {
			if (other.licensePlate != null)
				return false;
		} else if (!licensePlate.equals(other.licensePlate))
			return false;
		if (manufacturer == null) {
			if (other.manufacturer != null)
				return false;
		} else if (!manufacturer.equals(other.manufacturer))
			return false;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Motorcycle [id=" + id + ", manufacturer=" + manufacturer + ", model=" + model + ", year=" + year
				+ ", licensePlate=" + licensePlate + "]";
	}
	
	public static Motorcycle extractFromHTTP(HttpServletRequest request) {
		String pId = request.getParameter("id");
		Integer id = pId == null || pId.isEmpty() ? null : Integer.valueOf(pId); 
		String manufacturer = request.getParameter("manufacturer");
		String model = request.getParameter("model");
		String pYear = request.getParameter("year");
		Integer year = pYear == null || pYear.isEmpty() ? null : Integer.valueOf(pYear);
		String licensePlate = request.getParameter("licensePlate");
		return new Motorcycle(id, manufacturer, model, year, licensePlate);
	}
	
	public boolean isValidToSave() {
		return this.isValidToSave(new ArrayList<String>());
	}
	
	public boolean isValidToSave(Collection<String> errors) {
		if(errors == null) throw new IllegalArgumentException("Collection is null");
		errors.clear();
		if(this.manufacturer == null || this.manufacturer.isEmpty()) errors.add("Manufacturer is null!");
		if(this.model == null || this.model.isEmpty()) errors.add("Model is null!");
		if(this.year == null) errors.add("Year is null!");
		if(this.licensePlate == null || this.licensePlate.isEmpty()) errors.add("License Plate is null!");
		return errors.isEmpty();
	}
	
}
