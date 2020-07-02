package br.com.camposdeveloper.dealership.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.camposdeveloper.dealership.dao.MotorcycleDao;
import br.com.camposdeveloper.dealership.model.Motorcycle;

@WebServlet("/motorcycle")
public final class MotorcycleServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("operation", "find");
		Collection<Motorcycle> motorcycles = MotorcycleDao.find();
		request.setAttribute("motorcycles", motorcycles);
		request.getRequestDispatcher("/motorcycle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String motorcycleId = request.getParameter("motorcycleIdToDelete");
		if (motorcycleId != null && !motorcycleId.isEmpty()) {
			request.setAttribute("operation", "delete");
			Boolean delete = MotorcycleDao.delete(Integer.valueOf(motorcycleId));
			request.setAttribute("delete", delete);
		} else {
			request.setAttribute("operation", "save");
			Boolean save = false;
			Motorcycle motorcycle = this.extractMotorcycle(request);
			if (motorcycle != null) {
				motorcycle = MotorcycleDao.save(motorcycle);
				if (motorcycle != null && motorcycle.getId() != null) {
					save = true;
				}
			}
			request.setAttribute("save", save);
		}
		Collection<Motorcycle> motorcycles = MotorcycleDao.find();
		request.setAttribute("motorcycles", motorcycles);
		request.getRequestDispatcher("/motorcycle.jsp").forward(request, response);
	}
	
	private Motorcycle extractMotorcycle(HttpServletRequest request) {
		
		String manufacturer = request.getParameter("manufacturer");
		String model = request.getParameter("model");
		String year = request.getParameter("year");
		String licensePlate = request.getParameter("licensePlate");
		
		Collection<String> msgsErro = new ArrayList<>();
		
		if(manufacturer == null || manufacturer.isEmpty()) {
			msgsErro.add("Manufacturer is null!");
		}
		
		if(model == null || model.isEmpty()) {
			msgsErro.add("Model is null!");
		}

		if(year == null || year.isEmpty()) {
			msgsErro.add("Year is null!");
		}
		
		if(licensePlate == null || licensePlate.isEmpty()) {
			msgsErro.add("License Plate is null!");
		}
		
		request.setAttribute("msgsErro", msgsErro);
		
		return msgsErro.isEmpty() ? new Motorcycle(manufacturer, model, Integer.valueOf(year), licensePlate) : null;
		
	}

}
