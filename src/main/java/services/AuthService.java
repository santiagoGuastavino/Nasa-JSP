package services;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mindrot.jbcrypt.BCrypt;

import DAO.UserDAO;
import models.User;

public class AuthService {
	private UserDAO userDAO;
	
	private static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	private static final Pattern STRONG_PASSWORD_REGEX =
			Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=_,!¡?¿;:-])(?=\\S+$).{6,}$");

	public User userExists(String email) {
		User user = null;
		userDAO = new UserDAO();

		try {
			user = userDAO.getOne(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	public boolean isValidPassword(String password, String hash) {
		return BCrypt.checkpw(password, hash);
	}
	
	public boolean isValidEmail(String email) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
	}
	
	public boolean isStrongPassword(String password) {
		Matcher matcher = STRONG_PASSWORD_REGEX.matcher(password);
		return matcher.find();
	}
	
	public void insertUser(String email, String password) {
		User newUser = new User();

		newUser.setEmail(email);
		String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt(12));
		newUser.setPassword(hashedPassword);

		try {
			userDAO.insert(newUser);
		} catch (SQLException error) {
			error.printStackTrace();
			throw new Error(error);
		}
	}
}
