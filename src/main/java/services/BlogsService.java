package services;

import java.sql.SQLException;
import java.util.List;

import models.Blog;
import DAO.BlogDAO;

public class BlogsService {
	private BlogDAO blogDAO;

	public List<Blog> getAll() {
		blogDAO = new BlogDAO();

		List<Blog> blogs = null;

		try {
			blogs = blogDAO.getAll();
		} catch (SQLException error) {
			error.printStackTrace();
		}
		
		return blogs;
	}
}
