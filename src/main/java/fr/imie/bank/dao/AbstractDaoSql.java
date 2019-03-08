package fr.imie.bank.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import fr.imie.bank.exceptions.DaoException;
import fr.imie.bank.utils.Constants;

public abstract class AbstractDaoSql<T> {


  /**
   * Main logger
   */
  private final static Logger LOG = Logger.getLogger(AbstractDao.class.getName());

  // creation de la connexion
  protected abstract T toObject(ResultSet resultSet) throws SQLException;

  /**
   * Creates a connection to the database
   * 
   * @return
   * @throws DaoException
   */
  public Connection getConnection() throws DaoException {
    try {

      // Connection's instanciation
      final Connection connection =
          DriverManager.getConnection(Constants.DB_URL, Constants.DB_USER, Constants.DB_PASSWORD);
      return connection;
    } catch (SQLException e) {
      LOG.severe("Error while connecting to the databse : " + e);
      throw new DaoException();
    }
  }

}
