package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.User;
import services.UsersService;

import java.io.IOException;

@WebServlet("/user")
public class UsersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private UsersService usersService;
	private HttpSession session;
	
	private String valueInSession;
	private String title;
	
	private static final String PATH = "/public/views/user.jsp";
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		usersService = new UsersService();
		session = request.getSession();
		
		if (session != null) {
			valueInSession = (String) request.getSession(false).getAttribute("userEmail");
		}

		if (valueInSession == null || "".equals(valueInSession)) {
			response.sendRedirect("./");
		} else {
			User user = usersService.getOne(valueInSession);
			if (user != null) {
				String image = user.getImage();
				String firstName = user.getFirstName();
				String lastName = user.getLastName();
				String email = user.getEmail();
				
				title = firstName + " / Nasa";

				request.setAttribute("title", title);
				request.setAttribute("image", image);
				request.setAttribute("firstName", firstName);
				request.setAttribute("lastName", lastName);
				request.setAttribute("email", email);
				request.getRequestDispatcher(PATH)
					.forward(request, response);
			} else {
				throw new Error("Internal server error");
			}
		}
	}
}
