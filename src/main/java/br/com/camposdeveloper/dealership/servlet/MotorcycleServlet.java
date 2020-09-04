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
			Motorcycle motorcycle = Motorcycle.extractFromHTTP(request);
			Collection<String> errors = new ArrayList<String>();
			if (motorcycle.isValidToSave(errors)) {
				motorcycle = MotorcycleDao.save(motorcycle);
				if (motorcycle != null && motorcycle.getId() != null) {
					save = true;
				}
			} else {
				request.setAttribute("errors", errors);
			}
			request.setAttribute("save", save);
		}
		Collection<Motorcycle> motorcycles = MotorcycleDao.find();
		request.setAttribute("motorcycles", motorcycles);
		request.getRequestDispatcher("/motorcycle.jsp").forward(request, response);
	}

}
