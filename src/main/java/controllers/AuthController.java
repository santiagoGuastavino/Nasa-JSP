package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import services.AuthService;
import models.User;

@WebServlet("/auth")
public class AuthController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AuthService authService;
	private HttpSession session;

	private String uri;
	private String message;
	private List<String> messages;
	
	private static final String LOGIN_PATH = "/public/views/auth/login.jsp";
	private static final String LOGIN_TITLE = "Login / Nasa";
	private static final String REGISTER_PATH = "/public/views/auth/register.jsp";
	private static final String REGISTER_TITLE = "Register / Nasa";
	private static final String HOME_PATH = "../";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		
		switch(uri) {
			case "/nasa/auth/login":
				request.setAttribute("title", LOGIN_TITLE);
				request.getRequestDispatcher(LOGIN_PATH)
					.forward(request, response);
				break;
			case "/nasa/auth/register":
				request.setAttribute("title", REGISTER_TITLE);
				request.getRequestDispatcher(REGISTER_PATH)
					.forward(request, response);
				break;
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		uri = request.getRequestURI();
		
		switch(uri) {
			case "/nasa/auth/login":
				login(request, response);
				break;
			case "/nasa/auth/register":
				register(request, response);
				break;
			case "/nasa/auth/logout":
				logout(request, response);
				break;
		}
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		authService = new AuthService();
		session = request.getSession();

		messages = new ArrayList<String>();
		User userToLogIn = null;

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		boolean isValidEmail = authService.isValidEmail(email);

		if (email == null ||  "".equals(email) || !isValidEmail) {
			message = "Please provide your e-mail address.";
			messages.add(message);
		} else {
			userToLogIn = authService.userExists(email);
			
			if (userToLogIn == null) {
				message = "Email not found.";
				messages.add(message);
			} else {
				boolean passwordsMatch = authService.isValidPassword(password, userToLogIn.getPassword());
				
				if (password != null && !"".equals(password) && !passwordsMatch) {
					message = "Invalid credentials.";
					messages.add(message);
				}
			}
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
			session.setAttribute("userEmail", email);
			response.sendRedirect(HOME_PATH);
		}
	}
	
	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		authService = new AuthService();
		session = request.getSession();

		messages = new ArrayList<String>();
		User userExists = null;

		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		if (firstName == null || "".equals(firstName)) {
			message = "Please provide your name.";
			messages.add(message);
		}
		
		if (lastName == null || "".equals(lastName)) {
			message = "Please provide your last name.";
			messages.add(message);
		}
		
		boolean isValidEmail = authService.isValidEmail(email);
		
		if (email == null ||  "".equals(email) || !isValidEmail) {
			message = "Please provide a valid e-mail address.";
			messages.add(message);
		} else {
			userExists = authService.userExists(email);
			
			if (userExists != null) {
				message = "Email taken.";
				messages.add(message);
			}
		}
		
		boolean isStrongPassword = authService.isStrongPassword(password);
		
		if (password == null || "".equals(password) || !isStrongPassword) {
			message = "Password must be at least 6 characters long.";
			messages.add(message);
		}
		
		if (messages.size() > 0) {
			request.setAttribute("title", REGISTER_TITLE);
			request.setAttribute("messages", messages);
			
			if (email != null && !"".equals(email)) {
				request.setAttribute("email", email);
			}
			
			if (firstName != null && !"".equals(firstName)) {
				request.setAttribute("firstName", firstName);
			}
			
			if (lastName != null && !"".equals(lastName)) {
				request.setAttribute("lastName", lastName);
			}
			
			request.getRequestDispatcher(REGISTER_PATH)
				.forward(request, response);
		} else {
			authService.insertUser(email, password, firstName, lastName);
			session.setAttribute("userEmail", email);
			response.sendRedirect(HOME_PATH);
		}
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session.invalidate();
		response.sendRedirect(HOME_PATH);
	}
}
