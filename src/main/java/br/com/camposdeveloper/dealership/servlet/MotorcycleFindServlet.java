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

@WebServlet("/motorcycle/find")
public final class MotorcycleFindServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pId = request.getParameter("id");
		if(pId != null && !pId.isEmpty()) {
			Motorcycle motorcycle = MotorcycleDao.findById(Integer.parseInt(pId));
			request.setAttribute("motorcycle", motorcycle);
			request.getRequestDispatcher("/motorcycle-detalhe.jsp").forward(request, response);
		} else {
			Collection<Motorcycle> motorcycles = MotorcycleDao.find();
			request.setAttribute("motorcycles", motorcycles);
			request.getRequestDispatcher("/motorcycles.jsp").forward(request, response);
		}
	}

}
