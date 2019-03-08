package fr.imie.bank.dao.bankaccount;

import java.util.List;
import fr.imie.bank.dao.AbstractDao;
import fr.imie.bank.model.BankAccount;

public class BankAccountDaoSqlJdbcImpl extends AbstractDao implements BankAccountDao {

  @Override
  public List<BankAccount> findAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public BankAccount findById(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void save(BankAccount entity) {
    // TODO Auto-generated method stub

  }

  @Override
  public void saveAll(List<BankAccount> entities) {
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
  public List<BankAccount> findByPersonId(int id) {
    // TODO Auto-generated method stub
    return null;
  }

  // TODO utiliser ResultSet et autres elements jdbc

}
