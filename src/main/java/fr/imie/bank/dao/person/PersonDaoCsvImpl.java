package fr.imie.bank.dao.person;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import fr.imie.bank.dao.AbstractDaoCsv;
import fr.imie.bank.exceptions.DaoException;
import fr.imie.bank.exceptions.UtilsException;
import fr.imie.bank.model.Person;
import fr.imie.bank.utils.FileUtils;

public class PersonDaoCsvImpl extends AbstractDaoCsv<Person> implements PersonDao {

	private final static Logger LOG = Logger.getLogger(PersonDaoCsvImpl.class.getName());

	private final static String FILE_NAME = "./persons.csv";

	@Override
	public List<Person> findAll() {
		List<Person> persons = new ArrayList<>();
		List<String> fileContent = FileUtils.readFile(FILE_NAME);
		if (fileContent != null) {
			for (String content : fileContent) {
				persons.add(toObject(content));
			}
		}
		return persons;
	}

	@Override
	public Person findById(int id) {
		List<Person> persons = this.findAll();
		if (persons != null) {
			return persons.stream() //
					.filter(p -> (p.getId() != null) && (p.getId() == id)) //
					.findFirst().get();
		}
		/*
		 * for (Person person : persons) { if ((person.getId() != null) &&
		 * (person.getId() == id)) { return person; } }
		 */
		return null;
	}

	@Override
	public void save(Person entity) throws DaoException {
		try {
			final String content = this.toString(entity);
			FileUtils.appendToFile(FILE_NAME, content);
		} catch (UtilsException e) {
			LOG.log(Level.SEVERE, "Error while calling FileUtils.appendToFile");
			throw new DaoException();
		}

	}

	@Override
	public void saveAll(List<Person> entities) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteById(int id) {

		// TODO Auto-generated method stub

	}

	@Override
	protected Person toObject(String text) {
		final Person person = new Person();

		if ((text != null) && (!text.isEmpty())) {
			String[] parsedText = text.split(";");
			if ((parsedText != null) && (parsedText.length == 5)) {
				String id = parsedText[0];
				if ((id != null) && (!id.isEmpty())) {
					person.setId(Integer.valueOf(parsedText[0]));
				}
				person.setFirstName(parsedText[1]);
				person.setLastName(parsedText[2]);
				person.setEmail(parsedText[3]);
				String date = parsedText[4];
				if (date != null) {
					person.setBirthDate(LocalDate.parse(date));
				}

			}
		}
		return person;
	}

	@Override
	protected String toString(Person entity) {
		final StringBuilder sb = new StringBuilder();
		sb.append((entity.getId() != null) ? entity.getId() : "");
		sb.append(";");
		sb.append(entity.getFirstName());
		sb.append(";");
		sb.append(entity.getLastName());
		sb.append(";");
		sb.append(entity.getEmail());
		sb.append(";");
		sb.append((entity.getBirthDate() != null) ? entity.getBirthDate() : "");

		return sb.toString();
	}

	// TODO utiliser FileWriter et BufferedReader/FileReader

}
