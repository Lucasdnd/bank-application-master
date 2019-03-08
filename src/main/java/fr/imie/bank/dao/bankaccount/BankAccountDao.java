package fr.imie.bank.dao.bankaccount;

import java.util.List;
import fr.imie.bank.dao.Dao;
import fr.imie.bank.model.BankAccount;

public interface BankAccountDao extends Dao<BankAccount> {

	public List<BankAccount> findByPersonId(int id);

}
