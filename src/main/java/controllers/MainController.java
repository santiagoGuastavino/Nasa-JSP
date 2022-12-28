package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import services.BlogsService;
import models.Blog;

@WebServlet("/")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BlogsService blogsService;
	
	private static final String TITLE = "Home / NASA";
	private static final String PATH = "public/views/index.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		blogsService = new BlogsService();
		
		List<Blog> blogs = blogsService.getAll();
		
		request.setAttribute("title", TITLE);
		request.setAttribute("blogs", blogs);
		request.getRequestDispatcher(PATH)
			.forward(request, response);
	}
}
