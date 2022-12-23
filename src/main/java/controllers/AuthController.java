package controllers;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.User;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.mindrot.jbcrypt.BCrypt;

import services.AuthService;

@WebServlet("/auth")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private RequestDispatcher dispatcher;
	private AuthService authService;

	private String uri;
	private String message;
	private List<String> messages;
	
	private static final String LOGIN_PATH = "/public/views/auth/login.jsp";
	private static final String LOGIN_TITLE = "Login / NASA";
	private static final String REGISTER_PATH = "\"/public/views/auth/register.jsp\"";
	private static final String REGISTER_TITLE = "Register / NASA";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();

		switch(uri) {
			case "/Nasa-JSP/auth/login":
				dispatcher = request.getRequestDispatcher(LOGIN_PATH);
				request.setAttribute("title", LOGIN_TITLE);
				dispatcher.forward(request, response);
				break;
			case "/Nasa-JSP/auth/register":
				dispatcher = request.getRequestDispatcher(REGISTER_PATH);
				request.setAttribute("title", REGISTER_TITLE);
				dispatcher.forward(request, response);
				break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		
		switch(uri) {
			case "/Nasa-JSP/auth/login":
				login(request, response);
				break;
			case "/Nasa-JSP/auth/register":
				register(request, response);
				break;
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		authService = new AuthService();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		if (email == null ||  "".equals(email)) {
			message = "Please provide your e-mail address.";
			messages.add(message);
		}
		
		if (password == null || "".equals(password)) {
			message = "Please provide your password.";
			messages.add(message);
		}
		
		if (messages.size() > 0) {
			request.setAttribute("title", LOGIN_TITLE);
			request.setAttribute("messages", messages);

			if (email != null && !"".equals(email)) {
				request.setAttribute("email", email);
			}
			
			request.getRequestDispatcher(LOGIN_PATH).forward(request, response);
		} else {
			// login the user
		}
	}
	
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		authService = new AuthService();
		messages = new ArrayList<String>();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean isValidEmail = authService.isValidEmail(email);
		
		if (email == null ||  "".equals(email) || !isValidEmail) {
			message = "Please provide a valid e-mail address.";
			messages.add(message);
		}
		
		boolean isStrongPassword = authService.isStrongPassword(password);
		
		if (password == null || "".equals(password) || !isStrongPassword) {
			message = "Please provide a valid, 6 character long strong password.";
			messages.add(message);
		}
		
		if (messages.size() > 0) {
			request.setAttribute("title", REGISTER_TITLE);
			request.setAttribute("messages", messages);
			
			if (email != null && !"".equals(email)) {
				request.setAttribute("email", email);
			}
			
			request.getRequestDispatcher(REGISTER_PATH).forward(request, response);
		} else {
			authService.insertUser(email, password);
			// store in session
			response.sendRedirect("./");
		}
	}
		/*	
		User userExists = authService.userExists(email);

		if (userExists != null) {
			boolean passwordsMatch = this.authService.isValidPassword(password, userExists.getPassword());

			if (!passwordsMatch) {
				message = "Incorrect password.";
				messages.add(message);
				request.setAttribute("title", DEFAULT_TITLE);
				request.setAttribute("messages", messages);
				request.setAttribute("email", email);
				request.getRequestDispatcher("public/views/auth.jsp").forward(request, response);
			} else {
				// store in session
				response.sendRedirect("./");
			}
		}
		*/
}
