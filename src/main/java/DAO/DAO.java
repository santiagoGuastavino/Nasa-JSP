package DAO;

import java.sql.SQLException;
import java.util.List;

public interface DAO<T> {
	public void insert(T model) throws SQLException;
	
	public void update(T model) throws SQLException;
	
	public void delete(int id) throws SQLException;
	
	public T getById(int id) throws SQLException;
	
	public T getOne(String field) throws SQLException;
	
	public List<T> getByField(String field) throws SQLException;
	
	public List<T> getAll() throws SQLException;
}
