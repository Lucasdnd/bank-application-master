package fr.imie.bank;

import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import fr.imie.bank.dao.person.PersonDao;
import fr.imie.bank.dao.person.PersonDaoSqlJdbcImpl;
import fr.imie.bank.model.Person;

public class MainConsole {

  private final static Logger LOG = Logger.getLogger(MainConsole.class.getName());

  public static void main(String[] args) {
    LOG.info("Starting application");



    PersonDao dao = new PersonDaoSqlJdbcImpl();

    List<Person> persons = dao.findAll();

    System.out.println("Please enter an id : ");
    Scanner scanner = new Scanner(System.in);
    final int personId = scanner.nextInt();

    Person aPerson = dao.findById(personId);

    LOG.info("ending application");
  }

}
