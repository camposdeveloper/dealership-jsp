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

@WebServlet("/motorcycle/save")
public final class MotorcycleSaveServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Boolean save = false;
		Motorcycle motorcycle = Motorcycle.extractFromHTTP(request);
		Collection<String> errors = new ArrayList<String>(); 
		if (motorcycle.isValidToSave(errors)) {
			motorcycle = MotorcycleDao.save(motorcycle);
			if (motorcycle != null && motorcycle.getId() != null) {
				save = true;
			}
		}
		
		request.setAttribute("errors", errors);
		request.setAttribute("operation", "save");
		request.setAttribute("save", save);
		request.setAttribute("motorcycle", motorcycle);
		request.getRequestDispatcher("/motorcycle-detalhe.jsp").forward(request, response);
		
	}
	
}
