package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import factories.ConnectionFactory;
import models.User;

public class UserDAO implements DAO<User> {
	@Override
	public void insert(User user) throws SQLException {
		Connection connection = ConnectionFactory.getConnection();
		
		String rawQuery = "insert into users";
		rawQuery += " (email, password)";
		rawQuery += " values (?, ?);";
		
		PreparedStatement preparedStatement = connection.prepareStatement(rawQuery);
		
		preparedStatement.setString(1, user.getEmail());
		preparedStatement.setString(2, user.getPassword());
		
		preparedStatement.executeUpdate();
		
		connection.close();
	}

	@Override
	public void update(User model) throws SQLException {

	}

	@Override
	public void delete(int id) throws SQLException {

	}

	@Override
	public User getById(int id) throws SQLException {
		return null;
	}
	
	@Override
	public User getOne(String email) throws SQLException {
		User user = null;
		
		Connection connection = ConnectionFactory.getConnection();
		
		String rawQuery = "select email, password from users";
		rawQuery += " where email =";
		rawQuery += " (?);";
		
		PreparedStatement preparedStatement = connection.prepareStatement(rawQuery);
		
		preparedStatement.setString(1, email);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			String password = resultSet.getString("password");
			user = new User(email, password);
		}
		
		return user;
	}

	@Override
	public List<User> getAll() throws SQLException {
		return null;
	}
}
