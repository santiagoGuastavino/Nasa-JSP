package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String title;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			renderHome(request, response);
		} catch(IOException | ServletException error) {
			error.printStackTrace();
			throw new ServletException(error);
		}
		
	}
	
	private void renderHome(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		title = "Home / NASA";

		RequestDispatcher dispatcher = request.getRequestDispatcher("public/views/index.jsp");
		request.setAttribute("title", title);
		dispatcher.forward(request, response);
	}
}
