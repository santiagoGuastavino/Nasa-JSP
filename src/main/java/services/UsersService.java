package services;

import java.sql.SQLException;

import DAO.UserDAO;
import models.User;

public class UsersService {
	private UserDAO userDAO;
	
	public User getOne(String email) {
		userDAO = new UserDAO();
		User user = null;
		
		try {
			user = userDAO.getOne(email);
		} catch (SQLException error) {
			error.printStackTrace();
		}

		return user;
	}
}
