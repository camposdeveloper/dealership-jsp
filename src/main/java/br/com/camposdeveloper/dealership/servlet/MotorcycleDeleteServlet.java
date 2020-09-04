package br.com.camposdeveloper.dealership.servlet;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.camposdeveloper.dealership.dao.MotorcycleDao;
import br.com.camposdeveloper.dealership.model.Motorcycle;

@WebServlet("/motorcycle/delete")
public final class MotorcycleDeleteServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String motorcycleId = request.getParameter("id");
		if (motorcycleId != null && !motorcycleId.isEmpty()) {
			Boolean delete = MotorcycleDao.delete(Integer.valueOf(motorcycleId));
			request.setAttribute("delete", delete);
		} else {
			request.setAttribute("delete", false);
			request.setAttribute("msg", "Id is null!");
		}
		request.setAttribute("operation", "delete");
		Collection<Motorcycle> motorcycles = MotorcycleDao.find();
		request.setAttribute("motorcycles", motorcycles);
		request.getRequestDispatcher("/motorcycles.jsp").forward(request, response);
	}
	

}
