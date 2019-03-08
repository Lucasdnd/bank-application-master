package fr.imie.bank.dao;

import java.sql.SQLException;
import java.util.List;

import fr.imie.bank.exceptions.DaoException;

public interface Dao<T> {

	public List<T> findAll();

	public T findById(int id);

	public void save(T entity) throws DaoException;

	public void saveAll(List<T> entities);

	public void deleteAll() throws SQLException, DaoException;

	public void deleteById(int id) throws SQLException, DaoException;

}
