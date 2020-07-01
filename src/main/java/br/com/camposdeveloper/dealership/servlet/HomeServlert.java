package br.com.camposdeveloper.dealership.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/home")
public class HomeServlert extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<body>");
		sb.append("<div align='center' >");
		sb.append("<span>HomeServlet!</span>");
		sb.append("</div>");
		sb.append("</body>");
		sb.append("</html>");
		
		PrintWriter writer = response.getWriter();
		writer.write(sb.toString());
		writer.flush();
		writer.close();
		
	}


}
