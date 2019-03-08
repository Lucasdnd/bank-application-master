package fr.imie.bank.dao.person;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import fr.imie.bank.dao.AbstractDaoSql;
import fr.imie.bank.exceptions.DaoException;
import fr.imie.bank.model.Person;

public class PersonDaoSqlJdbcImpl extends AbstractDaoSql<Person> implements PersonDao {

	private final static Logger LOG = Logger.getLogger(PersonDaoSqlJdbcImpl.class.getName());

	private final static String FIND_ALL = "SELECT * FROM PERSON";

	private final static String FIND_ONE = "SELECT * FROM PERSON WHERE ID = ?";

	private static final String DEL_ONE = "DELETE FROM PERSON WHERE ID = ?";

	private static final String DEL_ALL = "DELETE * FROM PERSON";

	@Override
	public List<Person> findAll() {

		List<Person> persons = new ArrayList<>();

		try (final PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_ALL);) {

			try (final ResultSet resultSet = preparedStatement.executeQuery();) {
				while (resultSet.next()) {

					// Creating a person
					final Person person = toObject(resultSet);

					// Adding the person to the collection to return
					persons.add(person);
				}

			}
			LOG.info("Successfully connected");

		} catch (SQLException sqlException) {
			LOG.severe("Error while reaching the database : " + sqlException);
			return null;
		} catch (DaoException daoException) {
			LOG.severe("Error while creating database connection " + daoException);
			return null;
		}
		return persons;
	}

	@Override
	public Person findById(int id) {

		Person person = null;

		try (final PreparedStatement preparedStatement = getConnection().prepareStatement(FIND_ONE);) {

			preparedStatement.setInt(1, id);

			try (final ResultSet resultSet = preparedStatement.executeQuery();) {
				while (resultSet.next()) {
					person = toObject(resultSet);
				}

			}
			LOG.info("Successfully connected");

		} catch (SQLException sqlException) {
			LOG.severe("Error while reaching the database : " + sqlException);
		} catch (DaoException daoException) {
			LOG.severe("Error while creating database connection " + daoException);
		}
		return person;
	}

	@Override
	public void save(Person entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void saveAll(List<Person> entities) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAll() throws SQLException, DaoException {
		LOG.info("Deleting ALL Persons");
		try (final PreparedStatement preparedStatement = getConnection().prepareStatement(DEL_ALL);) {

			preparedStatement.executeQuery();
			LOG.info("Successfully deleted");
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) throws SQLException, DaoException {
		try (final PreparedStatement preparedStatement = getConnection().prepareStatement(DEL_ONE);) {

			preparedStatement.setInt(1, id);

			preparedStatement.executeUpdate();
			LOG.info("Successfully deleted");
		}

	}

	@Override
	protected Person toObject(ResultSet resultSet) throws SQLException {
		final Person person = new Person();
		// Retrieving data
		final Integer personId = resultSet.getInt("ID");
		final String firstName = resultSet.getString("FIRSTNAME");
		final String lastName = resultSet.getString("LASTNAME");
		final String email = resultSet.getString("email");
		final Date birthDate = resultSet.getDate("BIRTHDATE");

		// Creating a person
		person.setId(personId);
		person.setFirstName(firstName);
		person.setLastName(lastName);
		person.setEmail(email);

		if (birthDate != null) {
			person.setBirthDate(birthDate.toLocalDate());
		}
		return person;
	}

	// TODO utiliser ResultSet et autres elements jdbc

}
