package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/blogs")
public class BlogsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String TITLE = "Home / NASA";
	private static final String PATH = "public/views/index.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title", TITLE);
		request.getRequestDispatcher(PATH)
			.forward(request, response);
	}
}
