package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import factories.ConnectionFactory;
import models.Blog;

public class BlogDAO implements DAO<Blog> {
	@Override
	public void insert(Blog model) throws SQLException {
		return;
	}

	@Override
	public void update(Blog model) throws SQLException {
		return;
	}

	@Override
	public void delete(int id) throws SQLException {
		return;
	}

	@Override
	public Blog getById(int id) throws SQLException {
		return null;
	}

	@Override
	public Blog getOne(String field) throws SQLException {
		return null;
	}
	
	@Override
	public List<Blog> getByField(String field) throws SQLException {
		/*
		List<Blog> blogs = new ArrayList<Blog>();
		
		Connection connection = ConnectionFactory.getConnection();
		
		String rawQuery = "select * from blogs";
		rawQuery += "where categoryId ="
		*/
	}

	@Override
	public List<Blog> getAll() throws SQLException {
		List<Blog> blogs = new ArrayList<Blog>();
		
		Connection connection = ConnectionFactory.getConnection();
		
		String rawQuery = "select * from blogs";
		
		PreparedStatement preparedStatement = connection.prepareStatement(rawQuery);
		
		ResultSet result = preparedStatement.executeQuery();
		// i have to make inner join for the category
		while (result.next()) {
			int id = result.getInt("id");
			String title = result.getString("title");
			String image = result.getString("image");
			int year = result.getInt("year");
			int collectionId = result.getInt("collection_id");
			
			blogs.add(new Blog(id, title, image, year, collectionId));
		}
		
		return blogs;
	}
}
