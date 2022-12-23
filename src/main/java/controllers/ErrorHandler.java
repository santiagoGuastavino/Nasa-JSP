package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatcher;
	private String title;
	private Throwable throwable;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			throwable = (Throwable) request.getAttribute("javax.servlet.error.exception");
			Throwable cause = throwable.getCause();
			String message = throwable.getMessage();
			String anotherMessage = throwable.getLocalizedMessage();
			String toString = throwable.toString();

			System.out.println(throwable);
			System.out.println(cause);
			System.out.println(message);
			System.out.println(anotherMessage);
			System.out.println(toString);
			
			title = "Error / NASA";
			dispatcher = request.getRequestDispatcher("/public/views/error.jsp");
			request.setAttribute("title", title);
			request.setAttribute("error", throwable);
			request.setAttribute("cause", cause);
			request.setAttribute("message", message);
			request.setAttribute("anotherMessage", anotherMessage);
			request.setAttribute("toString", toString);
			dispatcher.forward(request, response);
	}
}

